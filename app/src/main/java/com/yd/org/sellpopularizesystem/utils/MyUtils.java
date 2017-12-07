package com.yd.org.sellpopularizesystem.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.CalendarContract;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.BaseApplication;
import com.yd.org.sellpopularizesystem.application.ExtraName;
import com.yd.org.sellpopularizesystem.myView.WebViewClientBase;

import java.io.File;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bai on 2017/1/10.
 */

public class MyUtils {

    public static MyUtils utils;

    private MyUtils() {

    }

    public static MyUtils getInstance() {
        if (utils == null) {
            utils = new MyUtils();
        }
        return utils;
    }

    /**
     * 判断网络是否连接，返回false为没有任何连接
     *
     * @param context 上下文
     * @return boolean
     */
    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 是否WI-FI连接状态
     *
     * @param mContext
     * @return 0:无网络;1:Wi-Fi连接;2:移动网络连接
     */
    public int isWifiNetwork(Context mContext) {
        if (!isNetworkConnected(mContext)) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return 1;
        }
        return 2;
    }

    /**
     * 将每三个数字加上逗号处理（通常使用金额方面的编辑）
     *
     * @param str 无逗号的数字
     * @return 加上逗号的数字
     */
    public static String addComma(String str) {
        // 将传进数字反转
        String reverseStr = new StringBuilder(str).reverse().toString();
        String strTemp = "";
        for (int i = 0; i < reverseStr.length(); i++) {
            if (i * 3 + 3 > reverseStr.length()) {
                strTemp += reverseStr.substring(i * 3, reverseStr.length());
                break;
            }
            strTemp += reverseStr.substring(i * 3, i * 3 + 3) + ",";
        }
        // 将[789,456,] 中最后一个[,]去除
        if (strTemp.endsWith(",")) {
            strTemp = strTemp.substring(0, strTemp.length() - 1);
        }
        // 将数字重新反转
        String resultStr = new StringBuilder(strTemp).reverse().toString();
        return resultStr;
    }

    /**
     * MD5加密，32位
     *
     * @param url 需加密的字符串
     * @return 加密后的字符串
     */
    public String MD5(String url) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            // e.printStackTrace();
            return getFile(url);
        }
        char[] charArray = url.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 可逆的加密算法
     */
    public String encryptmd5(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 'l');
        }

        return new String(a);
    }

    /**
     * 将URL转成能够识别的目录
     */
    public String getFile(String url) {
        String path = url;
        if (path.contains("?")) {
            path = path.replace("?", "_");
        }
        if (path.contains("/")) {
            path = path.replace("/", "_");
        }
        if (path.contains(".")) {
            path = path.replace(".", "_");
        }
        return path;
    }

    /**
     * 获取缓存目录中的自定义文件路径
     *
     * @param context  上下文
     * @param path     二级目录，三级目录中间用"/"分隔，前后不需要加"/"
     * @param fileName 文件名，自动转成md5的名字
     * @param isMD5    文件名是否加密
     * @return File
     */
    public File getCache(Context context, String path, String fileName, boolean isMD5) {
        File file = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            file = new File(context.getExternalCacheDir().getPath() + "/" + path);
        } else {
            file = new File(context.getCacheDir() + "/" + path);
        }
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (isMD5) file = new File(file.getPath() + "/" + MD5(fileName));
        else file = new File(file.getPath() + "/" + fileName);
        return file;
    }

    /**
     * 获取缓存目录中的自定义目录
     *
     * @param context 上下文
     * @param path    自定义目录
     * @return File
     */
    public File getCache(Context context, String path) {
        File file = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            file = new File(context.getExternalCacheDir().getPath() + "/" + path);
        } else {
            file = new File(context.getCacheDir() + "/" + path);
        }
        if (file == null) return null;
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /**
     * 获取内部版本号
     *
     * @param context 上下文
     * @return String
     */
    public String getVersionCode(Context context) {
        String versionCode = null;
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS);
            versionCode = String.valueOf(pi.versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取外部版本名称
     *
     * @param context 上下文
     * @return String 版本名称
     */
    public String getVersionName(Context context) {
        String versionName = null;
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS);
            versionName = pi.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 获取设备号（IMEI）
     *
     * @param context 上下文
     * @return String 设备号
     */
    public String getDeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String dwc = null;
        try {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                dwc = tm.getDeviceId();
                dwc = getSN(context);
                return dwc;
            }

        } catch (Exception e) {
            // TODO: handle exception

        }
        return dwc;
    }

    /**
     * 获取设备序列号
     *
     * @param context 上下文
     * @return String
     */
    public String getSN(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * 获取系统版本号
     *
     * @return
     */
    public String getSystemVersionName() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取GUID
     *
     * @return String
     */
    public String GetGUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * 转换时间格式
     *
     * @param format 传入的time的格式，例："yyyy/MM/dd HH:mm:ss"
     * @param time   时间
     * @param isTime true为返回时:分:秒，false为返回年-月-日
     * @return String
     */
    @SuppressLint("DefaultLocale")
    public String parseTime(String format, String time, boolean isTime) {
        if (time != null && !"".equals(time)) {
            Date date = stringToDate(format, time);
            if (date == null) {
                return time;
            }
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            int years = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int ss = calendar.get(Calendar.SECOND);

            if (isTime) {
                return String.format("%02d:%02d:%02d", hour, min, ss);
            }
            return String.format("%d-%02d-%02d", years, month, day);
        }
        return time;
    }

    /**
     * 转换时间格式
     *
     * @param format 传入的time的格式，例："yyyy/MM/dd HH:mm:ss"
     * @param time   时间
     * @return String
     * 返回年-月-日 时:分
     */
    @SuppressLint("DefaultLocale")
    public String parseTime(String format, String time) {
        if (!"".equals(time)) {
            Date date = stringToDate(format, time);
            if (date == null) return time;
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            int years = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int ss = calendar.get(Calendar.SECOND);

            return String.format("%d-%02d-%02d %02d:%02d", years, month, day, hour, min);
        }
        return time;
    }

    //获取时间滚轮数据
    public void getOptionData(Context context, List<String> weeks, List<String> hours, List<String> minutes) {
        Calendar cal = Calendar.getInstance();
        int mYear = cal.get(Calendar.YEAR);
        int mMon = cal.get(Calendar.MONTH) + 1;
        int mDay = cal.get(Calendar.DAY_OF_MONTH);
        int date = cal.get(Calendar.DATE);
        //int daysCountOfYear=cal.getActualMaximum(Calendar.YEAR);
        //cal.setTime(new Date());
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date_start = null;
        Date date_end = null;
        try {
            date_start = sdf.parse(mYear+"-01-01");
            date_end = sdf.parse((mYear+1)+"-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int daysCountOfYear=getGapDayCount(date_start,date_end);*/
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.YEAR, mYear);
        for (int i = 1; i < 13; i++) {
            ca.set(Calendar.MONTH, i);
            int days = 0;
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                days = 32;
            } else if (i == 2) {
                if (mYear % 4 != 0 && mYear % 400 != 0) {
                    days = 29;
                } else {
                    days = 30;
                }
            } else {
                days = 31;
            }
            for (int j = 1; j < days; j++) {
                if (i == mMon && j == mDay) {
                    weeks.add(context.getString(R.string.today));
                } else {
                    String dayOfWeek = MyUtils.getInstance().getdayOfWeek(ca, i, j);
                    String str = i + "月" + j + "日" + "周" + dayOfWeek;
                    weeks.add(str);
                }

            }
        }
        for (int i = 0; i < 24; i++) {
            hours.add(String.format("%02d", i));
        }
        for (int i = 0; i < 60; i++) {
            minutes.add(String.format("%02d", i));
        }
    }

    //根据日期判断星期几
    public String getdayOfWeek(Calendar ca, int i, int j) {
        ca.set(Calendar.MONTH, i - 1);
        ca.set(Calendar.DAY_OF_MONTH, j);
        int dayOfWeek = ca.get(Calendar.DAY_OF_WEEK);
        String str = "null";
        switch (dayOfWeek) {
            case 1:
                str = "日";
                break;
            case 2:
                str = "一";
                break;
            case 3:
                str = "二";
                break;
            case 4:
                str = "三";
                break;
            case 5:
                str = "四";
                break;
            case 6:
                str = "五";
                break;
            case 7:
                str = "六";
                break;
        }
        return str;
    }

    /**
     * 根据2个日期求出之间的天数
     *
     * @param start_date
     * @param end_date
     * @return
     */
    public int getGapDayCount(Date start_date, Date end_date) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(start_date);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(end_date);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);
        return (int) ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
    }

    //根据时间格式获取毫秒数
    public long getTimeMillis(View view) {
        long millis = 0;
        String[] reservDate = new String[2];
        String[] reservTime = new String[2];
        if (view instanceof EditText) {
            // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String[] reserv = ((EditText) view).getText().toString().trim().split("\\s+");//根据03/14 08:29形式拆分
            Log.e("reserv", "getTimeMillis: " + reserv[1] + ((EditText) view).getText().toString().trim());
            reservDate = reserv[0].split("\\/");//得到03 14
            reservTime = reserv[1].split("\\:");//得到08 29
            Log.e("reservDate", "getTimeMillis: " + reservDate[0] + reservDate[1]);
        }
        Calendar dateCal = Calendar.getInstance();
        //Log.e("tag", "TimeMillis: ");
        //Log.e("time", dateCal.get(Calendar.YEAR) + "-" + reservDate[0] + "-" + reservDate[1] + getString(R.string.single_blank_space) + reservTime[0] + ":" + reservTime[1] + ":00");
        //Date date1 = sdf.parse(String.valueOf(dateCal.get(Calendar.YEAR)) + "-" + reservDate[0] + "-" + reservDate[1] +getString(R.string.single_blank_space)+ reserv[1]+":00");
        dateCal.set(dateCal.get(Calendar.YEAR), Integer.parseInt(reservDate[0]) - 1, Integer.parseInt(reservDate[1]), Integer.parseInt(reservTime[0]), Integer.parseInt(reservTime[1]), 00);
        // millis = date1.getTime();
        millis = dateCal.getTimeInMillis();
        Log.e("millis", "getTimeMillis: " + millis);
        return millis;
    }

    //向日历中插入事件
    public void submitToCalendar(Activity activity, long reserverTime, long reminderTime, String string) {
        //获取日历账户id
        Log.e("TAG", "submit: " + reserverTime + "\n" + reminderTime);
        String calId = "";
        Cursor userCursor = activity.getContentResolver().query(Uri.parse(ExtraName.CALANDERURL), null, null, null, null);
        if (userCursor.getCount() > 0) {
            //注意：是向最后一个账户添加，开发者可以根据需要改变添加事件 的账户
            userCursor.moveToLast();
            calId = userCursor.getString(userCursor.getColumnIndex("_id"));
        } else {
            Toast.makeText(activity, activity.getString(R.string.noaccount), Toast.LENGTH_SHORT).show();
            return;
        }
        ContentValues event = new ContentValues();
        event.put("title", activity.getString(R.string.askdate));
        event.put("description", string != null ? string : "");
        event.put(CalendarContract.Events.CALENDAR_ID, calId);
        //添加事件时间
        Calendar mCalendar = Calendar.getInstance();
            /*String[] resevers = etReserTime.getText().toString().split("\\/");
            mCalendar.set(mCalendar.get(Calendar.YEAR), Integer.parseInt(resevers[0]), Integer.parseInt(resevers[1]));//设置开始时间*/
        long start = reserverTime;
        mCalendar.setTimeInMillis(start + 3600000);//设置终止时间
        long end = mCalendar.getTime().getTime();
        event.put(CalendarContract.Events.DTSTART, start);
        event.put(CalendarContract.Events.DTEND, end);
        event.put(CalendarContract.Events.HAS_ALARM, 1);//设置有闹钟提醒
        event.put(CalendarContract.Events.EVENT_TIMEZONE, "Asia/Shanghai");//这个是时区，必须有，
        //添加事件
        Uri newEvent = activity.getContentResolver().insert(Uri.parse(ExtraName.CALANDEREVENTURL), event);
        if (newEvent == null) {
            // 添加日历事件失败直接返回
            return;
        }
        //事件提醒的设定
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Reminders.EVENT_ID, ContentUris.parseId(newEvent));
        long id = Long.parseLong(newEvent.getLastPathSegment());
        values.put(CalendarContract.Reminders.EVENT_ID, id);
        // 计算预约日期和提醒日期差值
        //long mins = getGapTime("mins");
        long mins = getGapTime("mins", (reserverTime - reminderTime));
        Log.e("tag", "submit: " + mins);
        //设置提前多少分钟
        values.put(CalendarContract.Reminders.MINUTES, mins);
        //设置提醒方式
        values.put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT);
        //向日历中插入提醒事件
        activity.getContentResolver().insert(Uri.parse(ExtraName.CALANDERREMIDERURL), values);

    }

    //计算2个时间间隔时长
    public long getGapTime(String str, long timeInterval) {
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String[] reserv = etReserTime.getText().toString().split("\\ ");//根据03/14 08:29形式拆分
        String[] reservDate = reserv[0].split("\\/");//得到03 14
        String[] reminder = etRemindTime.getText().toString().split("\\ ");//根据03/14 08:25形式拆分
        String[] reminDate1 = reminder[0].split("\\/");//得到03 14
        Log.e("TAG", "submit: " + etRemindTime.getText().toString());
        Calendar dateCal = Calendar.getInstance();*/
        long days = 0;
        long hours = 0;
        long mins = 0;
        long diff = 0;
        long time = 0;
        //try {
            /*Date date1 = sdf.parse(dateCal.get(Calendar.YEAR) + "-" + reservDate[0] + "-" + reservDate[1] + getString(R.string.single_blank_space) + reserv[1]);
            Date date2 = sdf.parse(dateCal.get(Calendar.YEAR) + "-" + reminDate1[0] + "-" + reminDate1[1] + getString(R.string.single_blank_space) + reminder[1]);
            // 计算预约日期和提醒日期差值
            diff = date1.getTime() - date2.getTime();*/
        diff = timeInterval;
        days = diff / (1000 * 60 * 60 * 24);
        //hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        hours = diff / (1000 * 60 * 60);
        //mins = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
        mins = diff / (1000 * 60);
        Log.e("diff", "getGapTime: " + diff);
        Log.e("diff", "getGapTime: " + days);
        Log.e("diff", "getGapTime: " + hours);
        /*} catch (ParseException e) {
            e.printStackTrace();
        }*/
        if (str.equals("days")) {
            time = days;
        } else if (str.equals("hours")) {
            time = hours;
        } else if (str.equals("mins")) {
            time = mins;
            Log.e("Time", "getGapTime: " + time);
        } else {
            time = diff;
        }
        Log.e("Time", "getGapTime: " + time);
        return time;
    }

    /**
     * 24小时制转12小时制
     *
     * @param time   24小时制的时间
     * @param format 时间时与分的间隔符号
     * @return 返回hh:mm Am/Pm.没有秒
     */
    public String parseTime24To12(String time, String format) {
        if (time == null || time.length() < 5 || format == null || format.length() == 0 || (!time.contains(format))) {
            return time;
        }
        time = time.substring(0, 5);
        String time12 = null;
        String[] times = time.split(format);
        if (times == null || times.length < 2) {
            return time;
        }
        int h = Parse.getInstance().parseInt(times[0]);
        int m = Parse.getInstance().parseInt(times[1]);
        String p = "Am";
        if (h == 0 || h == 24) {
            h = 12;
        } else if (h >= 12) {
            p = "Pm";
            if (h > 12) h -= 12;
        }
        time12 = String.format("%02d:%02d ", h, m) + p;
        return time12;
    }

    /**
     * String类型的时间转Date
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public Date stringToDate(String format, String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.CHINA);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
        }
        return null;
    }


    /**
     * 时间戳转换成时间字符窜
     *
     * @param format 时间格式
     * @param time   时间戳
     * @return
     */
    public static String date2String(String format, long time) {
        try {
            Date d = new Date(time);
            SimpleDateFormat sf = new SimpleDateFormat(format);
            return sf.format(d);
        }catch (Exception e){
            e.printStackTrace();

        }

        return "";

    }

    /**
     * 将时间字符串转为时间戳
     *
     * @param format 时间格式
     * @param time   时间
     * @return
     */
    public long string2Date(String format, String time) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        try {
            date = sdf.parse(time);
            return date.getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            Log.e("error", "将字符串转换为时间戳异常");
            return 0;
        }
    }


    /**
     * 设置颜色并四舍五入
     *
     * @param context  上下文
     * @param text     需要比对的数值
     * @param dou      进行比对的数
     * @param num      小数保留位数
     * @param isJiaHao 正数前是否加＋号
     * @return
     */
    public SpannableString formatText(Context context, double text, double dou, int num, boolean isJiaHao) {
        String str = String.format("%." + num + "f", text);
        int color;
        String n = "#.";
        for (int i = 0; i < num; i++) {
            n += "#";
        }
        double d = Parse.getInstance().parseDouble(str, n);

        if (d == 0) {
            str = "--";
            color = Color.GRAY;
        } else {
            dou = Parse.getInstance().parseDouble(dou, n);
            if (d > dou) {
                if (isJiaHao) str = "+" + str;
                color = Color.RED;
            } else if (d < dou) color = Color.GREEN;
            else color = Color.GRAY;
        }

        SpannableString spa = new SpannableString(str);
        spa.setSpan(new ForegroundColorSpan(color), 0, str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spa;
    }

    /**
     * 设置颜色并四舍五入 针对白银，无小数点
     *
     * @param context  上下文
     * @param text     需要比对的数值
     * @param dou      进行比对的数
     * @param isJiaHao 正数前是否加＋号
     * @return
     */
    public SpannableString formatText1(Context context, double text, double dou, boolean isJiaHao) {
        String str = String.format("%.2f", text);
        int color;
        double d = Parse.getInstance().parseDouble(str, "#.##");
        if (d == 0) {
            str = "--";
            color = Color.GRAY;
        } else {
            dou = Parse.getInstance().parseDouble(dou, "#.##");
            if (d > dou) {
                if (isJiaHao) str = "+" + str;
                color = Color.RED;
            } else if (d < dou) color = Color.GREEN;
            else color = Color.GRAY;
        }

        str = str.substring(0, str.length() - 3);
        SpannableString spa = new SpannableString(str);
        spa.setSpan(new ForegroundColorSpan(color), 0, str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spa;
    }

    public static String getTime(String fort, Date date) {
        SimpleDateFormat format = new SimpleDateFormat(fort);
        return format.format(date);
    }


    /**
     * 获取24小时格式的当前系统时间
     *
     * @param format time的格式，例："yyyy/MM/dd HH:mm:ss"
     * @param locale 时区，例：Locale.CHINA（代表中国时区）
     */
    public String getTime24(String format, Locale locale) {
        if (format.contains("h")) {
            format = format.replace("h", "H");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
        return sdf.format(new Date());
    }

    /**
     * 获取12小时格式的当前系统时间
     *
     * @param format time的格式，例："yyyy/MM/dd hh:mm:ss"
     * @param locale 时区，例：Locale.CHINA（代表中国时区）
     */
    public String getTime12(String format, Locale locale) {
        if (format.contains("H")) {
            format = format.replace("H", "h");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
        return sdf.format(new Date());
    }


    /**
     * 键盘隐藏并把焦点置为false
     *
     * @param context   上下文
     * @param editTexts EditText数组
     */
    public void setKeyBoardFocusable(Context context, EditText... editTexts) {
        for (int i = 0; i < editTexts.length; i++) {
            editTexts[i].setFocusable(false);
            editTexts[i].setFocusableInTouchMode(false);
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editTexts[i].getWindowToken(), 0);
        }
    }

    /**
     * 键盘隐藏
     *
     * @param context 上下文
     * @param views   EditText数组
     */
    public void setKeyBoardGone(Context context, View... views) {
        for (int i = 0; i < views.length; i++) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(views[i].getWindowToken(), 0);
        }
    }

    /**
     * 输入法在窗口上已经显示，则隐藏，反之则显示
     *
     * @param context
     */
    public void setKeyBoard(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 显示软键盘
     *
     * @param context
     */
    public void setKeyBoardVisibility(Context context, EditText... editTexts) {
        for (int i = 0; i < editTexts.length; i++) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(editTexts[i], InputMethodManager.SHOW_FORCED);
        }
    }


    /**
     * 查看密码
     *
     * @param mEditText
     * @param isView    是否查看,true查看,false隐藏
     */
    public void viewPassword(EditText mEditText, boolean isView) {
        if (mEditText == null) {
            throw new NullPointerException();
        } else {
            int cursorPosition = mEditText.getSelectionStart();
            if (isView) {
                mEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                mEditText.setSelection(cursorPosition);
            } else {
                mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                mEditText.setSelection(cursorPosition);
            }
        }
    }

    /**
     * 根据传进来的日期时间计算年龄
     *
     * @param format
     * @param date
     * @return 年龄
     */
    public int getAge(String format, String date) {
        date = parseTime(format, date, false);
        if (date == null || date.length() < 10 || !date.contains("-")) {
            return 0;
        }
        date = date.substring(0, 10);
        String[] dates = date.split("-");
        if (dates == null || dates.length < 3) {
            return 0;
        }
        String today = MyUtils.date2String("yyyy/MM/dd", System.currentTimeMillis());
        int year = Parse.getInstance().parseInt(today.substring(0, 4));
        int month = Parse.getInstance().parseInt(today.substring(5, 7));
        int day = Parse.getInstance().parseInt(today.substring(8, 10));

        int yearOld = Parse.getInstance().parseInt(dates[0]);
        int monthOld = Parse.getInstance().parseInt(dates[1]);
        int dayOld = Parse.getInstance().parseInt(dates[2]);

        int age = year - yearOld;
        if (month - monthOld < 0) {
            age -= 1;
        } else if (month - monthOld == 0) {
            if (day - dayOld < 0) {
                age -= 1;
            }
        }
        if (age < 0) age = 0;
        return age;
    }


    /**
     * 用于获取状态栏的高度。 使用Resource对象获取（推荐这种方式）
     *
     * @return 返回状态栏高度的像素值。
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    //将dp转化为px
    public static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public int getScreenSize(Activity context) {
        WindowManager wm = context.getWindowManager();
        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }

    /**
     * 得到上下文
     *
     * @return
     */
    public static Context getContext() {
        return BaseApplication.getContext();
    }

    /**
     * 得到应用程序的包名
     *
     * @return
     */
    public static String getPackageName() {
        return getContext().getPackageName();
    }


    public void showWebView(Activity activity, WebView view, String url) {
        WebSettings webSettings = view.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        webSettings.setDomStorageEnabled(true);
        view.setWebViewClient(new WebViewClientBase(activity));
        view.loadUrl(url);
    }

    public static boolean isContainChinese(String str) {


        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
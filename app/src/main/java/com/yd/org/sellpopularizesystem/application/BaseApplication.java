package com.yd.org.sellpopularizesystem.application;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.igexin.sdk.PushManager;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.pgyersdk.crash.PgyCrashManager;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.activity.HomeActivity;
import com.yd.org.sellpopularizesystem.fragment.HomeFragment;
import com.yd.org.sellpopularizesystem.javaBean.MyUserInfo;
import com.yd.org.sellpopularizesystem.javaBean.ProductDetailBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.converter.SerializableDiskConverter;

import java.io.File;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;


/**
 * Created by bai on 2017/1/10.
 */

public class BaseApplication extends Application {
    public static BaseApplication mApp;
    private ProductDetailBean.ResultBean prs;
    private static MainHandler handler;
    private int is_firb, firb_number;
    private static Context mContext;
    public MyUserInfo myUserInfo = new MyUserInfo();
    //腾讯更新
    public static final String APP_ID = "c59ee68679";
    public static final String APP_Test = "2dfe5cbc5e";
    //个推识别码
    public String cid = "";


    public static BaseApplication getInstance() {
        return mApp;
    }


    public class MainHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:

                    try {
                        Log.e("返回消息数据**", "0:" + msg.obj);
                        Message message = new Message();
                        message.obj = msg.obj;
                        msg.what = 1;
                        if (null != HomeActivity.homeActiviyt) {
                            //通知首页显示Toas提示消息内容
                            HomeActivity.homeActiviyt.showToasHandler.sendMessage(message);
                            //更新未读消息数据
                            HomeFragment.homeFragment.mHandler.sendEmptyMessage(1);
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }

                    break;

                case 1:
                    Log.e("监听消息变化**", "1:" + msg.obj);
                    break;
            }
        }
    }


    public void sendMessage(Message msg) {
        handler.sendMessage(msg);
    }


    //解决65536问题
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initView();
        bugly();


        //通过配置方案来初始化ImageLoader
        ImageLoader.getInstance().init(getSimpleConfig());

        //初始化网络请求
        EasyHttp.init(this);
        initEasyHttp();

        //蒲公英
        PgyCrashManager.register(getApplicationContext());


    }


    private void initEasyHttp() {

        EasyHttp.getInstance()
                .debug("RxEasyHttp", true)
                .setReadTimeOut(60 * 1000)
                .setWriteTimeOut(60 * 1000)
                .setConnectTimeout(60 * 1000)
                .setRetryCount(3)//默认网络不好自动重试3次
                .setRetryDelay(500)//每次延时500ms重试
                .setRetryIncreaseDelay(500)//每次延时叠加500ms
                .setBaseUrl(Contants.DOMAIN)
                .setCacheDiskConverter(new SerializableDiskConverter())//默认缓存使用序列化转化
                .setCacheMaxSize(100 * 1024 * 1024)//设置缓存大小为50M
                .setCacheVersion(1)//缓存版本为1
                .setHostnameVerifier(new UnSafeHostnameVerifier(Contants.DOMAIN))//全局访问规则
                .setCertificates();//信任所有证书;


    }

    public class UnSafeHostnameVerifier implements HostnameVerifier {
        private String host;

        public UnSafeHostnameVerifier(String host) {
            this.host = host;
        }

        @Override
        public boolean verify(String hostname, SSLSession session) {
            if (this.host == null || "".equals(this.host) || !this.host.contains(hostname))
                return false;
            return true;
        }
    }


    /**
     * 比较常用的配置方案
     *
     * @return
     */
    private ImageLoaderConfiguration getSimpleConfig() {
        //设置缓存的路径
        File cacheDir = StorageUtils.getOwnCacheDirectory(getApplicationContext(), "imageloader/Cache");

        ImageLoaderConfiguration config = new ImageLoaderConfiguration
                .Builder(getApplicationContext())
                .memoryCacheExtraOptions(480, 800) //即保存的每个缓存文件的最大长宽
                .threadPriority(Thread.NORM_PRIORITY) //线程池中线程的个数
                .denyCacheImageMultipleSizesInMemory() //禁止缓存多张图片
                .memoryCache(new LRULimitedMemoryCache(50 * 1024 * 1024)) //缓存策略
                .memoryCacheSize(10 * 1024 * 1024) //设置内存缓存的大小
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) //缓存文件名的保存方式
                .diskCacheSize(10 * 1024 * 1024) //磁盘缓存大小
                .tasksProcessingOrder(QueueProcessingType.LIFO) //工作队列
                .diskCacheFileCount(200) //缓存的文件数量
                .diskCache(new UnlimitedDiskCache(cacheDir)) //自定义缓存路径
                .build();
        return config;
    }


    private void initView() {
        //获取设备的cid,用于绑定账号用
        cid = PushManager.getInstance().getClientid(this);
        //设置友盟
        Config.DEBUG = false;
        UMShareAPI.get(this);
        //微信
        PlatformConfig.setWeixin(Contants.WEXIN_APP_ID, Contants.WEXIN_APP_SECRET);
        if (handler == null) {
            handler = new MainHandler();
        }
    }


    private void bugly() {
        /**** Beta高级设置*****/
        /**
         * true表示app启动自动初始化升级模块；
         * false不好自动初始化
         * 开发者如果担心sdk初始化影响app启动速度，可以设置为false
         * 在后面某个时刻手动调用
         */
        Beta.autoInit = true;

        /**
         * true表示初始化时自动检查升级
         * false表示不会自动检查升级，需要手动调用Beta.checkUpgrade()方法
         */
        Beta.autoCheckUpgrade = true;

        /**
         * 设置升级周期为60s（默认检查周期为0s），60s内SDK不重复向后天请求策略
         */
        Beta.initDelay = 1 * 1000;

        /**
         * 设置通知栏大图标，largeIconId为项目中的图片资源；
         */
        Beta.largeIconId = R.mipmap.app;

        /**
         * 设置状态栏小图标，smallIconId为项目中的图片资源id;
         */
        Beta.smallIconId = R.mipmap.app;


        /**
         * 设置更新弹窗默认展示的banner，defaultBannerId为项目中的图片资源Id;
         * 当后台配置的banner拉取失败时显示此banner，默认不设置则展示“loading“;
         */
        Beta.defaultBannerId = R.mipmap.app;

        /**
         * 设置sd卡的Download为更新资源保存目录;
         * 后续更新资源会保存在此目录，需要在manifest中添加WRITE_EXTERNAL_STORAGE权限;
         */
        Beta.storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        /**
         * 点击过确认的弹窗在APP下次启动自动检查更新时会再次显示;
         */
        Beta.showInterruptedStrategy = false;

        /**
         * 只允许在MainActivity上显示更新弹窗，其他activity上不显示弹窗;
         * 不设置会默认所有activity都可以显示弹窗;
         */
        Beta.canShowUpgradeActs.add(HomeActivity.class);

        /**
         *  设置自定义升级对话框UI布局
         *  注意：因为要保持接口统一，需要用户在指定控件按照以下方式设置tag，否则会影响您的正常使用：
         *  标题：beta_title，如：android:tag="beta_title"
         *  升级信息：beta_upgrade_info  如： android:tag="beta_upgrade_info"
         *  更新属性：beta_upgrade_feature 如： android:tag="beta_upgrade_feature"
         *  取消按钮：beta_cancel_button 如：android:tag="beta_cancel_button"
         *  确定按钮：beta_confirm_button 如：android:tag="beta_confirm_button"
         *  详见layout/upgrade_dialog.xml
         */
        Beta.upgradeDialogLayoutId = R.layout.upgrade_dialog;


        /**
         * 已经接入Bugly用户改用上面的初始化方法,不影响原有的crash上报功能;
         * init方法会自动检测更新，不需要再手动调用Beta.checkUpdate(),如需增加自动检查时机可以使用Beta.checkUpdate(false,false);
         * 参数1： applicationContext
         * 参数2：appId
         * 参数3：是否开启debug
         *
         *
         */


        //正式版
        if (Contants.DOMAIN.contains("https://www.wingaid.com")) {
            Bugly.init(getApplicationContext(), APP_ID, true);
        } else {
            Bugly.init(getApplicationContext(), APP_Test, true);
        }


    }


    public BaseApplication() {
        mApp = this;
    }

    public static Context getContext() {
        return mContext;
    }


    public ProductDetailBean.ResultBean getPrs() {
        return prs;
    }

    public void setPrs(ProductDetailBean.ResultBean prs) {
        this.prs = prs;
    }


    public int getIs_firb() {
        return is_firb;
    }

    public void setIs_firb(int is_firb) {
        this.is_firb = is_firb;
    }

    public int getFirb_number() {
        return firb_number;
    }

    public void setFirb_number(int firb_number) {
        this.firb_number = firb_number;
    }
}

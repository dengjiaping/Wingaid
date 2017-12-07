package com.yd.org.sellpopularizesystem.getui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;

import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.activity.HomeActivity;
import com.yd.org.sellpopularizesystem.activity.LoginActivity;
import com.yd.org.sellpopularizesystem.application.BaseApplication;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;

/**
 * 继承 GTIntentService 接收来自个推的消息, 所有消息在线程中回调, 如果注册了该服务, 则务必要在 AndroidManifest中声明, 否则无法接受消息<br>
 * onReceiveMessageData 处理透传消息<br>
 * onReceiveClientId 接收 cid <br>
 * onReceiveOnlineState cid 离线上线通知 <br>
 * onReceiveCommandResult 各种事件处理回执 <br>
 */
public class IntentService extends GTIntentService {
    private static final String TAG = "GetuiSdkDemo";

    public IntentService() {

    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {
        Log.d(TAG, "onReceiveServicePid -> " + pid);
    }

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        String appid = msg.getAppid();
        String taskid = msg.getTaskId();
        String messageid = msg.getMessageId();
        byte[] payload = msg.getPayload();
        String pkg = msg.getPkgName();
        String cid = msg.getClientId();


        // 第三方回执调用接口，actionid范围为90000-90999，可根据业务场景执行
        boolean result = PushManager.getInstance().sendFeedbackMessage(context, taskid, messageid, 90001);
        Log.e(TAG, "call sendFeedbackMessage = " + (result ? "success" : "failed"));
        Log.e(TAG, "onReceiveMessageData -> " + "appid = " + appid + "\ntaskid = " + taskid + "\nmessageid = " + messageid + "\npkg = " + pkg
                + "\ncid = " + cid);

        if (payload != null) {
            //如果收到消息更新数据
            String data = new String(payload);
            Log.e(TAG, "receiver payload = " + data + "::" + msg.getPayloadId());
            //向app系统中发送通知,用于更新未读消息数量
            sendMessage(data, 0);
            //状态栏消息通知
            setNotificationManager(getString(R.string.gettui), data);
        }

    }

    @Override
    public void onReceiveClientId(Context context, String clientid) {
        sendMessage(clientid, 1);

    }

    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
        Log.e(TAG, "onReceiveOnlineState -> " + (online ? "online" : "offline"));
    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
        Log.e(TAG, "onReceiveCommandResult -> " + cmdMessage);

    }


    private void sendMessage(String data, int what) {
        try {
            Message msg = Message.obtain();
            msg.what = what;
            msg.obj = data;
            BaseApplication.mApp.sendMessage(msg);

        } catch (NullPointerException e) {

        }


    }

    private void setNotificationManager(String title, String message) {


        try {
            //实例化通知管理器
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            //实例化通知
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setContentTitle(title);//设置通知标题
            builder.setContentText(message);//设置通知内容
            builder.setDefaults(NotificationCompat.DEFAULT_ALL);//设置通知的方式，震动、LED灯、音乐等
            builder.setAutoCancel(true);//点击通知后，状态栏自动删除通知
            builder.setSmallIcon(R.mipmap.notification);//设置小图标
            builder.setWhen(System.currentTimeMillis());//shijain


            //未登录
            if (SharedPreferencesHelps.getUserID().equals("null") || TextUtils.isEmpty(SharedPreferencesHelps.getUserID()) || SharedPreferencesHelps.getUserID() == null) {
                builder.setContentIntent(PendingIntent.getActivity(this, 0x102, new Intent(this, LoginActivity.class), 0));//设置点击通知后将要启动的程序组件对应的PendingIntent
            } else {
                //已登录
                builder.setContentIntent(PendingIntent.getActivity(this, 0x102, new Intent(this, HomeActivity.class), 0));//设置点击通知后将要启动的程序组件对应的PendingIntent
            }


            Notification notification = builder.build();
            //发送通知
            notificationManager.notify((int) (Math.random() * 1000000), notification);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
}

package com.yd.org.sellpopularizesystem.application;

/**
 * Created by bai on 2017/1/13.
 */

public class ExtraName {
    public static final String ACCOUNT = "account";
    public static final String OPENID ="openid";
    public static final String USER_PASSWORD = "password";
    public static final String USER_ID = "user_id";
    public static final String COMPANY_ID = "company_id";
    public static final String COMPANY_NAME = "company_name";
    public static final String HEAD_IMAGE = "user_image";
    public static final String USER_TYPE= "user_type";
    public static final String FIRST_NAME = "first_name";
    public static final String SUR_NAME = "sur_name";
    public static final String HISTORY_NAME="history";
    public static final String SHAREDPREFERENCES_NAME="search_history";
    //代表筛选的范围,0x001表示区域,0x002表示房型,0x003表示面积,0x004表示价格
    public static  final int AREA = 0x001;
    public static  final int HOURSE = 0x002;
    public static  final int TYPE = 0x003;
    public static  final int PRICE = 0x004;
    public static  final int TAKE_PICTURE = 0x005;
    public static  final int ALBUM_PICTURE = 0x006;
    public static  final int SELECT_PIC_KITKAT = 0x0061;
    // 裁剪图片参数
    public static final int CROP_IMAGE = 0x007;
    public static final int RESERVE_TO_CUSTOME =0x008;
    public static final int RESERVE_TO_LAWYER=0x009;
    //更新
    public static final int UPDATE=0x010;
    public static final String VISIBILITY="1";
    public static final String INVISIBILITY="2";
    //充值成功
    public static final int SUCCESS=0x011;
    //点击销售推广跳转customeactivity标志
    public static final String SCALETOCUSTOME="from_scale_to_custome";
    //点击往期项目跳转customeactivity标志
    public static final String OLDPROTOCUSTOME="from_old_to_custome";
    //点击律师列表跳转预约列表
    public static final String RESVERTOLAWYER="from_lawyer_to_resver";
    //点击客户管理跳转customeActivity标志
    public static final String TOCUSTOME="to_custome";
    //点击跳转预定界面
    public static final String TORESVER ="to_resver";
    public static final String TORESVER_TOCUSTOME ="to_resvercustome";
    //上传合同
    public static final String UPLOAD_CONTRACT="upload_contract";
    //上传首付款
    public static final String UPLOAD_FIRST_COMMISSION="upload_first_commission";
    //日历事件相关url
    public static final String CALANDERURL = "content://com.android.calendar/calendars";
    public static final String CALANDEREVENTURL = "content://com.android.calendar/events";
    public static final String CALANDERREMIDERURL = "content://com.android.calendar/reminders";
    public static final String PROJECT_STATUS = "project_status";
    public static final String DEPOSIT_NUM = "deposit_num";
}

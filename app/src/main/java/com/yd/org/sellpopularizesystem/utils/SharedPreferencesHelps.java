package com.yd.org.sellpopularizesystem.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.yd.org.sellpopularizesystem.application.BaseApplication;
import com.yd.org.sellpopularizesystem.application.ExtraName;

/**
 * Created by Administrator on 2015/10/13.
 * <p/>
 * SharedPreferences统一类
 */
public class SharedPreferencesHelps {

    public static Activity activityInstance = null;
    private static SharedPreferences preferences = null;

    public static final SharedPreferences getPreferences() {
        if (preferences == null) {
            preferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getInstance().getApplicationContext());
        }
        return preferences;
    }

    /**
     * 是否是第一次登陆
     *
     * @return
     */

    public synchronized static final boolean getIsFirstLauncher() {
        return getPreferences().getBoolean("IsFirstLauncher", true);
    }

    public synchronized static final void setIsFirstLauncher(boolean IsFirstLauncher) {
        getPreferences().edit().putBoolean("IsFirstLauncher", IsFirstLauncher).commit();
    }

    /**
     * 保存用户
     *
     * @param account
     */

    public synchronized static final void setAccount(String account) {
        getPreferences().edit().putString(ExtraName.ACCOUNT, account).commit();
    }

    public synchronized static final void cleaAccount() {
        getPreferences().edit().remove(ExtraName.ACCOUNT).commit();
    }

    public synchronized static final String getAccount() {
        return getPreferences().getString(ExtraName.ACCOUNT, "null");
    }

    //获取名字
    public synchronized static final String getFirstName() {
        return getPreferences().getString(ExtraName.FIRST_NAME, "null");
    }

    //设置名字
    public synchronized static final void setFirstName(String firstName) {
        getPreferences().edit().putString(ExtraName.FIRST_NAME, firstName).commit();
    }

    //获取名字编号
    public synchronized static final String getSurName() {
        return getPreferences().getString(ExtraName.SUR_NAME, "null");
    }

    //设置名字编号
    public synchronized static final void setSurName(String surName) {
        getPreferences().edit().putString(ExtraName.SUR_NAME, surName).commit();
    }

    /**
     * 保存用户ID
     *
     * @param id
     */

    public synchronized static final void setUserID(String id) {
        getPreferences().edit().putString(ExtraName.USER_ID, id).commit();
    }

    public synchronized static final void clearUserID() {
        getPreferences().edit().remove(ExtraName.USER_ID).commit();
    }

    public synchronized static final String getUserID() {
        return getPreferences().getString(ExtraName.USER_ID, "null");
    }

    public synchronized static final void setCompanyId(String companyId) {
        getPreferences().edit().putString(ExtraName.COMPANY_ID, companyId).commit();
    }

    public synchronized static final String getCompanyId() {
        return getPreferences().getString(ExtraName.COMPANY_ID, "null");
    }

    public synchronized static final void setCompanyName(String companyId) {
        getPreferences().edit().putString(ExtraName.COMPANY_NAME, companyId).commit();
    }

    public synchronized static final String getCompanyNmae() {
        return getPreferences().getString(ExtraName.COMPANY_NAME, "null");
    }

    //获取历史记录
    public synchronized static final String getHistory() {
        return getPreferences().getString(ExtraName.HISTORY_NAME, "");

    }

    //保存历史记录
    public synchronized static final void editHistory(String name, boolean bool) {
        if (bool) {
            getPreferences().edit().putString(ExtraName.HISTORY_NAME, name).commit();
        } else {
            getPreferences().edit().clear().commit();
        }

    }

    /**
     * 保存头像
     *
     * @param name
     */
    public synchronized static final void setUserImage(String name) {
        getPreferences().edit().putString(ExtraName.HEAD_IMAGE, name).commit();
    }

    public synchronized static final void clearUserImage() {
        getPreferences().edit().remove(ExtraName.HEAD_IMAGE).commit();
    }

    public synchronized static final String getUserImage() {
        return getPreferences().getString(ExtraName.HEAD_IMAGE, "null");
    }

    public synchronized static final void setLanguage(String language) {
        getPreferences().edit().putString("language", language).commit();
    }

    public synchronized static final String getLanguage() {
        return getPreferences().getString("language", "null");
    }


    /**
     * 保存用户密码
     *
     * @param password
     */

    public synchronized static final void setUserPassword(String password) {
        getPreferences().edit().putString(ExtraName.USER_PASSWORD, password).commit();
    }

    public synchronized static final void clearUserPassword() {
        getPreferences().edit().remove(ExtraName.USER_PASSWORD).commit();
    }

    public synchronized static final String getUserPassword() {
        return getPreferences().getString(ExtraName.USER_PASSWORD, "null");
    }

    //设置openid
    public synchronized static final void setOpenId(String openId) {
        getPreferences().edit().putString(ExtraName.OPENID, openId).commit();
    }

    //获取openid
    public synchronized static final String getOpenId() {
        return getPreferences().getString(ExtraName.OPENID, "null");
    }

    /**
     * 保存推广记录
     */


    public synchronized static final void setData(String data) {
        getPreferences().edit().putString("data", data).commit();
    }

    public synchronized static final void clearData() {
        getPreferences().edit().remove("data").commit();
    }

    public synchronized static final String getData() {
        return getPreferences().getString("data", "null");
    }


    /**
     * 保存推广时间戳
     */
    public synchronized static final void setTime(String time) {
        getPreferences().edit().putString("time", time).commit();
    }

    public synchronized static final void clearTime() {
        getPreferences().edit().remove("time").commit();
    }

    public synchronized static final String getTime() {
        return getPreferences().getString("time", "null");
    }


    /**
     * 保存销售type
     *
     * @param type
     */
    public synchronized static final void setType(int type) {
        getPreferences().edit().putInt(ExtraName.USER_TYPE, type).commit();
    }

    public synchronized static final void clearType() {
        getPreferences().edit().remove(ExtraName.USER_TYPE).commit();
    }

    public synchronized static final int getType() {
        return getPreferences().getInt(ExtraName.USER_TYPE, 1);
    }


    /**
     * 保存销售推荐人id
     *
     * @param referCode
     */
    public synchronized static final void setReferCode(String referCode) {
        getPreferences().edit().putString("ReferCode", referCode).commit();
    }

    public synchronized static final void clearReferCode() {
        getPreferences().edit().remove("ReferCode").commit();
    }

    public synchronized static final String getReferCode() {
        return getPreferences().getString("ReferCode", "");
    }




    public  synchronized static final void setProjectStatus(String name) {
        getPreferences().edit().putString(ExtraName.PROJECT_STATUS, name).commit();
    }

    public synchronized static final String getProjectStatus() {
        return getPreferences().getString(ExtraName.PROJECT_STATUS, "new");
    }

    public  synchronized static final void setDeposit_num(String name) {
        getPreferences().edit().putString(ExtraName.DEPOSIT_NUM, name).commit();
    }

    public synchronized static final String getDeposit_num() {
        return getPreferences().getString(ExtraName.DEPOSIT_NUM, "0");
    }

}

package com.yd.org.sellpopularizesystem.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.activity.HomeActivity;
import com.yd.org.sellpopularizesystem.activity.InvestigationActivity;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.application.ExtraName;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hejin on 2017/2/28.
 */

public class LastFragmentView extends BaseFragmentView {
    public TextView tvStart;
    public TextView tvEnd;
    private String type = null;
    private String studyId;

    public static LastFragmentView getInstnce(String type, String studyId) {
        LastFragmentView photoViewFragment = new LastFragmentView();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        bundle.putString("study_id", studyId);
        photoViewFragment.setArguments(bundle);
        return photoViewFragment;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.last_pager_layout);
        type = getArguments().getString("type");
        studyId = getArguments().getString("study_id");
        tvStart = getViewById(R.id.tvStartInvestigation);
        tvEnd = getViewById(R.id.tvEndInvestigation);
        if (type.equals(ExtraName.INVISIBILITY)) {
            controlViewVisibility();
        }
        setListener();
    }

    Intent intent;

    @Override
    protected void setListener() {
        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //开始调研
                if (type.equals(ExtraName.VISIBILITY)) {
                    intent = new Intent(getActivity(), InvestigationActivity.class);
                    getActivity().startActivity(intent);

                    //提交完成学习
                } else {
                    submit();

                }

            }
        });

        //结束推广
        tvEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

    private void submit() {

        EasyHttp.post(Contants.STUDY_COMPLETE)
                .cacheMode(CacheMode.NO_CACHE)
                .headers("Content-Type", "application/x-www-form-urlencoded")
                .params("study_id", studyId + "")
                .params("user_id", SharedPreferencesHelps.getUserID())
                .timeStamp(true)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        showLoadingDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        dismissLoadingDialog();
                        Log.e("onError***", "onError:" + e.getCode() + ":" + e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {

                        dismissLoadingDialog();
                        try {
                            JSONObject json = new JSONObject(s);
                            if (json.getString("code").equals("1")) {
                                ToasShow.showToastBottom(getActivity(), json.getString("msg"));
                                getActivity().finish();
                            } else {
                                ToasShow.showToastBottom(getActivity(), json.getString("msg"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });


    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }


    public void controlViewVisibility() {
        if (tvEnd != null && tvStart != null) {
            tvEnd.setVisibility(View.GONE);
            tvStart.setVisibility(View.VISIBLE);
            tvStart.setText(R.string.complete_learning);
        }
    }
}

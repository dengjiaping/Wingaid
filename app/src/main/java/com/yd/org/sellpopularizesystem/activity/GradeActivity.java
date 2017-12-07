package com.yd.org.sellpopularizesystem.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.adapter.GradeAdapter;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.ExamlineBean;
import com.yd.org.sellpopularizesystem.javaBean.GradeBean;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.text.DecimalFormat;

public class GradeActivity extends BaseActivity {
    private ListView lvTestResult;
    private TextView tvCount, tvSureCount, tvAccuracy;
    private GradeBean gradeBean;
    private GradeAdapter gradeAdapter;
    private ExamlineBean.ResultBean resultBean;

    @Override
    protected int setContentView() {
        return R.layout.activity_grade;
    }

    @Override
    public void initView() {
        setTitle(getString(R.string.check));
        hideRightImagview();
        initViews();
        getData();

    }

    private void initViews() {

        Bundle b = getIntent().getExtras();
        resultBean = (ExamlineBean.ResultBean) b.getSerializable("key");
        lvTestResult = getViewById(R.id.lvResult);
        tvCount = getViewById(R.id.tvCount);
        tvSureCount = getViewById(R.id.tvSureCount);
        tvAccuracy = getViewById(R.id.tvAccuracy);
    }

    @Override
    public void setListener() {

    }

    private void getData() {
        EasyHttp.get(Contants.GET_TEST_RESULT).cacheMode(CacheMode.DEFAULT).headers
                ("Cache-Control", "max-age=0").timeStamp(true).params("answer_id", resultBean
                .getAnswer_id() + "").execute(new SimpleCallBack<String>() {
            @Override
            public void onStart() {
                super.onStart();
                showDialog();
            }

            @Override
            public void onError(ApiException e) {
                closeDialog();
                Log.e("onError", "onError:" + e.getCode() + ";;" + e.getMessage());
            }

            @Override
            public void onSuccess(String json) {

                closeDialog();
                if (null != json) {
                    jsonParse(json);
                }

            }
        });


    }

    private void jsonParse(String json) {


        try {
            Gson gson = new Gson();
            gradeBean = gson.fromJson(json, GradeBean.class);
            if (gradeBean.getCode().equals("1")) {
                tvCount.setText(gradeBean.getTotal_answer() + getString(R.string.topic));
                tvSureCount.setText(gradeBean.getTotal_right_answer() + getString(R.string.topic));
                DecimalFormat df = new DecimalFormat("0.00");
                tvAccuracy.setText(df.format(((Float.valueOf(gradeBean.getTotal_right_answer()) /
                        Float.valueOf(gradeBean.getTotal_answer())) * 100)) + " %");
                gradeAdapter = new GradeAdapter(this, gradeBean.getResult());
                lvTestResult.setAdapter(gradeAdapter);
            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

}

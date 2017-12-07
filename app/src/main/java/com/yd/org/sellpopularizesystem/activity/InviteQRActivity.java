package com.yd.org.sellpopularizesystem.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.application.Contants;
import com.yd.org.sellpopularizesystem.javaBean.ReferBean;
import com.yd.org.sellpopularizesystem.utils.SharedPreferencesHelps;
import com.yd.org.sellpopularizesystem.utils.ToasShow;
import com.yd.org.sellpopularizesystem.utils.ZXingUtils;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpParams;

public class InviteQRActivity extends BaseActivity {
    private TextView saveImage, referId;
    private ImageView ivQr;

    @Override
    protected int setContentView() {

        return R.layout.activity_invite;
    }

    @Override
    public void initView() {

        setTitle(getString(R.string.invite_code));
        hideRightImagview();
        ivQr = getViewById(R.id.ivQr);
        referId = getViewById(R.id.referId);
        saveImage = getViewById(R.id.saveImage);

        getInfo();
    }


    @Override
    public void setListener() {
        saveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {


                    //截取真个屏幕
                    //View decorView = getWindow().getDecorView();
                    //截取部分view
                    View decorView = getViewById(R.id.mainRelat);
                    Bitmap screenBitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(screenBitmap);
                    decorView.draw(canvas);

                    //保存图片的相册
                    String uriString = MediaStore.Images.Media.insertImage(getContentResolver(), screenBitmap, "推荐人截图:" + System.currentTimeMillis(), "推荐人截图");
                    if (!TextUtils.isEmpty(uriString)) {
                        ToasShow.showToastBottom(InviteQRActivity.this, getResources().getString(R.string.save_suss));
                    }

                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }

        });
    }

    private void getInfo() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("user_id", SharedPreferencesHelps.getUserID());

        EasyHttp.get(Contants.REFER)
                .cacheMode(CacheMode.DEFAULT)
                .headers("Cache-Control", "max-age=0")
                .timeStamp(true)
                .params(httpParams)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        showDialog();
                    }

                    @Override
                    public void onError(ApiException e) {
                        closeDialog();
                        Log.e("onError", "s:" + e.getCode());
                    }

                    @Override
                    public void onSuccess(String s) {
                        closeDialog();
                        Log.e("onSuccess", "s:" + s);

                        try {
                            Gson gson = new Gson();
                            ReferBean referBean = gson.fromJson(s, ReferBean.class);
                            if (referBean.getCode().equals("1")) {
                                referId.setText(getResources().getString(R.string.recommendqr) + ":" + referBean.getResult().getRefer_code());

                                //生成二维码

                                Bitmap bitmap = ZXingUtils.createQRImage(referBean.getResult().getClient_qrcode(), ivQr.getWidth(), ivQr.getHeight());
                                ivQr.setImageBitmap(bitmap);
                            }

                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }


                    }
                });
    }
}

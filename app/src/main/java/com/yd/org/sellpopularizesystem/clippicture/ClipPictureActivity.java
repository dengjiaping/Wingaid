package com.yd.org.sellpopularizesystem.clippicture;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.yd.org.sellpopularizesystem.R;
import com.yd.org.sellpopularizesystem.utils.BitmapUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Administrator 整体思想是：截取屏幕的截图，然后截取矩形框里面的图片 代码未经优化，只是一个demo。
 */
public class ClipPictureActivity extends MonitoredActivity {
    private int mHorizontalPadding = 0;
    private ClipZoomImageView mZoomImageView;
    // 截图显示框
    private ClipImageBorderView mClipImageView;
    private final Handler handler = new Handler();
    private ContentResolver contentResolver;
    private Bitmap bitmap;
    private String imagePath;// 图片路径
    private RelativeLayout mClipImageLayout;
    private TextView backButton, saveButton;

    private OnClickListener mOnClock = new OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                // 返回
                case R.id.discard:
                    finish();
                    break;

                case R.id.save:
                    onSaveClicked();
                    break;
            }

        }
    };

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.clip_main);
        contentResolver = getContentResolver();

        backButton = (TextView) findViewById(R.id.discard);
        saveButton = (TextView) findViewById(R.id.save);

        saveButton.setOnClickListener(mOnClock);
        backButton.setOnClickListener(mOnClock);

        mZoomImageView = new ClipZoomImageView(this);
        mClipImageView = new ClipImageBorderView(this);

        mClipImageLayout = (RelativeLayout) findViewById(R.id.id_clipImageLayout);
        android.view.ViewGroup.LayoutParams lp = new LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.MATCH_PARENT);

        // -------获取图盘路径---------

        Intent intent = getIntent();
        imagePath = intent.getStringExtra("image-path");
        bitmap = getBitmap(imagePath);
        mZoomImageView.setImageBitmap(bitmap);

        mClipImageLayout.addView(mZoomImageView, lp);
        mClipImageLayout.addView(mClipImageView, lp);

        // 计算padding的px
        mHorizontalPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mHorizontalPadding, getResources().getDisplayMetrics());
        mZoomImageView.setHorizontalPadding(mHorizontalPadding);
        mClipImageView.setHorizontalPadding(mHorizontalPadding);

    }

    private void onSaveClicked() {

        Bitmap fianBitmap = mZoomImageView.clip();

        if (fianBitmap != null) {
            saveBitmap(fianBitmap);
        }

    }

    // 保存剪切后的bitmap
    private void saveBitmap(final Bitmap bitmap) {

        BitmapUtil.startBackgroundJob(this, null, "Saving image", new Runnable() {
            public void run() {
                String path = BitmapUtil.getCacheDir(ClipPictureActivity.this);
                File dir = new File(path, "covers");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File pic = new File(dir, System.currentTimeMillis() + ".jpg");
                final String picPath = pic.getAbsolutePath();
                BitmapUtil.writeBitmap(bitmap, picPath);

                Intent intent = new Intent();
                intent.putExtra("bitmap", picPath);
                setResult(RESULT_OK, intent);
                finish();
            }
        }, handler);

    }

    /**
     * 获取图片Uri
     *
     * @param path
     * @return
     */
    private Uri getImageUri(String path) {
        return Uri.fromFile(new File(path));
    }

    /**
     * 获取bitmap
     *
     * @param path
     * @return
     */

    private Bitmap getBitmap(String path) {

        Uri uri = getImageUri(path);
        InputStream in = null;
        try {
            final int IMAGE_MAX_SIZE = 956;
            in = contentResolver.openInputStream(uri);
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(in, null, o);

            in.close();

            int scale = 1;
            if (o.outHeight > IMAGE_MAX_SIZE || o.outWidth > IMAGE_MAX_SIZE) {
                scale = (int) Math.pow(2, (int) Math.round(Math.log(IMAGE_MAX_SIZE / (double) Math.max(o.outHeight, o.outWidth)) / Math.log(0.5)));
            }

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            in = contentResolver.openInputStream(uri);
            Bitmap b = BitmapFactory.decodeStream(in, null, o2);

            in.close();
            return BitmapUtil.reviewPicRotate(b, path);
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        } catch (Throwable e) {
            return null;
        }
    }

}

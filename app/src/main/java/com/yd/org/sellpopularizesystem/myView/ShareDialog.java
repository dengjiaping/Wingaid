package com.yd.org.sellpopularizesystem.myView;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.yd.org.sellpopularizesystem.R;

/**
 * Created by hejin on 2017/4/20.
 */

public class ShareDialog extends Dialog {
    private onClickback callback;
    private Dialog mDialog;

    public ShareDialog(Context context, onClickback callback, Bitmap bitmap) {
        this(context, R.layout.share_dialog, R.style.shareDialog, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT, bitmap);
        this.callback = callback;
    }

    public ShareDialog(final Context context, int layout, int style, int width,
                       int height, Bitmap bitmap) {
        super(context, style);
        setContentView(layout);
        setCanceledOnTouchOutside(true);
        // 设置属性值
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = width;
        lp.height = height;
        getWindow().setAttributes(lp);
        // 设置dialog显示动画
        getWindow().setWindowAnimations(R.style.dialogWindowAnim);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        // 设置显示位置为底部
        getWindow().setGravity(Gravity.BOTTOM);
        setListener(bitmap);
    }

    private void setListener(Bitmap bitmap) {

        ImageView imageView = (ImageView) findViewById(R.id.ivQr);
        imageView.setImageBitmap(bitmap);


        findViewById(R.id.ivWexin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onShare(1);
                dismiss();
            }
        });

        findViewById(R.id.ivWexinp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onShare(2);
                dismiss();
            }
        });
        findViewById(R.id.ivFacebook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onShare(3);
                dismiss();
            }
        });
        findViewById(R.id.tvCancelShare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        findViewById(R.id.rlShareDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public ShareDialog(@NonNull Context context) {
        super(context);
    }

    public ShareDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected ShareDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public interface onClickback {

        abstract void onShare(int id);
    }
}

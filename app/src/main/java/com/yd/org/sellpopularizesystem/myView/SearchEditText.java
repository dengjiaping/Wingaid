package com.yd.org.sellpopularizesystem.myView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.yd.org.sellpopularizesystem.R;

/**
 * Created by bai on 2017/1/13.
 */

public class SearchEditText extends android.support.v7.widget.AppCompatEditText implements View.OnFocusChangeListener, View.OnKeyListener, TextWatcher {
    private static final String TAG = "SearchEditText";
    /**
     * 图标是否默认在左边
     */
    private boolean isIconLeft = false;
    /**
     * 是否点击软键盘搜索
     */
    private boolean pressSearch = false;
    /**
     * 软键盘搜索键监听
     */
    private OnSearchClickListener listener;

    private Drawable[] drawables; // 控件的图片资源
    private Drawable drawableLeft, drawableDel; // 搜索图标和删除按钮图标
    private int eventX, eventY; // 记录点击坐标
    private Rect rect; // 控件区域

    public void setOnSearchClickListener(OnSearchClickListener listener) {
        this.listener = listener;
    }

    public interface OnSearchClickListener {
        void onSearchClick(View view);
    }

    public SearchEditText(Context context) {
        this(context, null);
        init();
    }


    public SearchEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
        init();
    }


    public SearchEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnFocusChangeListener(this);
        setOnKeyListener(this);
        addTextChangedListener(this);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if (isIconLeft) { // 如果是默认样式，直接绘制
            if (length() < 1) {
                drawableDel = null;
            }
            this.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, null, drawableDel, null);
            super.onDraw(canvas);
        } else {
            // 如果不是默认样式，需要将图标绘制在中间
            if (drawables == null) {drawables = getCompoundDrawables();}
            if (drawableLeft == null) {drawableLeft = drawables[0];}
            float textWidth = getPaint().measureText(getHint().toString());
            int drawablePadding = getCompoundDrawablePadding();
            int drawableWidth = drawableLeft.getIntrinsicWidth();
            float bodyWidth = textWidth + drawableWidth + drawablePadding;
            canvas.translate((getWidth() - bodyWidth - getPaddingLeft() - getPaddingRight()) / 2, 0);
            super.onDraw(canvas);
        }
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        // 被点击时，恢复默认样式
        if (!pressSearch && TextUtils.isEmpty(getText().toString())) {
            isIconLeft = hasFocus;
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        pressSearch = (keyCode == KeyEvent.KEYCODE_ENTER);
        if (pressSearch && listener != null) {
             /*隐藏软键盘*/
            InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm.isActive()) {
                imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
            }
            listener.onSearchClick(v);
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 清空edit内容

        if (drawableDel != null && event.getAction() == MotionEvent.ACTION_UP) {
            eventX = (int) event.getRawX();
            eventY = (int) event.getRawY();
            Log.e("TAG", "eventX = " + eventX + "; eventY = " + eventY);
            if (rect == null) {rect = new Rect();}
            int[] location=new int[2];
            this.getLocationOnScreen(location);
            int x=location[0];
            int y=location[1];
            //获取View在屏幕绝对坐标系中的可视区域，坐标以屏幕左上角为原点(0,0)，另一个点为可见区域右下角相对屏幕原点(0,0)点的坐标。
            getGlobalVisibleRect(rect);
            //获取View自身可见的坐标区域，坐标以自己的左上角为原点(0,0)，另一点为可见区域右下角相对自己(0,0)点的坐标
            //getLocalVisibleRect(rect)
           // 坐标是相对整个屏幕而言，X坐标为view左上角到屏幕左边的距离,Y坐标为View左上角到屏幕顶部的距离
            //getLocationOnScreen(rect)
            //如果为普通Activity则Y坐标为View左上角到屏幕顶部（此时Window与屏幕一样大）；
            // 如果为对话框式的Activity则Y坐标为当前Dialog模式Activity的标题栏顶部到View左上角的距离。
            //getLocationInWindow();
            rect.left=x;
            rect.top=y;
            rect.right=x+getWidth();
            rect.bottom=y+getHeight();
            int intrinsicWidth = drawableDel.getIntrinsicWidth();
            //Log.e("TAG", "onTouchEvent: rect.left"+rect.left+"\\n"+"intrinsicWidth:"+intrinsicWidth+"\n"+"rect:"+rect.right);
            rect.left = rect.right - intrinsicWidth;
            if (rect.contains(eventX, eventY)) {
                setText("");
            }
        }
        // 删除按钮被按下时改变图标样式
        if (drawableDel != null && event.getAction() == MotionEvent.ACTION_DOWN) {
            eventX = (int) event.getRawX();
            eventY = (int) event.getRawY();
            Log.e(TAG, "eventX = " + eventX + "; eventY = " + eventY);
            if (rect == null) {rect = new Rect();}
            int[] location=new int[2];
            this.getLocationOnScreen(location);
            int x=location[0];
            int y=location[1];
            getGlobalVisibleRect(rect);
            rect.left=x;
            rect.top=y;
            rect.right=x+getWidth();
            rect.bottom=y+getHeight();
            int intrinsicWidth = drawableDel.getIntrinsicWidth();
            //Log.e("TAG", "onTouchEvent: rect.left"+rect.left+"\\n"+"intrinsicWidth:"+intrinsicWidth+"\n"+"rect:"+rect.right);
            rect.left = rect.right - intrinsicWidth;
            if (rect.contains(eventX, eventY))
            {drawableDel = this.getResources().getDrawable(R.mipmap.edit_delete_pressed);}
        } else {
            drawableDel = this.getResources().getDrawable(R.mipmap.edit_delete);
        }
        return super.onTouchEvent(event);
    }


    @Override
    public void afterTextChanged(Editable arg0) {
        if (this.length() < 1) {
            drawableDel = null;
        } else {
            drawableDel = this.getResources().getDrawable(R.mipmap.edit_delete);

        }
    }


    @Override
    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
    }

    @Override
    public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
    }
}

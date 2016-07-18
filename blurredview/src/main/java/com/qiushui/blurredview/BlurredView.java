package com.qiushui.blurredview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * @author Qiushui
 */

public class BlurredView extends RelativeLayout {

    /**
     * 模糊最大化值
     */
    public static final int ALPHA_MAX_VALUE = 255;

    /**
     * 模糊后的ImageView
     */
    private ImageView mBlurredImg;

    /**
     * 原图ImageView
     */
    private ImageView mOriginImg;
    /**
     * 原图Bitmap
     */
    private Bitmap mOriginBitmap;

    /**
     * 模糊后的Bitmap
     */
    private Bitmap mBlurredBitmap;

    /**
     * 是否禁用模糊效果
     */
    private boolean isDisableBlurred;

    public BlurredView(Context context) {
        super(context);
        init(context);
    }

    public BlurredView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        initAttr(context, attrs);
    }

    public BlurredView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        initAttr(context, attrs);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.blurredview, this);
        mOriginImg = (ImageView) findViewById(R.id.blurredview_origin_img);
        mBlurredImg = (ImageView) findViewById(R.id.blurredview_blurred_img);
    }

    private void initAttr(Context context, AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BlurredView);
        Drawable drawable = typedArray.getDrawable(R.styleable.BlurredView_src);
        boolean isMove = typedArray.getBoolean(R.styleable.BlurredView_move, false);
        isDisableBlurred = typedArray.getBoolean(R.styleable.BlurredView_disableBlurred, false);

        typedArray.recycle();
        if (null != drawable) {
            mOriginBitmap = BlurredUtil.drawableToBitmap(drawable);
            mBlurredBitmap = BlurBitmap.blur(context, mOriginBitmap);
        }

        if (!isDisableBlurred) {
            mBlurredImg.setVisibility(VISIBLE);
        }

        if (isMove) {
            WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int height = point.y;
            setBlurredHeight(height, mOriginImg);
            setBlurredHeight(height, mBlurredImg);
        }
    }

    private void setBlurredHeight(int height, ImageView imageView) {
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = height + 100;
        imageView.requestLayout();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mBlurredImg.setImageBitmap(mBlurredBitmap);
        mOriginImg.setImageBitmap(mOriginBitmap);
    }

    /**
     * 设置模糊程度
     */
    public void setBlurredLevel(int level) {
        if (level < 0 || level > 100) {
            throw new IllegalStateException("No validate level, the value must be 0~100");
        }
        if (isDisableBlurred) {
            return;
        }
        mOriginImg.setAlpha((int) (ALPHA_MAX_VALUE - level*2.55));
    }

    /**
     * 设置图片上移的距离
     * @param hight 向上移动的距离
     */
    public void setBlurredTop(int hight) {
        mOriginImg.setTop(-hight);
        mBlurredImg.setTop(-hight);
    }

    /**
     * 显示模糊图片
     */
    public void showBlurredView() {
        mBlurredImg.setVisibility(VISIBLE);
    }

    /**
     * 禁用模糊效果
     */
    public void disableBlurredView() {
        isDisableBlurred = true;
        mOriginImg.setAlpha(ALPHA_MAX_VALUE);
        mBlurredImg.setVisibility(INVISIBLE);
    }

    /**
     * 启用模糊效果
     */
    public void enableBlurredView() {
        isDisableBlurred = false;
        mBlurredImg.setVisibility(VISIBLE);
    }
}

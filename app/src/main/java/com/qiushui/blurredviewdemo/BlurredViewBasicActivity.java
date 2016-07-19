package com.qiushui.blurredviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import com.qiushui.blurredview.BlurredView;


/**
 * Basic Demo
 * @author Qiushui
 */
public class BlurredViewBasicActivity extends AppCompatActivity {

    /**
     * 进度条SeekBar
     */
    private SeekBar mSeekBar;

    /**
     * 显示进度的文字
     */
    private TextView mProgressTv;

    /**
     * Blurredview
     */
    private BlurredView mBlurredView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blurrediview_basic);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 初始化视图
        initViews();

        // 处理seekbar滑动事件
        setSeekBar();
    }

    /**
     * 初始化视图
     */
    private void initViews() {
        mSeekBar = (SeekBar) findViewById(R.id.activity_main_seekbar);
        mProgressTv = (TextView) findViewById(R.id.activity_main_progress_tv);
        mBlurredView = (BlurredView) findViewById(R.id.activity_main_blurredview);

        // 可以在代码中使用setBlurredImg()方法指定需要模糊的图片
        mBlurredView.setBlurredImg(getResources().getDrawable(R.drawable.dayu));

        // 设置完成后需要调用showBlurredView方法显示要模糊的图片
        mBlurredView.showBlurredView();
    }

    /**
     * 处理seekbar滑动事件
     */
    private void setSeekBar() {
        mSeekBar.setMax(100);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mBlurredView.setBlurredLevel(progress);
                mProgressTv.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}

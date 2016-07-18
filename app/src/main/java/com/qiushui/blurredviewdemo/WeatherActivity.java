package com.qiushui.blurredviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.WindowManager;

import com.qiushui.blurredview.BlurredView;


/**
 * Weather Demo
 * @author Qiushui
 */

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "TestScrollView";
    /**
     * toolbar
     */
    private Toolbar mToolbar;

    /**
     * blurredview
     */
    private BlurredView mBlurredView;

    /**
     * RecyclerView
     */
    private RecyclerView mRecyclerView;

    private int mScrollerY;

    private int mAlpha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blurred_weather_activity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mToolbar = (Toolbar) findViewById(R.id.yahooweather_toolbar);
        mBlurredView = (BlurredView) findViewById(R.id.yahooweather_blurredview);
        mRecyclerView = (RecyclerView) findViewById(R.id.yahooweather_recyclerview);

        setSupportActionBar(mToolbar);

        mToolbar.setTitle("重庆");
        mToolbar.setTitleTextColor(Color.WHITE);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new RecyclerViewAdapter(this));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mScrollerY += dy;
                if (Math.abs(mScrollerY) > 1000) {
                    mBlurredView.setBlurredTop(100);
                    mAlpha = 100;
                } else {
                    mBlurredView.setBlurredTop(mScrollerY / 10);
                    mAlpha = Math.abs(mScrollerY) / 10;
                }


                Log.d(TAG, "onScrolled: mAlpha = " + mAlpha);
                mBlurredView.setBlurredLevel(mAlpha);
            }
        });

    }
}

package com.example.liuhaiyang.materialdesignanimation.view;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.example.liuhaiyang.materialdesignanimation.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by liuhaiyang on 2017/5/6.
 */

public class CircularRevealView extends View{

    private List<Integer> mColor;
    private Random mRandom;

    public CircularRevealView(Context context) {
        this(context, null);
    }

    public CircularRevealView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircularRevealView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mColor = new ArrayList<>();
        mColor.add(getResources().getColor(R.color.google_red));
        mColor.add(getResources().getColor(R.color.google_green));
        mColor.add(getResources().getColor(R.color.google_blue));
        mColor.add(getResources().getColor(R.color.google_yellow));
        mRandom = new Random();
//        this.setBackgroundColor(mColor.get(mRandom.nextInt(4)));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取view的宽高测量模式
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //保存测量高度
        setMeasuredDimension(widthSize, heightSize);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.setBackgroundColor(mColor.get(mRandom.nextInt(4)));
                Animator anim = ViewAnimationUtils.createCircularReveal(
                        this,//对应的view
                        (int) event.getX(),// 开始缩放点x位置
                        (int) event.getY(),// 开始缩放点y位置
                        0,//开始半径
                        // 结束半径    hypot(double ,double ) 表示斜线的长度
                        (float) Math.hypot(this.getWidth(), this.getHeight()));
                anim.setDuration(1000);
                anim.setInterpolator(new AccelerateDecelerateInterpolator());
                anim.start();
                break;
        }
        return true;
    }
}

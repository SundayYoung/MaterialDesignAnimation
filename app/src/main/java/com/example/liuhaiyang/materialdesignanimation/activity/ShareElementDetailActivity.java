package com.example.liuhaiyang.materialdesignanimation.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liuhaiyang.materialdesignanimation.R;
import com.example.liuhaiyang.materialdesignanimation.model.ShareElementModel;

public class ShareElementDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_element_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ShareElementModel model = (ShareElementModel) getIntent().getSerializableExtra("model");

        findViewById(R.id.iv_img).setBackgroundResource(model.imgRecorce);
        TextView tvName = (TextView) findViewById(R.id.tv_name);
        tvName.setText(model.name);

        final ImageView imgHead = (ImageView) findViewById(R.id.iv_head_bg);
        imgHead.post(new Runnable() {
            @Override
            public void run() {
//                setRevealEffect(imgHead);
            }
        });

    }

    private void setRevealEffect(final ImageView img) {
        if (img.getVisibility() == View.INVISIBLE) {
            Animator anim = ViewAnimationUtils.createCircularReveal(
                            img,//对应的view
                            0,// 开始缩放点x位置
                            0,// 开始缩放点y位置
                            0,//开始半径
                            // 结束半径    hypot(double ,double ) 表示斜线的长度
                            (float) Math.hypot(img.getWidth(), img.getHeight()));
            img.setVisibility(View.VISIBLE);
            anim.setDuration(1000);
            anim.setInterpolator(new AccelerateDecelerateInterpolator());
            anim.start();
        } else {
            Animator anim = ViewAnimationUtils.createCircularReveal(
                            img,//对应的view
                            0,// 开始缩放点x位置
                            0,// 开始缩放点y位置
                            // 开始半径和结束半径
                            (float) Math.hypot(img.getWidth(), img.getHeight()),0);
            img.setVisibility(View.VISIBLE);
            anim.setDuration(2000);
            anim.setInterpolator(new AccelerateDecelerateInterpolator());
            anim.start();
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    img.setVisibility(View.INVISIBLE);
                }
            });
        }
    }

}

package com.example.liuhaiyang.materialdesignanimation.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;

import com.example.liuhaiyang.materialdesignanimation.R;

public class RevealEffectActivity extends AppCompatActivity {

    private View myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal_effect);


        myView = findViewById(R.id.iv_like);
        Button button = (Button) findViewById(R.id.bt_ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change();
            }
        });
        findViewById(R.id.bt_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RevealEffectActivity.this, CircularRevealActivity.class));
            }
        });

    }

    public void change() {
        int centerX = myView.getWidth() / 2;
        int centerY = myView.getHeight() / 2;
        int maxRadius = Math.max(myView.getWidth(), myView.getHeight());

        if(myView.getVisibility() == View.VISIBLE) {
            Animator anim = ViewAnimationUtils.createCircularReveal(myView,
                    centerX, centerY, maxRadius, 0);
            anim.setDuration(1500);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    myView.setVisibility(View.INVISIBLE);
                }
            });
            anim.start();
        }else {
            Animator anim = ViewAnimationUtils.createCircularReveal(myView,
                    centerX, centerY, 0, maxRadius);
            anim.setDuration(1500);
            myView.setVisibility(View.VISIBLE);
            anim.start();
        }
    }
}

package com.example.administrator.bt_buoi14_altp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Administrator on 9/21/2017.
 */

public class ManHinhCho extends AppCompatActivity{
    private ImageView imgDialog;
    private Animation animation;
    private CountDownTimer countDownTimer ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man_hinh_cho);
        initView();
    }

    private void initView() {
        imgDialog = (ImageView) findViewById(R.id.imgDialog);
        animation = AnimationUtils.loadAnimation(ManHinhCho.this,R.anim.xoay);
        imgDialog.startAnimation(animation);
        countDownTimer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ManHinhCho.this,FragmentMain.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }
}

package com.example.administrator.bt_buoi14_altp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Administrator on 9/21/2017.
 */

public class VaoGame extends AppCompatActivity {
    private ImageView imgHinh;
    private ImageButton btnChoiThu;
    private MediaPlayer traLoiB;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vao_game);
        initView();
        traLoiB = MediaPlayer.create(VaoGame.this,R.raw.background_music);
        traLoiB.start();
        traLoiB.setLooping(true);

    }

    private void initView() {
        imgHinh = (ImageView) findViewById(R.id.imgHinh);
        btnChoiThu = (ImageButton) findViewById(R.id.btnChoiThu);
        btnChoiThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VaoGame.this,ManHinhCho.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        traLoiB.stop();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}

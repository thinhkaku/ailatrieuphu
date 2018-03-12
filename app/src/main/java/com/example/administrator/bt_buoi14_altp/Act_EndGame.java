package com.example.administrator.bt_buoi14_altp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 9/24/2017.
 */

public class Act_EndGame extends AppCompatActivity {
    private TextView txtScore;
    private Button btnChoiLai;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_endgame);
        initView();
        MediaPlayer mediaPlayer12 = MediaPlayer.create(Act_EndGame.this,R.raw.lose);
        mediaPlayer12.start();
    }

    private void initView() {
        txtScore = (TextView) findViewById(R.id.txtHighScore);
        btnChoiLai = (Button) findViewById(R.id.btnChoiLai);
        btnChoiLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Act_EndGame.this,VaoGame.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        txtScore.setText(intent.getStringExtra("Score"));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Act_EndGame.this,VaoGame.class);
        startActivity(intent);

        //super.onBackPressed();
    }
}

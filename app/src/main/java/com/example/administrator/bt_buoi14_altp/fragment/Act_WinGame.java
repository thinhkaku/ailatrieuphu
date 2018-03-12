package com.example.administrator.bt_buoi14_altp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.bt_buoi14_altp.R;
import com.example.administrator.bt_buoi14_altp.VaoGame;

/**
 * Created by Administrator on 9/24/2017.
 */

public class Act_WinGame extends AppCompatActivity {
    private TextView txtScore1;
    private Button btnChoiLai1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wingame);
        initView();
    }

    private void initView() {
        txtScore1 = (TextView) findViewById(R.id.txtHighScore1);
        btnChoiLai1 = (Button) findViewById(R.id.btnChoiLai1);
        btnChoiLai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Act_WinGame.this,VaoGame.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        txtScore1.setText(intent.getStringExtra("Score"));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Act_WinGame.this,VaoGame.class);
        startActivity(intent);

        //super.onBackPressed();
    }
}

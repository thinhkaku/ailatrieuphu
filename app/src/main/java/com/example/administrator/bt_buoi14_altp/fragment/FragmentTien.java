package com.example.administrator.bt_buoi14_altp.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.administrator.bt_buoi14_altp.FragmentMain;
import com.example.administrator.bt_buoi14_altp.R;
import com.example.administrator.bt_buoi14_altp.VaoGame;

/**
 * Created by Administrator on 9/21/2017.
 */

public class FragmentTien extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tien,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        final MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.luatchoi_b);
        mediaPlayer.start();
        CountDownTimer countDownTimer = new CountDownTimer(8000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                MediaPlayer mediaPlayer1 = MediaPlayer.create(getActivity(),R.raw.ready_b);
                mediaPlayer1.start();
            }
        }.start();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

package com.example.administrator.bt_buoi14_altp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionValues;

import com.example.administrator.bt_buoi14_altp.fragment.FragmentPlay;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien1;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien10;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien11;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien12;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien13;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien14;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien15;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien2;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien3;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien4;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien5;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien6;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien7;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien8;
import com.example.administrator.bt_buoi14_altp.fragment.FragmentTien9;
import com.example.administrator.bt_buoi14_altp.fragment.Fragment_DiaLog;

/**
 * Created by Administrator on 9/21/2017.
 */

public class FragmentMain extends AppCompatActivity {
    private FragmentTien fragmentTien = new FragmentTien();
    private FragmentTien1 fragmentTien1 = new FragmentTien1();
    private FragmentTien2 fragmentTien2 = new FragmentTien2();
    private FragmentTien3 fragmentTien3 = new FragmentTien3();
    private FragmentTien4 fragmentTien4 = new FragmentTien4();
    private FragmentTien5 fragmentTien5 = new FragmentTien5();
    private FragmentTien6 fragmentTien6 = new FragmentTien6();
    private FragmentTien7 fragmentTien7 = new FragmentTien7();
    private FragmentTien8 fragmentTien8 = new FragmentTien8();
    private FragmentTien9 fragmentTien9 = new FragmentTien9();
    private FragmentTien10 fragmentTien10 = new FragmentTien10();
    private FragmentTien11 fragmentTien11 = new FragmentTien11();
    private FragmentTien12 fragmentTien12 = new FragmentTien12();
    private FragmentTien13 fragmentTien13 = new FragmentTien13();
    private FragmentTien14 fragmentTien14 = new FragmentTien14();
    private FragmentTien15 fragmentTien15 = new FragmentTien15();
    private Fragment_DiaLog fragment_diaLog = new Fragment_DiaLog();
    private FragmentPlay fragmentPlay = new FragmentPlay();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        initFrament();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
    }

    private void initFrament() {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.panel,fragmentPlay);
        transaction.add(R.id.panel,fragmentTien);
        transaction.add(R.id.panel,fragmentTien1);
        transaction.add(R.id.panel,fragmentTien2);
        transaction.add(R.id.panel,fragmentTien3);
        transaction.add(R.id.panel,fragmentTien4);
        transaction.add(R.id.panel,fragmentTien5);
        transaction.add(R.id.panel,fragmentTien6);
        transaction.add(R.id.panel,fragmentTien7);
        transaction.add(R.id.panel,fragmentTien8);
        transaction.add(R.id.panel,fragmentTien9);
        transaction.add(R.id.panel,fragmentTien10);
        transaction.add(R.id.panel,fragmentTien11);
        transaction.add(R.id.panel,fragmentTien12);
        transaction.add(R.id.panel,fragmentTien13);
        transaction.add(R.id.panel,fragmentTien14);
        transaction.add(R.id.panel,fragmentTien15);
        transaction.add(R.id.panel,fragment_diaLog);
        CountDownTimer countDownTimer = new CountDownTimer(500,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                swithFragment(fragmentPlay);
            }

            @Override
            public void onFinish() {
                swithFragment(fragmentTien);
            }
        }.start();
        transaction.commit();
    }

    public void swithFragment(Fragment fragment)
    {
        MediaPlayer mediaPlayer12 = MediaPlayer.create(FragmentMain.this,R.raw.background_music_b);
        mediaPlayer12.start();
        mediaPlayer12.setLooping(true);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        transaction.hide(fragmentTien);
        transaction.hide(fragmentTien1);
        transaction.hide(fragmentTien2);
        transaction.hide(fragmentTien3);
        transaction.hide(fragmentTien4);
        transaction.hide(fragmentTien5);
        transaction.hide(fragmentTien6);
        transaction.hide(fragmentTien7);
        transaction.hide(fragmentTien8);
        transaction.hide(fragmentTien9);
        transaction.hide(fragmentTien10);
        transaction.hide(fragmentTien11);
        transaction.hide(fragmentTien12);
        transaction.hide(fragmentTien13);
        transaction.hide(fragmentTien14);
        transaction.hide(fragmentTien15);
        transaction.hide(fragmentPlay);
        transaction.hide(fragment_diaLog);
        transaction.show(fragment);
        transaction.commit();
    }


    public FragmentTien11 getFragmentTien11() {
        return fragmentTien11;
    }

    public FragmentTien12 getFragmentTien12() {
        return fragmentTien12;
    }

    public FragmentTien13 getFragmentTien13() {
        return fragmentTien13;
    }

    public FragmentTien14 getFragmentTien14() {
        return fragmentTien14;
    }

    public FragmentTien15 getFragmentTien15() {
        return fragmentTien15;
    }

    public Fragment_DiaLog getFragment_diaLog() {
        return fragment_diaLog;
    }

    public FragmentPlay getFragmentPlay() {
        return fragmentPlay;
    }

    public FragmentTien getFragmentTien() {
        return fragmentTien;
    }

    public FragmentTien1 getFragmentTien1() {
        return fragmentTien1;
    }

    public FragmentTien2 getFragmentTien2() {
        return fragmentTien2;
    }

    public FragmentTien3 getFragmentTien3() {
        return fragmentTien3;
    }

    public FragmentTien4 getFragmentTien4() {
        return fragmentTien4;
    }

    public FragmentTien5 getFragmentTien5() {
        return fragmentTien5;
    }

    public FragmentTien6 getFragmentTien6() {
        return fragmentTien6;
    }

    public FragmentTien7 getFragmentTien7() {
        return fragmentTien7;
    }

    public FragmentTien8 getFragmentTien8() {
        return fragmentTien8;
    }

    public FragmentTien9 getFragmentTien9() {
        return fragmentTien9;
    }

    public FragmentTien10 getFragmentTien10() {
        return fragmentTien10;
    }

}

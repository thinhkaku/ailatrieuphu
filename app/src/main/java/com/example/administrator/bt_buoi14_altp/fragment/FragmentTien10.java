package com.example.administrator.bt_buoi14_altp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.administrator.bt_buoi14_altp.FragmentMain;
import com.example.administrator.bt_buoi14_altp.R;

/**
 * Created by Administrator on 9/21/2017.
 */

public class FragmentTien10 extends Fragment {
    private LinearLayout btnBack;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tien10,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        btnBack = (LinearLayout) getActivity().findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentMain fragmentMain = (FragmentMain) getActivity();
                fragmentMain.swithFragment(fragmentMain.getFragmentPlay());
            }
        });
//        CountDownTimer countDownTimer = new CountDownTimer(4000,1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//            }
//
//            @Override
//            public void onFinish() {
//                FragmentMain fragmentMain = (FragmentMain) getActivity();
//                fragmentMain.swithFragment(fragmentMain.getFragmentPlay());
//            }
//        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

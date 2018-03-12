package com.example.administrator.bt_buoi14_altp.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.bt_buoi14_altp.FragmentMain;
import com.example.administrator.bt_buoi14_altp.R;
import com.example.administrator.bt_buoi14_altp.VaoGame;

/**
 * Created by Administrator on 9/25/2017.
 */

public class Fragment_DiaLog extends Fragment {
    private Dialog dialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);

    }

    @Override
    public void onStart() {
        super.onStart();
        initDialog();
    }

    private void initDialog() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_play);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        Button btnYes = (Button) dialog.findViewById(R.id.btnCoSS);
        Button btnNo = (Button) dialog.findViewById(R.id.btnKhongSS);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentMain fragmentMain = (FragmentMain) getActivity();
                fragmentMain.swithFragment(fragmentMain.getFragmentPlay());

                dialog.dismiss();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VaoGame.class);
                startActivity(intent);
                dialog.dismiss();
                getActivity().finish();

            }
        });
    }
    public void showDialog(){
        dialog.show();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

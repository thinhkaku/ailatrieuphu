package com.example.administrator.bt_buoi14_altp.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.bt_buoi14_altp.Act_EndGame;
import com.example.administrator.bt_buoi14_altp.FragmentMain;
import com.example.administrator.bt_buoi14_altp.ManHinhCho;
import com.example.administrator.bt_buoi14_altp.QuesTion;
import com.example.administrator.bt_buoi14_altp.QuestionSQLite;
import com.example.administrator.bt_buoi14_altp.R;
import com.example.administrator.bt_buoi14_altp.VaoGame;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

/**
 * Created by Administrator on 9/21/2017.
 */

public class FragmentPlay extends Fragment implements View.OnClickListener {
    private TextView txtNumer, txtQuestion, txtDapAnA,txtDapAnB,txtDapAnC,txtDapAnD,txtScore, txtTime;
    private ImageButton btnCall, btnStop, btn5050, btnHoiKhanGia,btnDoiQuestion;
    private Dialog dialog, dialog1,dialog2, dialog3, dialog4,dialog5;
    private BarChart barChart;
    private ArrayList<QuesTion> arrayList1 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList2 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList3 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList4 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList5 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList6 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList7 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList8 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList9 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList10 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList11 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList12 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList13 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList14 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList15 = new ArrayList<>();
    private ArrayList<QuesTion> arrayList16 = new ArrayList<>();
    ArrayList<BarEntry> entries = new ArrayList<>();
    private ArrayList []arrayLists;
    private int cauQuestion = 1;
    private int trueCase =-1;
    private  int dA =-1;
    private RingProgressBar ringProgressBar;
    private MediaPlayer traLoiA,traLoiB,traLoiC,traLoiD, dapAnDungA,dapAnDungB,dapAnDungC,dapAnDungD;

    private CountDownTimer countDownTimer33;
    private Animation animation;
    private int progressInt=30;
    private int count;
    private boolean isCancelCountDown = false;
    private CountDownTimer countDownTimer22;

    private QuestionSQLite questionSQLite;
    private QuesTion quesTion = new QuesTion();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_play,container,false);

    }

    @Override
    public void onStart() {
        super.onStart();
        questionSQLite = new QuestionSQLite(getContext());
        readData();
        initView();

        CountDownTimer countDownTimer = new CountDownTimer(11000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
               initDialogVaoGame();
                dialog2.show();
            }
        }.start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=30;i>=0;i--){
//                    try {
//                        Thread.sleep(30);
//                        handler.sendEmptyMessage(0);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

    }


    private void ktThoiGian(){

        progressInt =0;
        count =30;
        countDownTimer33 = new CountDownTimer(31000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressInt =progressInt+1;
                count= count-1;
                ringProgressBar.setProgress(progressInt);
                txtTime.setText(count+"");

            }

            @Override
            public void onFinish() {
                MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.out_of_time);
                mediaPlayer.start();
                initDialogHetGio();
                dialog3.show();

            }
        }.start();
    }


    private void dungThoiGian(){
        countDownTimer33.cancel();
    }


    private void initDialogHetGio() {
        dialog3 = new Dialog(getContext());
        dialog3.setContentView(R.layout.layout_het_gio);
        dialog3.setCancelable(false);
        dialog3.setCanceledOnTouchOutside(false);
       Button btnDong = (Button) dialog3.findViewById(R.id.btnDong);
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameOver();
                getActivity().finish();
            }
        });

    }



    private  void dialogYKienCuaChuyenGia(){
        dialog5 = new Dialog(getContext());
        dialog5.setContentView(R.layout.dialog_y_kien_chuyen_gia);
        dialog5.setCancelable(false);
        dialog5.setCanceledOnTouchOutside(false);
        TextView txtYKienChuyenGia = (TextView) dialog5.findViewById(R.id.txtYKienChuyenGia);
        Button btnDongYYKienChuyenGia = (Button) dialog5.findViewById(R.id.btnDongYYKienChuyenGia);
        if (trueCase==1){
            txtYKienChuyenGia.setText("Theo tôi đáp án đúng là đáp án A ");
        }
        if (trueCase==2){
            txtYKienChuyenGia.setText("Theo tôi đáp án đúng là đáp án B ");
        }
        if (trueCase==3){
            txtYKienChuyenGia.setText("Theo tôi đáp án đúng là đáp án C ");
        }
        if (trueCase==4){
            txtYKienChuyenGia.setText("Theo tôi đáp án đúng là đáp án D ");
        }

        btnDongYYKienChuyenGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog5.dismiss();
                dialog4.dismiss();
                btnCall.setImageResource(R.drawable.atp__activity_player_button_image_help_call_x);
            }
        });
    }
    private void initDialogGoiDien() {
        dialog4 = new Dialog(getContext());
        dialog4.setContentView(R.layout.dialog_goidien);
        dialog4.setCancelable(false);
        dialog4.setCanceledOnTouchOutside(false);
        ImageButton btnBacSi = (ImageButton) dialog4.findViewById(R.id.btnBacSi);
        ImageButton btnKySu = (ImageButton) dialog4.findViewById(R.id.btnKySu);
        ImageButton btnPhongVien = (ImageButton) dialog4.findViewById(R.id.btnPhongVien);
        ImageButton btnGiaoVien = (ImageButton) dialog4.findViewById(R.id.btnGiaoVien);
        Button btnHuy = (Button) dialog4.findViewById(R.id.btnOkHoiYKien);
        btnBacSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogYKienCuaChuyenGia();
                dialog5.show();
            }
        });

        btnGiaoVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogYKienCuaChuyenGia();
                dialog5.show();
            }
        });

        btnKySu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogYKienCuaChuyenGia();
                dialog5.show();
            }
        });

        btnPhongVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogYKienCuaChuyenGia();
                dialog5.show();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog4.dismiss();
                btnCall.setEnabled(true);
            }
        });

    }


    private void initDialogVaoGame() {
        dialog2 = new Dialog(getContext());
        dialog2.setContentView(R.layout.dialog_play);
        dialog2.setCancelable(false);
        dialog2.setCanceledOnTouchOutside(false);
        Button btnYes = (Button) dialog2.findViewById(R.id.btnCoSS);
        Button btnNo = (Button) dialog2.findViewById(R.id.btnKhongSS);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.gofind);
                mediaPlayer.start();
                FragmentMain fragmentMain = (FragmentMain) getActivity();
                fragmentMain.swithFragment(fragmentMain.getFragmentPlay());
                CountDownTimer countDownTimer = new CountDownTimer(8000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        ktDungSai();

                    }
                }.start();
                dialog2.dismiss();

            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VaoGame.class);
                startActivity(intent);
                dialog2.dismiss();
                getActivity().finish();

            }
        });
    }

    private void initCauHoi() {
        MediaPlayer mediaPlayer12 = MediaPlayer.create(getActivity(),R.raw.background_music_b);
        mediaPlayer12.start();
        mediaPlayer12.setLooping(true);
        if (cauQuestion>15){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.best_player);
            mediaPlayer.start();
            if (cauQuestion ==16){
                txtScore.setText("150.000.000");
            }
            Intent intent = new Intent(getContext(),Act_WinGame.class);
            intent.putExtra("Score",txtScore.getText());
            startActivity(intent);
            getActivity().finish();
    }else {

        txtDapAnA.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_normal);
        txtDapAnD.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_normal);
        txtDapAnB.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_normal);
        txtDapAnC.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_normal);

        txtDapAnA.setEnabled(true);
        txtDapAnB.setEnabled(true);
        txtDapAnC.setEnabled(true);
        txtDapAnD.setEnabled(true);

        resetButton();

        quesTion = (QuesTion) arrayLists[cauQuestion-1].get(0);
        txtNumer.setText("Câu "+cauQuestion);
            if (cauQuestion ==1){

            }
        if (cauQuestion ==2){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques2);
            mediaPlayer.start();
            txtScore.setText("200.000");
        }
        if (cauQuestion ==3){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques3);
            mediaPlayer.start();
            txtScore.setText("400.000");
        }
        if (cauQuestion ==4){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques4);
            mediaPlayer.start();
            txtScore.setText("600.000");
        }
        if (cauQuestion ==5){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques5);
            mediaPlayer.start();
            txtScore.setText("1.000.000");
        }
        if (cauQuestion ==6){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques6);
            mediaPlayer.start();
            txtScore.setText("2.000.000");
        }
        if (cauQuestion ==7){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques7);
            mediaPlayer.start();
            txtScore.setText("3.000.000");
        }
        if (cauQuestion ==8){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques8);
            mediaPlayer.start();
            txtScore.setText("6.000.000");
        }
        if (cauQuestion ==9){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques9);
            mediaPlayer.start();
            txtScore.setText("10.000.000");
        }
        if (cauQuestion ==10){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques10);
            mediaPlayer.start();
            txtScore.setText("14.000.000");
        }
        if (cauQuestion ==11){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques11);
            mediaPlayer.start();
            txtScore.setText("22.000.000");
        }
        if (cauQuestion ==12){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques12);
            mediaPlayer.start();
            txtScore.setText("30.000.000");
        }
        if (cauQuestion ==13){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques13);
            mediaPlayer.start();
            txtScore.setText("40.000.000");
        }
        if (cauQuestion ==14){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques14);
            mediaPlayer.start();
            txtScore.setText("60.000.000");
        }
        if (cauQuestion ==15){
            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques15);
            mediaPlayer.start();
            txtScore.setText("85.000.000");
        }
        if (cauQuestion ==16){
            txtScore.setText("150.000.000");
        }
        txtQuestion.setText(quesTion.getQuestion());
        txtDapAnA.setText("A : " + quesTion.getCaseA());
        txtDapAnB.setText("B : " + quesTion.getCaseB());
        txtDapAnC.setText("C :" + quesTion.getCaseC());
        txtDapAnD.setText("D :" + quesTion.getCaseD());
        trueCase = quesTion.getTrueCase();
        Toast.makeText(getContext(),""+trueCase,Toast.LENGTH_SHORT).show();
        ktThoiGian();
    }
    }
    private void swapFagment(){
        if (cauQuestion ==1) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien());
        }
        if (cauQuestion ==2) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien1());
        }
        if (cauQuestion ==3) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien2());
        }
        if (cauQuestion ==4) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien3());
        }
        if (cauQuestion ==5) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien4());
        }
        if (cauQuestion ==6) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien5());
        }
        if (cauQuestion ==7) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien6());
        }if (cauQuestion ==8) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien7());
        }
        if (cauQuestion ==9) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien8());
        }if (cauQuestion ==10) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien9());
        }
        if (cauQuestion ==11) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien10());
        }
        if (cauQuestion ==12) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien11());
        }
        if (cauQuestion ==13) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien12());
        }
        if (cauQuestion ==14) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien13());
        }
        if (cauQuestion ==15) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien14());
        }
        if (cauQuestion ==16) {
            FragmentMain fragmentMain = (FragmentMain) getActivity();
            fragmentMain.swithFragment(fragmentMain.getFragmentTien15());
        }
    }

    private void voHieuHoaButton(){
        txtDapAnB.setEnabled(false);
        txtDapAnC.setEnabled(false);
        txtDapAnD.setEnabled(false);
        txtDapAnA.setEnabled(false);
    }
    private void ktDungSai() {


            if (cauQuestion ==1){
                MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.ques1);
                mediaPlayer.start();

                ktThoiGian();
                quesTion = arrayList1.get(0);
                txtNumer.setText("Câu 1");
                txtQuestion.setText(quesTion.getQuestion());
                txtDapAnA.setText("A : " + quesTion.getCaseA());
                txtDapAnB.setText("B : " + quesTion.getCaseB());
                txtDapAnC.setText("C : " + quesTion.getCaseC());
                txtDapAnD.setText("D : " + quesTion.getCaseD());
                trueCase = quesTion.getTrueCase();

                txtDapAnA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        traLoiA = MediaPlayer.create(getActivity(),R.raw.ans_a2);
                        traLoiA.start();
                        dungThoiGian();
                        isCancelCountDown = true;
                        cancelButton();
                        voHieuHoaButton();
                        dA = 1;
                        CountDownTimer countDownTimer = new CountDownTimer(4000,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                txtDapAnA.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_selected);
                                animation = AnimationUtils.loadAnimation(getActivity(),R.anim.animation_true);
                                txtDapAnA.startAnimation(animation);
                            }

                            @Override
                            public void onFinish() {
                                if (dA == trueCase) {
                                    dapAnDungA = MediaPlayer.create(getActivity(),R.raw.true_a);
                                    dapAnDungA.start();
                                    cauQuestion++;

                                    CountDownTimer countDownTimer1 = new CountDownTimer(4000,1000) {
                                        @Override
                                        public void onTick(long millisUntilFinished) {
                                            txtDapAnA.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                            animation = AnimationUtils.loadAnimation(getActivity(),R.anim.animation_true);
                                            txtDapAnA.startAnimation(animation);
                                        }

                                        @Override
                                        public void onFinish() {
                                            txtDapAnA.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_normal);
                                            CountDownTimer countDownTimer1 = new CountDownTimer(2000,1000) {
                                                @Override
                                                public void onTick(long millisUntilFinished) {
                                                    swapFagment();
                                                }

                                                @Override
                                                public void onFinish() {
                                                    doiCauhoi();
                                                }
                                            }.start();
                                        }
                                    }.start();
                                } else {
                                    if (trueCase ==2){
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lose_b);
                                        mediaPlayer.start();
                                        txtDapAnB.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                    }else
                                    if (trueCase ==3){
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lose_c);
                                        mediaPlayer.start();
                                        txtDapAnC.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                    }else
                                    if (trueCase ==4){
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lose_d);
                                        mediaPlayer.start();
                                        txtDapAnD.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                    }
                                    txtDapAnA.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_wrong);
                                    CountDownTimer countDownTimer1 = new CountDownTimer(2000,1000) {
                                        @Override
                                        public void onTick(long millisUntilFinished) {
                                        }
                                        @Override
                                        public void onFinish() {
                                            gameOver();
                                        }
                                    }.start();
                                }
                            }
                        }.start();

                    }
                });

                txtDapAnB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        traLoiB = MediaPlayer.create(getActivity(),R.raw.ans_b2);
                        traLoiB.start();
                        dungThoiGian();
                        isCancelCountDown = true;
                        cancelButton();
                        voHieuHoaButton();
                        dA = 2;
                        CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                txtDapAnB.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_selected);
                                animation = AnimationUtils.loadAnimation(getActivity(),R.anim.animation_true);
                                txtDapAnB.startAnimation(animation);
                            }

                            @Override
                            public void onFinish() {
                                if (dA == trueCase) {
                                    dapAnDungB = MediaPlayer.create(getActivity(),R.raw.true_b2);
                                    dapAnDungB.start();
                                    cauQuestion++;
                                    CountDownTimer countDownTimer1 = new CountDownTimer(4000,1000) {
                                        @Override
                                        public void onTick(long millisUntilFinished) {
                                            txtDapAnB.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                            animation = AnimationUtils.loadAnimation(getActivity(),R.anim.animation_true);
                                            txtDapAnB.startAnimation(animation);
                                        }

                                        @Override
                                        public void onFinish() {
                                            txtDapAnB.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_normal);
                                            CountDownTimer countDownTimer1 = new CountDownTimer(2000,1000) {
                                                @Override
                                                public void onTick(long millisUntilFinished) {

                                                    swapFagment();
                                                }

                                                @Override
                                                public void onFinish() {
                                                    doiCauhoi();
                                                }
                                            }.start();

                                        }
                                    }.start();
                                } else {
                                    if (trueCase ==4){
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lose_d);
                                        mediaPlayer.start();
                                        txtDapAnD.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                    }else
                                    if (trueCase ==3){
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lose_c);
                                        mediaPlayer.start();
                                        txtDapAnC.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                    }else
                                    if (trueCase ==1){
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lose_a);
                                        mediaPlayer.start();
                                        txtDapAnA.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                    }
                                    txtDapAnB.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_wrong);
                                    CountDownTimer countDownTimer1 = new CountDownTimer(2000,1000) {
                                        @Override
                                        public void onTick(long millisUntilFinished) {

                                        }

                                        @Override
                                        public void onFinish() {
                                            gameOver();
                                        }
                                    }.start();
                                }
                            }
                        }.start();

                    }
                });





                txtDapAnC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        traLoiC = MediaPlayer.create(getActivity(),R.raw.ans_c2);
                        traLoiC.start();
                        dungThoiGian();
                        isCancelCountDown = true;
                        cancelButton();
                        voHieuHoaButton();
                        dA = 3;
                        CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                txtDapAnC.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_selected);
                                animation = AnimationUtils.loadAnimation(getActivity(),R.anim.animation_true);
                                txtDapAnC.startAnimation(animation);
                            }

                            @Override
                            public void onFinish() {
                                if (dA == trueCase) {
                                    dapAnDungC = MediaPlayer.create(getActivity(),R.raw.true_c2);
                                    dapAnDungC.start();
                                    cauQuestion++;

                                    CountDownTimer countDownTimer1 = new CountDownTimer(4000,1000) {
                                        @Override
                                        public void onTick(long millisUntilFinished) {
                                            txtDapAnC.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                            animation = AnimationUtils.loadAnimation(getActivity(),R.anim.animation_true);
                                            txtDapAnC.startAnimation(animation);
                                        }

                                        @Override
                                        public void onFinish() {
                                            txtDapAnC.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_normal);
                                            CountDownTimer countDownTimer1 = new CountDownTimer(2000,1000) {
                                                @Override
                                                public void onTick(long millisUntilFinished) {
                                                    swapFagment();
                                                }

                                                @Override
                                                public void onFinish() {
                                                    doiCauhoi();
                                                }
                                            }.start();

                                        }
                                    }.start();
                                } else {
                                    if (trueCase ==2){
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lose_b);
                                        mediaPlayer.start();
                                        txtDapAnB.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                    }else
                                    if (trueCase ==4){
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lose_d);
                                        mediaPlayer.start();
                                        txtDapAnD.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                    }else
                                    if (trueCase ==1){
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lose_a);
                                        mediaPlayer.start();
                                        txtDapAnA.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                    }
                                    txtDapAnC.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_wrong);
                                    CountDownTimer countDownTimer1 = new CountDownTimer(2000,1000) {
                                        @Override
                                        public void onTick(long millisUntilFinished) {

                                        }

                                        @Override
                                        public void onFinish() {
                                            gameOver();
                                        }
                                    }.start();

                                }
                            }
                        }.start();

                    }
                });





                txtDapAnD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        traLoiD = MediaPlayer.create(getActivity(),R.raw.ans_d2);
                        traLoiD.start();
                        dungThoiGian();
                        isCancelCountDown = true;
                        cancelButton();
                        voHieuHoaButton();
                        dA = 4;
                        CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                txtDapAnD.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_selected);
                                animation = AnimationUtils.loadAnimation(getActivity(),R.anim.animation_true);
                                txtDapAnD.startAnimation(animation);
                            }

                            @Override
                            public void onFinish() {
                                if (dA == trueCase) {
                                    dapAnDungD = MediaPlayer.create(getActivity(),R.raw.true_d3);
                                    dapAnDungD.start();
                                    cauQuestion++;
                                    CountDownTimer countDownTimer1 = new CountDownTimer(4000,1000) {
                                        @Override
                                        public void onTick(long millisUntilFinished) {
                                            txtDapAnD.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                            animation = AnimationUtils.loadAnimation(getActivity(),R.anim.animation_true);
                                            txtDapAnD.startAnimation(animation);
                                        }

                                        @Override
                                        public void onFinish() {
                                            txtDapAnD.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_normal);
                                            CountDownTimer countDownTimer1 = new CountDownTimer(2000,1000) {
                                                @Override
                                                public void onTick(long millisUntilFinished) {
                                                    swapFagment();
                                                }

                                                @Override
                                                public void onFinish() {
                                                    doiCauhoi();
                                                }
                                            }.start();

                                        }
                                    }.start();
                                } else {
                                    if (trueCase ==2){
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lose_b);
                                        mediaPlayer.start();
                                        txtDapAnB.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                    }else
                                    if (trueCase ==3){
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lose_c);
                                        mediaPlayer.start();
                                        txtDapAnC.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                    }else
                                    if (trueCase ==1){
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lose_a);
                                        mediaPlayer.start();
                                        txtDapAnA.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_true);
                                    }
                                    txtDapAnD.setBackgroundResource(R.drawable.atp__activity_player_layout_play_answer_background_wrong);
                                    CountDownTimer countDownTimer1 = new CountDownTimer(2000,1000) {
                                        @Override
                                        public void onTick(long millisUntilFinished) {

                                        }

                                        @Override
                                        public void onFinish() {
                                            gameOver();
                                        }
                                    }.start();
                                }
                            }
                        }.start();

                    }
                });

            }
    }


    private void doiCauhoi(){
        FragmentMain fragmentMain = (FragmentMain) getActivity();
        fragmentMain.swithFragment(fragmentMain.getFragmentPlay());
        initCauHoi();
    }
    private void gameOver(){
        Intent intent = new Intent(getContext(),Act_EndGame.class);
        intent.putExtra("Score",txtScore.getText());
        startActivity(intent);
    }
    private void cancelButton(){
        btnDoiQuestion.setEnabled(false);
        btnHoiKhanGia.setEnabled(false);
        btnCall.setEnabled(false);
        btn5050.setEnabled(false);
        btnStop.setEnabled(false);
    }

    private void resetButton(){
        btnDoiQuestion.setEnabled(true);
        btnHoiKhanGia.setEnabled(true);
        btnCall.setEnabled(true);
        btn5050.setEnabled(true);
        btnStop.setEnabled(true);
    }
    private void initView() {
        arrayLists = new ArrayList[]{arrayList1,arrayList2,arrayList3,arrayList4,arrayList5,arrayList6,arrayList7,arrayList8,arrayList9,arrayList10,arrayList11,arrayList12,arrayList13,arrayList14,arrayList15,arrayList16};
        txtNumer = (TextView) getActivity().findViewById(R.id.txtNumber);
        txtQuestion = (TextView) getActivity().findViewById(R.id.txtQuesTion);
        txtDapAnA = (TextView) getActivity().findViewById(R.id.txtCau1);
        txtDapAnB = (TextView) getActivity().findViewById(R.id.txtCau2);
        txtDapAnC = (TextView) getActivity().findViewById(R.id.txtCau3);
        txtDapAnD = (TextView) getActivity().findViewById(R.id.txtCau4);
        txtScore = (TextView) getActivity().findViewById(R.id.txtScore);
        txtTime = (TextView) getActivity().findViewById(R.id.txtTime);
        ringProgressBar = (RingProgressBar) getActivity().findViewById(R.id.progreesBar);


        btn5050 = (ImageButton) getActivity().findViewById(R.id.btn5050);
        btnCall = (ImageButton) getActivity().findViewById(R.id.btnCall);
        btnDoiQuestion = (ImageButton) getActivity().findViewById(R.id.btnRefest);
        btnStop = (ImageButton) getActivity().findViewById(R.id.btnstop);
        btnHoiKhanGia = (ImageButton) getActivity().findViewById(R.id.btnNguoiThan);


        btnCall.setOnClickListener(this);
        btnHoiKhanGia.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btn5050.setOnClickListener(this);
        btnDoiQuestion.setOnClickListener(this);



    }

    private void initDialog() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_stop);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        Button btnDung = (Button) dialog.findViewById(R.id.btnDongYDung);
        Button btnHuy = (Button) dialog.findViewById(R.id.btnKoDung);
        btnDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Act_EndGame.class);
                intent.putExtra("Score",txtScore.getText());
                startActivity(intent);
                dialog.dismiss();
                getActivity().finish();

            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void initDialog1() {

        dialog1 = new Dialog(getContext());
        dialog1.setContentView(R.layout.diglog_khan_gia);
        dialog1.setCancelable(false);
        dialog1.setCanceledOnTouchOutside(false);
        Button btnOK = (Button) dialog1.findViewById(R.id.btnOK);
        barChart = (BarChart) dialog1.findViewById(R.id.barChart1);

        Toast.makeText(getContext(),""+trueCase,Toast.LENGTH_SHORT).show();
        if (trueCase ==1){
            entries.add(new BarEntry(75, 0));
            entries.add(new BarEntry(5, 1));
            entries.add(new BarEntry(30, 2));
            entries.add(new BarEntry(10, 3));
        }
        if (trueCase ==2){
            entries.add(new BarEntry(5, 0));
            entries.add(new BarEntry(75, 1));
            entries.add(new BarEntry(30, 2));
            entries.add(new BarEntry(10, 3));
        }
        if (trueCase ==3){
            entries.add(new BarEntry(30, 0));
            entries.add(new BarEntry(5, 1));
            entries.add(new BarEntry(75, 2));
            entries.add(new BarEntry(10, 3));
        }
        if (trueCase ==4) {
            entries.add(new BarEntry(10, 0));
            entries.add(new BarEntry(5, 1));
            entries.add(new BarEntry(30, 2));
            entries.add(new BarEntry(70, 3));
        }

        BarDataSet dataset = new BarDataSet(entries, "tỉ lệ đáp án");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("A");
        labels.add("B");
        labels.add("C");
        labels.add("D");

        BarData data = new BarData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setData(data);
        barChart.animateY(6000);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });

    }
    private void readData() {
        arrayList1.clear();
        arrayList2.clear();
        arrayList3.clear();
        arrayList4.clear();
        arrayList5.clear();
        arrayList6.clear();
        arrayList7.clear();
        arrayList8.clear();
        arrayList9.clear();
        arrayList10.clear();
        arrayList11.clear();
        arrayList12.clear();
        arrayList13.clear();
        arrayList14.clear();
        arrayList15.clear();
        arrayList16.clear();
        arrayList1.addAll(questionSQLite.getDataQuestion16());
        arrayList2.addAll(questionSQLite.getDataQuestion16());
        arrayList3.addAll(questionSQLite.getDataQuestion16());
        arrayList4.addAll(questionSQLite.getDataQuestion16());
        arrayList5.addAll(questionSQLite.getDataQuestion16());
        arrayList6.addAll(questionSQLite.getDataQuestion16());
        arrayList7.addAll(questionSQLite.getDataQuestion16());
        arrayList8.addAll(questionSQLite.getDataQuestion16());
        arrayList9.addAll(questionSQLite.getDataQuestion16());
        arrayList10.addAll(questionSQLite.getDataQuestion16());
        arrayList11.addAll(questionSQLite.getDataQuestion16());
        arrayList12.addAll(questionSQLite.getDataQuestion16());
        arrayList13.addAll(questionSQLite.getDataQuestion16());
        arrayList14.addAll(questionSQLite.getDataQuestion16());
        arrayList15.addAll(questionSQLite.getDataQuestion16());
        arrayList16.addAll(questionSQLite.getDataQuestion16());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn5050:
                MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),R.raw.sound5050_2);
                mediaPlayer.start();
                CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        if (trueCase ==1){
                            txtDapAnC.setEnabled(false);
                            txtDapAnB.setEnabled(false);
                            txtDapAnC.setText("");
                            txtDapAnB.setText("");
                        }
                        if (trueCase ==2){
                            txtDapAnA.setEnabled(false);
                            txtDapAnD.setEnabled(false);
                            txtDapAnA.setText("");
                            txtDapAnD.setText("");
                        }
                        if (trueCase ==3){
                            txtDapAnA.setEnabled(false);
                            txtDapAnD.setEnabled(false);
                            txtDapAnA.setText("");
                            txtDapAnD.setText("");
                        }
                        if (trueCase ==4){
                            txtDapAnC.setEnabled(false);
                            txtDapAnA.setEnabled(false);
                            txtDapAnA.setText("");
                            txtDapAnC.setText("");
                        }
                    }
                }.start();

                btn5050.setImageResource(R.drawable.atp__activity_player_button_image_help_5050_x);
                btn5050.setEnabled(false);

                break;
            case R.id.btnCall:
                MediaPlayer mediaPlayer2 = MediaPlayer.create(getActivity(),R.raw.help_call);
                mediaPlayer2.start();
                initDialogGoiDien();
                dialog4.show();
                btnCall.setEnabled(false);

                break;
            case R.id.btnstop:
                initDialog();
                dialog.show();
                break;
            case R.id.btnRefest:
                dungThoiGian();
                readData();
                initCauHoi();
                ktDungSai();

                btnDoiQuestion.setImageResource(R.drawable.atp__activity_player_button_image_help_change_question_x);
                btnDoiQuestion.setEnabled(false);
                break;
            case R.id.btnNguoiThan:
                MediaPlayer mediaPlayer1 = MediaPlayer.create(getActivity(),R.raw.khan_gia);
                mediaPlayer1.start();
                initDialog1();
                dialog1.show();
                btnHoiKhanGia.setImageResource(R.drawable.atp__activity_player_button_image_help_audience_x);
                btnHoiKhanGia.setEnabled(false);
                break;
        }
    }

}

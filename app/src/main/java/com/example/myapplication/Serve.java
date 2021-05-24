package com.example.myapplication;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Serve extends AppCompatActivity implements View.OnClickListener {
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,
            btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,
            btn21,btn22,btn23,btn24,btn25,btn26,btn27,btn28,btn29,btn30,
            btn31,btn32,btn33,btn34,btn35,btn36,btn37,btn38,btn39,btn40;
    private Button[] mButton = new Button[40];
    private ArrayList<String> mDataList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part3_serve);

        mDataList = new ArrayList<String>();

        mButton[0] = findViewById(R.id.btn1);
        mButton[1] = findViewById(R.id.btn2);
        mButton[2] = findViewById(R.id.btn3);
        mButton[3] = findViewById(R.id.btn4);
        mButton[4] = findViewById(R.id.btn5);
        mButton[5] = findViewById(R.id.btn6);
        mButton[6] = findViewById(R.id.btn7);
        mButton[7] = findViewById(R.id.btn8);
        mButton[8] = findViewById(R.id.btn9);
        mButton[9] = findViewById(R.id.btn10);

        mButton[10] = findViewById(R.id.btn11);
        mButton[11] = findViewById(R.id.btn12);
        mButton[12] = findViewById(R.id.btn13);
        mButton[13] = findViewById(R.id.btn14);
        mButton[14] = findViewById(R.id.btn15);
        mButton[15] = findViewById(R.id.btn16);
        mButton[16] = findViewById(R.id.btn17);
        mButton[17] = findViewById(R.id.btn18);
        mButton[18] = findViewById(R.id.btn19);
        mButton[19] = findViewById(R.id.btn20);

        mButton[20] = findViewById(R.id.btn21);
        mButton[21] = findViewById(R.id.btn22);
        mButton[22] = findViewById(R.id.btn23);
        mButton[23] = findViewById(R.id.btn24);
        mButton[24] = findViewById(R.id.btn25);
        mButton[25] = findViewById(R.id.btn26);
        mButton[26] = findViewById(R.id.btn27);
        mButton[27] = findViewById(R.id.btn28);
        mButton[28] = findViewById(R.id.btn29);
        mButton[29] = findViewById(R.id.btn30);

        mButton[30] = findViewById(R.id.btn31);
        mButton[31] = findViewById(R.id.btn32);
        mButton[32] = findViewById(R.id.btn33);
        mButton[33] = findViewById(R.id.btn34);
        mButton[34] = findViewById(R.id.btn35);
        mButton[35] = findViewById(R.id.btn36);
        mButton[36] = findViewById(R.id.btn37);
        mButton[37] = findViewById(R.id.btn38);
        mButton[38] = findViewById(R.id.btn39);
        mButton[39] = findViewById(R.id.btn40);

        for(int i =0; i<40; i++){
            mButton[i].setTag(i);
            mButton[i].setOnClickListener(this);
            mDataList.add((i+1)+"번");
        }

    }

    @Override
    public void onClick(View v) {
        Button newButton = (Button)v;
        for(Button tempButton : mButton)
        {
            // 클릭된 버튼을 찾았으면
            if(tempButton == newButton)
            {
                newButton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_BUTTON_PRESS: {

                                newButton.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.black));
                                break;
                            }
                            case MotionEvent.ACTION_BUTTON_RELEASE:

                                newButton.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.white));
                                break;
                        }
                        return false;
                    }
                });
                // 위에서 저장한 버튼의 포지션을 태그로 가져옴
                int position = (Integer)v.getTag();



                // 태그로 가져온 포지션을 이용해 리스트에서 출력할 데이터를 꺼내서 토스트 메시지 출력
                Toast.makeText(this, mDataList.get(position), Toast.LENGTH_SHORT).show();
            }
        }

    }
}

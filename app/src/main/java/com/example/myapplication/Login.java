package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText et_id,et_pass;
    private Button btn_login;
    private String str_id,str_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part1_login);



        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener((view) -> {

            str_id = et_id.getText().toString(); //  이건 왜 필요한지 아직 모르겠엄....
            str_pw = et_pass.getText().toString();

            if ( et_id.getText().toString().equals("sponge") && et_pass.getText().toString().equals("1234") ) {

                Intent intent = new Intent(Login.this, Choice.class);
                startActivity(intent);
                Log.d("MY TAG", "초이스 창으로 넘기기");


            }
            else{
                Toast.makeText(getApplicationContext(),"ID와 PW를 다시 입력해 주세요.",Toast.LENGTH_SHORT).show();
            }

        });

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_id.setOnClickListener((view) ->{

            Toast.makeText(getApplicationContext(),"INSERT YOUR ID",Toast.LENGTH_SHORT).show(); // 메세지 전송 글자 띄우기 (글자 화면에 표시)

        });
        et_pass.setOnClickListener((view) ->{

            Toast.makeText(getApplicationContext(),"INSERT YOUR PASSWORD",Toast.LENGTH_SHORT).show(); // 메세지 전송 글자 띄우기 (글자 화면에 표시)

        });

    }
}
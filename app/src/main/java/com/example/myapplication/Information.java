package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Information extends AppCompatActivity {

    private TextView info_num,info_price;
    private MenuAdapter adapter; // extends 페이지면 액티비티 불러오기 못함;;
    private String Number;
    private String Price;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part5_information);

        Intent intent = getIntent();
        Number = intent.getStringExtra("number");
        Price = intent.getStringExtra("Price");


        Log.d("Price","Price");

        info_num= findViewById(R.id.info_num);
        info_price = findViewById(R.id.info_price);


        info_num.setText("Table: "+Number);
        info_price.setText("Price: "+Price +"원");


    }
}

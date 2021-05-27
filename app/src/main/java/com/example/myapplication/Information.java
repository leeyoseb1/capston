package com.example.myapplication;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Information extends AppCompatActivity {

    private TextView info_num,info_price;
    private MenuAdapter adapter;
    private Serve serve;
    private ArrayList<String>  mDatalist;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part5_information);

        info_num= findViewById(R.id.info_num);
        info_price = findViewById(R.id.info_price);

        mDatalist = serve.getmDataList();

        info_num.setText("Table Number : "+mDatalist);

    }
}

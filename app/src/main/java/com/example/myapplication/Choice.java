package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Choice extends AppCompatActivity {

    private Button btn_serve,btn_menu;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part2_choice);

        btn_menu = findViewById(R.id.btn_menu);
        btn_serve = findViewById(R.id.btn_server);

        btn_menu.setOnClickListener(view -> {
            Intent intent_to_menu = new Intent(Choice.this, Menu.class);
            startActivity(intent_to_menu);

        });
        btn_serve.setOnClickListener(view -> {
            Intent intent_to_serve = new Intent(Choice.this,Serve.class);
            startActivity(intent_to_serve);
        });
    }
}

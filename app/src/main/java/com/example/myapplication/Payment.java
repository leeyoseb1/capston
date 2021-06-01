package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Payment extends AppCompatActivity implements MenuClickListener{

    private RecyclerView recyclerView5;
    private MenuAdapter adapter;
    private Button btn_payment;
    private TextView total_money;
    private SpannableString content;
    private String Price ;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part4_payment);

        init1();    getData();


      btn_payment = findViewById(R.id.btn_payment);

      btn_payment.setOnClickListener((view)->{
          Intent intent = new Intent(Payment.this, Serve.class);
          intent.putExtra("Payment",Price);
          startActivity(intent);
      });
    }

    private void init1() {
        recyclerView5 = findViewById(R.id.recyclerView5);
        total_money = (TextView)findViewById(R.id.total_money);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView5.setLayoutManager(linearLayoutManager);

        adapter = new MenuAdapter(3,this);
        recyclerView5.setAdapter(adapter);

    }
    private void getData () {
        Intent intent =getIntent();
        ArrayList<MenuData> list = (ArrayList<MenuData>)intent.getSerializableExtra("list"); // 인텐트로 객체자체를 옮길때 Serial사용

        int sum =0;

        for (int i = 0; i < list.size(); i++){
            adapter.addItem(list.get(i));
        }Log.d("MONEY","MONEY");
        //데이터가 어떤것이 들어있는지 모르니까 전부 출력
        //
        for( int j = 0; j<list.size(); j++){
            sum += list.get(j).getContent();
        }
        content = new SpannableString(String.valueOf(sum)+"원");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        total_money.setText(content); //

        Price = String.valueOf(sum);
        Log.d("MONEY1","MONEY");

    }
    @Override
    public void onClickMenu(MenuData menu, int adapterNo) {
        adapter.addItem(menu);
        adapter.notifyDataSetChanged();
        Log.d("onClickMenu", String.format("%s %s", menu.getTitle(), menu.getContent()));
    }
    public String getPrice(){

       return this.Price;
    }
}


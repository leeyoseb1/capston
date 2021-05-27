package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu extends AppCompatActivity implements MenuClickListener {

    private MenuData menuData;
    private MenuAdapter adapter;
    private Button save_item;
    private TextView total_money1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.part3_menu);

        init1();        getData1();
        init2();        getData2();
        init3();        getData3();
        init4();        getData4();

        save_item = findViewById(R.id.save_item);
        total_money1 = findViewById(R.id.total_money1);

        ArrayList<MenuData> list = adapter.getList();
        int sum = 0;
        for( int j = 0; j<list.size(); j++){
            sum += list.get(j).getContent();
        }
        SpannableString content = new SpannableString("합계 "+String.valueOf(sum)+"원");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);

        total_money1.setText(content); //


        save_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Payment.class);

                intent.putExtra("list", list);
                startActivity(intent);

            }

        });

    }

    private void init1() {
        RecyclerView recyclerView1 = findViewById(R.id.recyclerView1);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL); // recyclerview를 가로로 보여주는 인터페이스
        recyclerView1.setLayoutManager(linearLayoutManager1);

        adapter = new MenuAdapter(0, this);
        recyclerView1.setAdapter(adapter);
    }

    private void init2() {
        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL); // recyclerview를 가로로 보여주는 인터페이스
        recyclerView2.setLayoutManager(linearLayoutManager2);

        adapter = new MenuAdapter(1, this);
        recyclerView2.setAdapter(adapter);
    }

    private void init3() {
        RecyclerView recyclerView3 = findViewById(R.id.recyclerView3);

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this);
        linearLayoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL); // recyclerview를 가로로 보여주는 인터페이스
        recyclerView3.setLayoutManager(linearLayoutManager3);

        adapter = new MenuAdapter(2, this);
        recyclerView3.setAdapter(adapter);
    }

    private void init4() {
        RecyclerView recyclerView4 = findViewById(R.id.recyclerView4);

        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(this);
        recyclerView4.setLayoutManager(linearLayoutManager4);

        adapter = new MenuAdapter(3, this);
        recyclerView4.setAdapter(adapter);



        /**
         * 궁금한점 왜 rv4에 저장된 아이템데이터가 나오는가? 다시한번 이해
         */
    }

    private void getData1() {
        // 임의의 데이터입니다.
        List<String> listTitle1 = Arrays.asList("햄버거","피자","치킨","콜라","감자튀김","아이스크림","치즈볼","빅맥");
        List<Integer> listContent1 = Arrays.asList(
                1000,2000,3000,4000, 5000, 6000, 7000,1000 );
        List<Integer> listResId1 = Arrays.asList(
                R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher
        );
        for (int i = 0; i < listTitle1.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            MenuData data1 = new MenuData();
            data1.setTitle(listTitle1.get(i));
            data1.setContent(listContent1.get(i));
            data1.setResId(listResId1.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data1);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }
    private void getData2() {
        // 임의의 데이터입니다.
        List<String> listTitle1 = Arrays.asList("햄버거","피자","치킨","콜라","감자튀김","아이스크림","치즈볼","빅맥");
        List<Integer> listContent1 = Arrays.asList(
                100,200,300,400, 500, 600, 700,1000 );
        List<Integer> listResId1 = Arrays.asList(
                R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher
        );
        for (int i = 0; i < listTitle1.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            MenuData data2 = new MenuData();
            data2.setTitle(listTitle1.get(i));
            data2.setContent(listContent1.get(i));
            data2.setResId(listResId1.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data2);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }
    private void getData3() {
        // 임의의 데이터입니다.
        List<String> listTitle1 = Arrays.asList("슬러시","토네이도","초코아이스크림","팥빙수","아메리카노","카라멜마키아또","카페라떼","오렌지쥬스");
        List<Integer> listContent1 = Arrays.asList(
                10000,2000,30000,40000, 50000, 60000, 70000,10000 );
        List<Integer> listResId1 = Arrays.asList(
                R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher
        );
        for (int i = 0; i < listTitle1.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            MenuData data = new MenuData();
            data.setTitle(listTitle1.get(i));
            data.setContent(listContent1.get(i));
            data.setResId(listResId1.get(i));
            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);

        }
        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }
    private void getData4() {


        }
    @Override
    public void onClickMenu(MenuData menu, int adapterNo) {
        adapter.addItem(menu);
        adapter.notifyDataSetChanged();

        int sum = 0;
        for (MenuData m : adapter.getList()){
            sum += m.getContent()
            ;
        }
        total_money1.setText(sum+"원");// 스트링 형태 바꿔주삼
        Log.d("onClickMenu", String.format("%s %s", menu.getTitle(), menu.getContent()));
    }
}
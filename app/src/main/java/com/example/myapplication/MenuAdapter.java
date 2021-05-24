package com.example.myapplication;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ItemViewHolder> {

    private MenuClickListener menuClickListener;
    private int adapterNo;
    // Menu클래스에서 어댑터를 정의할 형태를 만들어준 것.
    public MenuAdapter(int adapterNo, MenuClickListener menuClickListener){
        this.adapterNo = adapterNo;
        this.menuClickListener = menuClickListener;
    }

    // adapter에 들어갈 list 입니다.
    private ArrayList<MenuData> listData = new ArrayList<>();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        View view;
        if(adapterNo == 3){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.part3_item2_list, parent, false);
            return new ItemViewHolder(view);
        } //3번 어댑터 일때는 다른형태의 뷰

        else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.part3_item_list, parent, false);
            return new ItemViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        MenuData data = listData.get(position);
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return listData.size();
    }

    public MenuData getItem(int position) {
        return listData.get(position);
    }


    void addItem(MenuData data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(data);
    }

    public ArrayList<MenuData> getList() {
        return this.listData; // 일케 하라는대로 하시면 됩니당
    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView textView1;
        private TextView textView2;
        private ImageView imageView;
        private MenuData data;

        ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAbsoluteAdapterPosition();
                    int sum = 0;

                    Log.d("TEST", "TEST" + pos);
                    // 리스너 객체의 메서드 호출
                    if (adapterNo == 3) return; // 3번 어뎁터는 아무일도 안일어남
                        if (pos != RecyclerView.NO_POSITION) {

                        MenuData data = listData.get(pos);
                        menuClickListener.onClickMenu(data, adapterNo); // 클릭된 해당 어뎁터 아이템이을 변수로 사용하여 메인액티비에 add추가

                    }
                }
            });
            if(adapterNo ==3){
                textView1 = itemView.findViewById(R.id.textView1);
                textView2 = itemView.findViewById(R.id.textView2);
            }
            else{
                textView1 = itemView.findViewById(R.id.textView1);
                textView2 = itemView.findViewById(R.id.textView2);
                imageView = itemView.findViewById(R.id.imageView);
            }

        }
        void onBind(MenuData data) {
            this.data = data;

            if(adapterNo == 3){
                textView1.setText(data.getTitle());
                textView2.setText(data.getContent()+"원");

            }
            else{
                textView1.setText(data.getTitle());
                textView2.setText(data.getContent()+"원");
                imageView.setImageResource(data.getResId());
            }

        }
    }
}
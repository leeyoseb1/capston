package com.example.myapplication;

import android.view.MenuItem;

/**
 * 메뉴가 클릭되었을 때 호출되는 메소드를 정의한
 * 인터페이스
 */
public interface MenuClickListener {

    /**
     * 메뉴가 클릭되었을 때 호출되는 메소드
     * @param menu 해당하는 포지션의 아이템 데이터
     * @param adapterNo 몇번째 어뎁터인지
     */
    void onClickMenu(MenuData menu, int adapterNo);

}

package com.example.myapplication;

import java.io.Serializable;

public class MenuData implements Serializable {

    private static final long serialVersionUID =1L;
    private String title;
    private int content;
    private int resId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
package com.example.myapp.bean;

import android.graphics.Bitmap;

public class MyNote {
    private String tag;
    private String content;
    private String date;
    private String hot;
    private String authorName;
    private int discussNum;
    private int dzNum;
    private int scNum;

    public MyNote(String tag, String content, String date, String hot, String authorName , int discussNum, int dzNum, int scNum) {
        this.tag = tag;
        this.content = content;
        this.date = date;
        this.hot = hot;
        this.authorName = authorName;
        this.discussNum = discussNum;
        this.dzNum = dzNum;
        this.scNum = scNum;
    }

    public String getTag() {
        return tag;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getHot() {
        return hot;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getDiscussNum() {
        return discussNum;
    }

    public int getDzNum() {
        return dzNum;
    }

    public int getScNum() {
        return scNum;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setDiscussNum(int discussNum) {
        this.discussNum = discussNum;
    }

    public void setDzNum(int dzNum) {
        this.dzNum = dzNum;
    }

    public void setScNum(int scNum) {
        this.scNum = scNum;
    }
}

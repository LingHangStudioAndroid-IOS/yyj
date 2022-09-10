package com.example.myapp.bean;

public class DiscussBean {
    private int articleID;
    private String writerID;
    private String content;

    public DiscussBean(int articleID, String writerID, String content) {
        this.articleID = articleID;
        this.writerID = writerID;
        this.content = content;
    }


    public int getArticleID() {
        return articleID;
    }

    public String getWriterID() {
        return writerID;
    }

    public String getContent() {
        return content;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public void setWriterID(String writerID) {
        this.writerID = writerID;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

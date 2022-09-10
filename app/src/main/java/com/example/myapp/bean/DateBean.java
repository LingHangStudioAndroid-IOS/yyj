package com.example.myapp.bean;

import org.litepal.crud.LitePalSupport;

public class DateBean extends LitePalSupport {
    int year;
    int month;
    int day;

    public DateBean() {
    }

    public DateBean(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;

    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

}

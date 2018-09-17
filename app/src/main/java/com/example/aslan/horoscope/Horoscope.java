package com.example.aslan.horoscope;

public class Horoscope {
    private String title;
    private String dailyDesc;
    private String weeklyDesc;
    private String monthlyDesc;
    private String yearlyDesc;
    private String date;
    private int thumbnail;

    public Horoscope() {
    }

    public Horoscope(String title, String dailyDesc, String weeklyDesc, String monthlyDesc, String yearlyDesc, String date, int thumbnail) {
        this.title = title;
        this.dailyDesc = dailyDesc;
        this.weeklyDesc = weeklyDesc;
        this.monthlyDesc = monthlyDesc;
        this.yearlyDesc = yearlyDesc;
        this.date = date;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDailyDesc() {
        return dailyDesc;
    }

    public void setDailyDesc(String dailyDesc) {
        this.dailyDesc = dailyDesc;
    }

    public String getWeeklyDesc() {
        return weeklyDesc;
    }

    public void setWeeklyDesc(String weeklyDesc) {
        this.weeklyDesc = weeklyDesc;
    }

    public String getMonthlyDesc() {
        return monthlyDesc;
    }

    public void setMonthlyDesc(String monthlyDesc) {
        this.monthlyDesc = monthlyDesc;
    }

    public String getYeaerlyDesc() {
        return yearlyDesc;
    }

    public void setYeaerlyDesc(String yearlyDesc) {
        this.yearlyDesc = yearlyDesc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}

package Aplication_Gui;

import java.util.ArrayList;

public class Shop_date {
    private String name;
    private String month;
    private int year;
    private int day;
    private static ArrayList<Shop_date> shop_dates = new ArrayList();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String toString() {
        return "Shop_date{name=\'" + this.name + '\'' + ", month=\'" + this.month + '\'' + ", year=" + this.year + ", day=" + this.day + '}';
    }

    public Shop_date(String name, String month, int year, int day) {
        this.name = name;
        this.month = month;
        this.year = year;
        this.day = day;
    }

    public Shop_date() {
    }
}

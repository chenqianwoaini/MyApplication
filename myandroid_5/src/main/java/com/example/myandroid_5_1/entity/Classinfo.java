package com.example.myandroid_5_1.entity;

/**
 * Created by 乾 on 2017/10/10.
 */

public class Classinfo {
    private  int head;
    private  String name;
    private  String phone;
    private  boolean hasChecked;
    public Classinfo() {

    }

    public boolean isHasChecked() {
        return hasChecked;
    }

    public void setHasChecked(boolean hasChecked) {
        this.hasChecked = hasChecked;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

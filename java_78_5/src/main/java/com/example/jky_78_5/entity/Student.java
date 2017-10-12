package com.example.jky_78_5.entity;

/**
 * Created by 乾 on 2017/10/5.
 */

public class Student {
    /**头像*/
    public int head;
    /**姓名*/
    public String name;
    /**电话号码*/
    public String tel;
    /**选中的属性*/
    public boolean isChecked;


    public Student() {
    }
    public Student(String name) {
        this.name = name;
    }

    public Student(int head, String name, String tel,boolean isChecked,int type) {
        this.head = head;
        this.name = name;
        this.tel = tel;
        this.isChecked = isChecked;

    }

    @Override
    public String toString() {
        return "Student{" +
                "head=" + head +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}

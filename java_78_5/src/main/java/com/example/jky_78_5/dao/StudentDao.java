package com.example.jky_78_5.dao;

import com.example.jky_78_5.R;
import com.example.jky_78_5.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 乾 on 2017/10/5.
 */

public class StudentDao {

    int heads[] = {R.drawable.face1, R.drawable.face2, R.drawable.face3, R.drawable.face4, R.drawable.face5, R.drawable.face6, R.drawable.face7, R.drawable.face8};
    String names[] = {"张三", "张四", "张五", "关羽", "赵飞", "陈倩", "成龙", "金所炫"};
    String tels[] = {"119", "112", "114", "120", "122", "110", "911", "315"};
    /**查所有*/
    public List<Student> getAllStudents(){
        List<Student> lists = new ArrayList<>();
        Student stu1 = new Student(R.drawable.yuanxing2,"王武","11011",false,1);
        Student stu2 = new Student(R.drawable.yuanxing3,"波闷子","11911",false,1);
        Student stu3 = new Student(R.drawable.yuanxing4,"大黄","12011",false,1);
        Student stu4 = new Student(R.drawable.yuanxing5,"孙世豪","11411",false,1);
        Student stu5 = new Student(R.drawable.yuanxing6,"抖哥","10086",false,1);
        Student stu6 = new Student(R.drawable.yuanxing7,"球大爷","12580",false,1);
        Student stu7 = new Student(R.drawable.yuanxing8,"god佩","10000",false,1);
        Student stu8 = new Student(R.drawable.yuanxing9,"小汤汤","91111",false,1);
        Student stu9 = new Student(R.drawable.yuanxing10,"龙海","95533",false,1);

        lists.add(new Student("第一组"));
        lists.add(stu1);
        lists.add(stu2);
        lists.add(stu3);
        lists.add(stu4);
        lists.add(new Student("第二组"));
        lists.add(stu5);
        lists.add(stu6);
        lists.add(stu7);
        lists.add(stu8);
        lists.add(new Student("第三组"));
        lists.add(stu9);
        lists.add(stu9);
        lists.add(stu9);
        lists.add(stu9);
        lists.add(new Student("第四组"));
        lists.add(stu9);
        lists.add(stu9);
        lists.add(stu9);
        lists.add(stu9);
        lists.add(new Student("第五组"));
        lists.add(stu9);
        lists.add(stu9);
        lists.add(stu9);
        lists.add(stu9);

        return lists;
    }
}


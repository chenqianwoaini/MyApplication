package com.example.jky_78_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jky_78_5.adapter.StudentAdater;
import com.example.jky_78_5.dao.StudentDao;
import com.example.jky_78_5.entity.Student;
import com.example.jky_78_5.tools.Tools;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv_student;
    private StudentAdater studentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //给数据给Adapter,让Adapter帮我们组装数据
        StudentDao stuDao = new StudentDao();
        List<Student> allStudents = stuDao.getAllStudents();
        //构造给（第一次用），set给（后续）
        studentAdapter = new StudentAdater(allStudents,MainActivity.this);
        //
        lv_student.setAdapter(studentAdapter);
        //添加事件监听
        lv_student.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student stu = (Student) studentAdapter.getItem(position);
               Tools.myToast(MainActivity.this,stu.toString()+"-"+position);
            }
        });
    }
    private void initView(){
        lv_student = (ListView) findViewById(R.id.lv_student);
    }
}


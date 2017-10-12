package com.example.jky_78_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView actv;
    private Spinner sp_class;
    private ListView lv_classinfo;
    private GridView gv_seat;
    private ArrayAdapter spAdapter;
    private ArrayAdapter actvAdapter;
    //如果要放图片，SimpleAdapter，特点：数据必须封装成List<Map<key,value>>
    private SimpleAdapter lvAdapter;
    private SimpleAdapter gvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //准备空间
        initView();
        getSpinner();//注意：数据最终是需要得到的，所有的适配器应该设置为全局
        getActv();
        getData();

        getListView();
        getGridView();
        listener();
    }
    private void listener(){
        //为ListView添加事件监听
        lv_classinfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //最重要的是position  就是用户点击条目的下标，它与适配器中数据下标一致
                Map<String,Object> map = (Map<String,Object>)lvAdapter.getItem(position);
                Toast.makeText(MainActivity.this,map.get("name")+","+map.get("age"),Toast.LENGTH_LONG).show();
            }
        });
    }
    //准备数据
    List<Map<String,Object>> lists;
    private void getData(){
        lists = new ArrayList<>();
        int heads[]={R.drawable.gasses,R.drawable.luggage,R.drawable.music,R.drawable.taxicab};
        for (int i=0;i<20;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("name","陈乾"+i);
            map.put("state","1388888888"+i);
            map.put("head",heads[i%4]);
            lists.add(map);
        }
    }
    private void getListView(){
        lvAdapter = new SimpleAdapter(
                MainActivity.this,//上下文
                lists,//List<Map<key,value>>
                R.layout.lv_classinfo_item,//xml,自定义
                new String[]{"head","name","state"},//key
                new int[]{R.id.tv_name,R.id.tv_age,R.id.tv_state}
        );
        lv_classinfo.setAdapter(lvAdapter);

    }
    private void getGridView(){
        gvAdapter = new SimpleAdapter(
                MainActivity.this,lists,
                R.layout.gv_seat_item,
                new String[]{"head","name"},
                new int[]{R.id.iv_head,R.id.tv_name});
        //绑定
        gv_seat.setAdapter(gvAdapter);
    }
    private void getActv(){
        String names[] = {"apple","android","blue","and","car"};
        //如何打一个字的时候匹配
        //xml文件式（设置此控件的属性），代码式
        actvAdapter = new ArrayAdapter(MainActivity.this,R.layout.sp_class_item,names);
        actv.setAdapter(actvAdapter);
    }
    private void getSpinner(){
        //适配器是什么：装配数据到视图上！
        //1.准备数据
        String classes[]= {"java78","java80","java81"};
//        //2.准备数组适配器
//        ArrayAdapter spAdapter = new ArrayAdapter(
//                MainActivity.this,//上下文
//                //android.R.layout.simple_dropdown_item_1line,//xml文件 可以自己写，可用用安卓自带的
//                R.layout.sp_class_item,//自定义的xml
//                classes//数据－数组
//        );
        spAdapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.calsses,R.layout.sp_class_item);
        //3.绑定适配器
        sp_class.setAdapter(spAdapter);
    }
    //进行初始化
    private void initView() {
        actv = (AutoCompleteTextView) findViewById(R.id.actv);
        sp_class = (Spinner) findViewById(R.id.sp_class);
        lv_classinfo = (ListView) findViewById(R.id.lv_classinfo);
        gv_seat = (GridView) findViewById(R.id.gv_seat);
    }
}
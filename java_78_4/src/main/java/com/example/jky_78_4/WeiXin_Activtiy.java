package com.example.jky_78_4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by 乾 on 2017/10/9.
 */

public class WeiXin_Activtiy extends AppCompatActivity {
    SimpleAdapter lvAdapter;
    private GridView lv_info;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activtiy_weixin);
        initView();
        getData();
        getGridView();
    }
    List<Map<String,Object>> lists;
    private void getData() {
        lists = new ArrayList<>();
        int heads[]={R.drawable.gasses,R.drawable.luggage,R.drawable.taxicab,R.drawable.music};
        for (int i = 0; i<20;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("head",heads[i%4]);
            map.put("name","陈乾"+i);
            map.put("jilu","吃饭了吗？");
            lists.add(map);
        }
    }

    private void getGridView(){
      lvAdapter = new SimpleAdapter(
              WeiXin_Activtiy.this,//上下文
                lists,//List<Map<key,value>>
                R.layout.gv_weixin_item,//xml,自定义
                new String[]{"head","name","jilu"},//key
                new int[]{R.id.iv_head,R.id.tv_name,R.id.tv_xinxi}
        );
        lv_info.setAdapter(lvAdapter);

    }
    private void initView() {
        lv_info = (GridView) findViewById(R.id.lv_info);

    }
}

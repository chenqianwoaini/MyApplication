package com.example.myandroid_5_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.myandroid_5_1.adapter.LvClassInfoAdapter;
import com.example.myandroid_5_1.entity.Classinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView lv_info;
    private LvClassInfoAdapter infoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_info = (ListView) findViewById(R.id.lv_info);
        infoAdapter = new LvClassInfoAdapter(getAllClassInfo(), MainActivity.this);
        lv_info.setAdapter(infoAdapter);
        lv_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Classinfo info = (Classinfo) infoAdapter.getItem(position);
                Toast.makeText(MainActivity.this, info.getName() + ":" + info.getPhone(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    private List<Classinfo> getAllClassInfo() {
        List<Classinfo> lists = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            Classinfo info = new Classinfo();
            info.setHead(R.drawable.gasses);
            info.setName("李四" + i);
            info.setPhone("110" + i);
            lists.add(info);
        }
        return lists;
    }
}

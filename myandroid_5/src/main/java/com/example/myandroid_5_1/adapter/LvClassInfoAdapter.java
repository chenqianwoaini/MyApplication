package com.example.myandroid_5_1.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myandroid_5_1.R;
import com.example.myandroid_5_1.entity.Classinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 乾 on 2017/10/10.
 */

public class LvClassInfoAdapter extends BaseAdapter {
    //1.List集合Bean
    private List<Classinfo> classInfoList = new ArrayList<>();
    //2.布局加载器
    LayoutInflater mLayoutInflater;
    Context context;//为67行使用

    public LvClassInfoAdapter(List<Classinfo> classInfoList, Context context) {
        this.classInfoList = classInfoList;//待处理的数
        mLayoutInflater = LayoutInflater.from(context);//加载布局文件用的
        this.context = context;
    }

    //集合的大小
    @Override
    public int getCount() {
        return classInfoList.size();
    }

    //集合每一行数据
    @Override
    public Object getItem(int position) {
        return classInfoList.get(position);
    }

    //集合下标
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1.加载布局文件以便找到控件
        View view = null;
        final ViewHolde mHolder;
        if (convertView == null) {
            //第一次加载
            view = mLayoutInflater.inflate(R.layout.lv_info_item, null);
            mHolder = new ViewHolde();
            mHolder.iv_lv_head = (ImageView) view.findViewById(R.id.iv_lv_head);
            mHolder.tv_lv_name = (TextView) view.findViewById(R.id.tv_lv_name);
            mHolder.tv_lv_phone = (TextView) view.findViewById(R.id.tv_lv_phone);
            mHolder.cb_slect = (CheckBox) view.findViewById(R.id.cb_slect);
            //建立view和mHolder的关联
            view.setTag(mHolder);
        } else {
            view = convertView;
            mHolder = (ViewHolde) view.getTag();
        }
        //2.从集合中取出数据
        final Classinfo classInfo = classInfoList.get(position);
        //3.绑定数据
        mHolder.iv_lv_head.setImageResource(classInfo.getHead());
        mHolder.tv_lv_name.setText(classInfo.getName());
        mHolder.tv_lv_phone.setText(classInfo.getPhone());
        //添加事件监听
//        mHolder.cb_slect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mHolder.cb_slect.isChecked()){
//                   // mHolder.cb_slect.setChecked(true);
//                    //存起来
//                    classInfo.setHasChecked(true);
//                }else {
//                    //mHolder.cb_slect.setChecked(false);
//                    classInfo.setHasChecked(false);
//                }
//            }
//        });
        mHolder.cb_slect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                classInfo.setHasChecked(isChecked);
            }
        });
        //真正处理
        mHolder.cb_slect.setChecked(classInfo.isHasChecked());


        //特色，隔行换色
        if (position % 2 == 0) {
            view.setBackgroundColor(context.getResources().getColor(android.R.color.holo_green_light));
        } else {
            view.setBackgroundColor(Color.WHITE);
        }
        //4.切记
        return view;
    }
    private static class ViewHolde {
        ImageView iv_lv_head;
        TextView tv_lv_name;
        TextView tv_lv_phone;
        CheckBox cb_slect;
    }
}

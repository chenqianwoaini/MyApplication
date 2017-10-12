package com.example.jky_78_5.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jky_78_5.R;
import com.example.jky_78_5.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 乾 on 2017/10/5.
 */

public class StudentAdater extends BaseAdapter {
    private static final java.lang.String TAG = "StudentAdapter";
    //接收数据用的
    private List<Student> lists = new ArrayList<>();
    private Context context;
    LayoutInflater mInflater;

    public StudentAdater(List<Student> lists,Context context) {
        this.lists = lists;
        this.context = context;
        //把布局文件加载进来，需要上下文
        mInflater = LayoutInflater.from(context);
    }

    public void setLists(List<Student> lists) {
        this.lists = lists;
    }

    //得到多少条数据
    @Override
    public int getCount() {
        return lists.size();
    }
    //根据下标找到条目对应的数据
    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }
    //返回条目对应的id，下标
    @Override
    public long getItemId(int position) {
        return position;
    }
    //找到控件，找到数据，将数据装配到控件，并且返回
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        ViewHolder mHolder = null;//声明
        ViewHolderGroup mHolderGroup=null;
        //得到布局的type
        int type = getItemViewType(position);  //数据

        //重用convertView
        if(convertView==null) {
            switch (type){
                case 0:
                    mHolderGroup = new ViewHolderGroup();
                    //加载lv_student_group.xml
                    convertView = mInflater.inflate(R.layout.lv_student_group, null);
                    mHolderGroup.tv_group_name =(TextView)convertView.findViewById(R.id.tv_groupname);
                    convertView.setTag(mHolderGroup);
                    break;
                case 1:
                    //加载lv_student_item.xml
                    Log.i(TAG, "第一次进来=======");
                    mHolder = new ViewHolder();
                    //利用布局加载器加载布局文件
                    convertView = mInflater.inflate(R.layout.lv_student_item, null);
                    //找到控件
                    mHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
                    mHolder.tv_tel = (TextView) convertView.findViewById(R.id.tv_tel);
                    mHolder.iv_head = (ImageView) convertView.findViewById(R.id.iv_head);
                    mHolder.cb_checked = (CheckBox) convertView.findViewById(R.id.cb_checked);
                    //存储  A  mHolder
                    convertView.setTag(mHolder);

                    break;
            }

        }else{
            Log.i(TAG, "重用了=======");
            //重用  B
            switch (type){
                case 0:
                    mHolderGroup = (ViewHolderGroup) convertView.getTag();
                    break;
                case 1:
                    mHolder = (ViewHolder) convertView.getTag();
                    break;
            }

        }
        switch (type){
            case 0:
                Student group = lists.get(position);
                mHolderGroup.tv_group_name.setText(group.name);
                mHolderGroup.tv_group_name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("adapter","=========click");
                    }
                });
                break;
            case 1:
                //准备数据，所有的数据在lists中，此方法中有下标
                final Student student = lists.get(position);
                //解决错乱问题
                mHolder.cb_checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        //改变选中状态
                        student.isChecked=isChecked;
                    }
                });
                //将数据绑定到控件上
                mHolder.tv_name.setText(student.name);
                mHolder.tv_tel.setText(student.tel);
                mHolder.iv_head.setImageResource(student.head);//保留，可行
                mHolder.cb_checked.setChecked(student.isChecked);//新的值哦
                break;
        }


        return convertView;
    }
    //1.写一个静态的内部类（控件）xml
    private static class ViewHolder{
        TextView tv_name;
        TextView tv_tel;
        ImageView iv_head;
        CheckBox cb_checked;
    }
    //
    private static class ViewHolderGroup{
        TextView tv_group_name;
    }
    /**
     * 根据数据源的position返回需要显示的的layout的type
     *
     * type的值必须从0开始
     *
     * */
    @Override
    public int getItemViewType(int position) {
        //获得每个实体对应的type
        return lists.get(position).type;
    }

    /**
     * 返回所有的layout的数量
     *
     * */
    @Override
    public int getViewTypeCount() {
        return 2;
    }

}

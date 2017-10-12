package com.example.myandroid_6;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ListView lv_dialog;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.初始化
        lv_dialog = (ListView) findViewById(R.id.lv_dialog);
        //2.准备数据
        String names[] = {
                "普通对话框"
                , "列表对话框"
                , "单选对话框"
                , "多选对话框"
                , "时间对话框"
                , "日期对话框"
                , "进度条对话框"
                , " 自定义对话框"};
        //3.准备适配器
        adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                names
        );
        //4.绑定
        lv_dialog.setAdapter(adapter);
        //5.事件监听
        lv_dialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        normalDialog();
                        break;
                    case 1:
                        lisetDialog();
                        break;
                    case 2:
                        singDialog();
                        break;
                    case 3:
                        multiDialog();
                        break;
                    case 4:
                        timeDialog();
                        break;
                    case 5:
                        dateDialog();
                        break;
                    case 6:
                        progressDialog();
                        break;
                    case 7:
                        defineDialog();
                        break;

                    default:
                        break;
                }
            }
        });
    }

    //普通对话款
    private void normalDialog() {
        //创建Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        //设置标题
        builder.setTitle("提示");
        //设置提示信息
        builder.setMessage("发现新的版本，是否更新");
        //设置确定按钮
        builder.setPositiveButton("更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //更新操作
                Toast.makeText(MainActivity.this, "正在更新，请稍后。。。。", Toast.LENGTH_SHORT).show();
            }
        });
        //设置取消按钮
        builder.setNegativeButton("下次再说", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();//关掉 dismiss
            }
        });
        //显示
        builder.show();
    }

    //列表对话框
    private void lisetDialog() {
        final String itens[] = {"java", "Net", "Android", "IOS"};
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("选择语言")
                .setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, itens[which], Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    // 单选对话框"
    String whichs = "";

    private void singDialog() {
        final String sex[] = {"男", "女", "保密"};
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("请选择性别")
                .setSingleChoiceItems(sex, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        whichs = sex[which];
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, whichs, Toast.LENGTH_SHORT).show();
            }
        }).show();
    }

    // 多选对话框"

    private void multiDialog() {
        final String items[] = {"牛肉", "鲍鱼", "大龙虾", "燕窝"};
       final boolean checks[] = {true, false, false, false};
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("请选择喜欢吃的")
                .setMultiChoiceItems(items, checks, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                isChecked = checks[which];
                            }
                        }).setPositiveButton("就这些啦", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int size = items.length;
                StringBuffer sb = new StringBuffer();
                for (int i = 0 ; i<size ; i++){
                    if(checks[i]){
                        sb.append(items[i]).append(",");
                    }
                }
                //去掉最后一个逗号
                sb.deleteCharAt(sb.length()-1);
                //
                Toast.makeText(MainActivity.this, sb, Toast.LENGTH_SHORT).show();
            }
        }).show();

    }
    // "时间对话框"
    private void timeDialog() {
        //获得当前系统时间
       Calendar calendar = Calendar.getInstance();
        int  h = calendar.get(Calendar.HOUR);
        int m = calendar.get(Calendar.MINUTE);
           new TimePickerDialog(MainActivity.this
                   , new TimePickerDialog.OnTimeSetListener() {
               @Override
               public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                   Toast.makeText(MainActivity.this, hourOfDay+" ："+minute, Toast.LENGTH_SHORT).show();
               }
           }, h,m, true
           ).show();
    }

    //"日期对话框"
    private void dateDialog() {
        Calendar da = Calendar.getInstance();
       int y = da.get(Calendar.YEAR);
       int m = da.get(Calendar.MONTH);
       int d = da.get(Calendar.DAY_OF_MONTH);
        new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this,year+ "—"+month+"—"+dayOfMonth, Toast.LENGTH_SHORT).show();
            }
        },y,m,d).show();

    }
    // "进度条对话框"
    private void progressDialog() {
        ProgressDialog pd = new ProgressDialog(MainActivity.this);
        pd.setTitle("正在加载......");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMax(100);
        pd.setButton("取消加载", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        pd.show();
        pd.setProgress(50);
    }

    // " 自定义对话框"
    private void defineDialog() {
        final View view = View.inflate(MainActivity.this,R.layout.login,null);
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("登陆")
                .setView(view)
                .setPositiveButton("登陆", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            //获取用户名与密码
                        String name = ((EditText)view.findViewById(R.id.et_name)).getText()+"";
                        String password = ((EditText)view.findViewById(R.id.et_password)).getText()+"";
                        Toast.makeText(MainActivity.this, name+"----"+password, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}

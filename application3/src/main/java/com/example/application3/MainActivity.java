package com.example.application3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox cb_accept;
    private Button bt_re;
    private RadioGroup rg_sex;
    private CheckBox cb_yun, cb_java, cb_m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.reglister_layout);
        initView();
        listener();

    }

    private void listener() {
        //复选框勾选的时间监听
        cb_accept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Toast.makeText(MainActivity.this, isChecked+"", Toast.LENGTH_SHORT).show();
                bt_re.setEnabled(isChecked);
            }
        });
        bt_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得性别
                String sex = null;
                //获取按钮组备选按钮的id
                int id = rg_sex.getCheckedRadioButtonId();
                RadioButton rd = (RadioButton) findViewById(id);
                sex = (String) rd.getText();
                Toast.makeText(MainActivity.this, sex, Toast.LENGTH_SHORT).show();
                //获取兴趣爱好
                StringBuffer hobby = new StringBuffer();
                if (cb_yun.isChecked()) {
                    hobby.append(cb_yun.getText().toString());
                    hobby.append(",");
                }
                if (cb_java.isChecked()) {
                    hobby.append(cb_java.getText().toString());
                    hobby.append(",");
                }
                if (cb_m.isChecked()) {
                    hobby.append(cb_m.getText().toString());
                    hobby.append(",");
                }
                hobby.deleteCharAt(hobby.length() - 1);
                Toast.makeText(MainActivity.this, hobby.toString(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void initView() {
        cb_accept = (CheckBox) findViewById(R.id.cb_accrpt);
        bt_re = (Button) findViewById(R.id.bt_re);
        rg_sex = (RadioGroup) findViewById(R.id.rg_sex);
        cb_yun = (CheckBox) findViewById(R.id.cb_yun);
        cb_java = (CheckBox) findViewById(R.id.cb_java);
        cb_m = (CheckBox) findViewById(R.id.cb_m);
    }
}

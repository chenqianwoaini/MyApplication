package com.example.myapplication;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 乾 on 2017/9/28.
 */

public class MyActivity extends Activity implements View.OnClickListener {
    //初始化
    private EditText et_username;
    private EditText et_password;
    private Button bt_login;
    private Button bt_exit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        //找空间
        initView();
        //注册监听
        listener();

    }

    private void listener() {
        bt_login.setOnClickListener(this);
        bt_exit.setOnClickListener(this);
    }

    private void initView() {
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_exit = (Button) findViewById(R.id.bt_exit);
    }

    @Override
    public void onClick(View v) {
        //怎么区分点了那个按钮
        int id = v.getId();
        switch (id) {
            case R.id.bt_login:
                //得到用户名和密码
                Editable username = et_username.getText();
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                }
                Editable password = et_password.getText();
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
                if ("root".equals(username.toString())&&"52java".equals(password.toString())){
                    Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_exit:
                finish();
                break;
        }

    }
}

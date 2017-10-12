package com.example.myandroid_5_life;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity","onCreate=====");
    }
    public  void steartOther(View view){
       // Toast.makeText(this, "1111", Toast.LENGTH_SHORT).show();
        //1.创建意图
        Intent intent = new Intent(MainActivity.this,OtherActivity.class);
        //2.启动意图
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity","onStart=====");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity","onResume=====");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity","onPause=====");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity","onStop=====");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy=====");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity","onRestart=====");
    }
}

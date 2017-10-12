package com.example.jky_78_5.tools;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 乾 on 2017/10/5.
 */

public class Tools {
    public static void myToast(Context context, String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}



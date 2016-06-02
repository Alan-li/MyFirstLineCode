package com.android.alan.broadcastreceiverpratice.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.alan.broadcastreceiverpratice.ActivityCollector;

/**
 * Created by Administrator on 13/4/2016.
 */
public class BaseActivity extends AppCompatActivity {

    public static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "----ActivityName = " + getClass().getSimpleName()); // 根据程序当前的界面就能判断出这是哪一个活动
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}

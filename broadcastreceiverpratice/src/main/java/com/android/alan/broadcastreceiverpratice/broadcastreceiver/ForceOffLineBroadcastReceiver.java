package com.android.alan.broadcastreceiverpratice.broadcastreceiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.WindowManager;

import com.android.alan.broadcastreceiverpratice.ActivityCollector;
import com.android.alan.broadcastreceiverpratice.MainActivity;
import com.android.alan.broadcastreceiverpratice.activity.LoginActivity;

/**
 * 强制用户下线的广播
 * Created by Administrator on 2/6/2016.
 */
public class ForceOffLineBroadcastReceiver extends BroadcastReceiver {

    public static final String TAG = "ForceOffLine";

    @Override
    public void onReceive(final Context context, final Intent intent) {

        Log.d(TAG, "received broadcast");

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("Warning"); // 设置标题

        builder.setMessage("You are forced to be offline , Please try login again."); // 设置内容

        builder.setCancelable(false); // 不能点击返回键取消

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishAll(); // 销毁所有活动

                Intent loginIntent = new Intent(context, LoginActivity.class);
                loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// 在广播接收器中启动活动，要给Intent加入FLAG_ACTIVITY_NEW_TASK
                context.startActivity(loginIntent);

            }
        });

        AlertDialog alertDialog = builder.create();
        // 需要设置AlertDialog的类型，保证在广播接收器中可以正常弹出
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

        alertDialog.show();

    }
}

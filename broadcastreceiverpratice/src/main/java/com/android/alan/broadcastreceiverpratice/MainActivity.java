package com.android.alan.broadcastreceiverpratice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 广播最佳实践（实现强制下线）
 */
public class MainActivity extends AppCompatActivity {

    private Button btn_force_off_line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_force_off_line = (Button) findViewById(R.id.forceOffLine);

        btn_force_off_line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 发送广播，强制下线
                Intent intent = new Intent("com.example.alan.FORCE_OFFLINE");

                sendBroadcast(intent);
            }
        });
    }
}

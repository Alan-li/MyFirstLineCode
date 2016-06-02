package com.android.alan.broadcastreceiverpratice.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.alan.broadcastreceiverpratice.MainActivity;
import com.android.alan.broadcastreceiverpratice.R;
import com.android.alan.broadcastreceiverpratice.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    private EditText et_account;
    private EditText et_password;

    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_account = (EditText) findViewById(R.id.account);
        et_password = (EditText) findViewById(R.id.password);

        btn_login = (Button) findViewById(R.id.login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = et_account.getText().toString();
                String password = et_password.getText().toString();
                if (account.equals("admin") && password.equals("123456")) {
                    // 登陆成功
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(LoginActivity.this, "account or password is invaild" , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

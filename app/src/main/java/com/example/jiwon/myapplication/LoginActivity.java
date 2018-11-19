package com.example.jiwon.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

import org.w3c.dom.Text;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {
    private Context mContext;
    private LoginButton btn_facebook_login;
    private Button btn_custom_login_fb;
    private LoginCallback mLoginCallback;
    private CallbackManager mCallbackManager;

    private Context mContext_kakao;
    private Button btn_custom_login;
    private com.kakao.usermgmt.LoginButton btn_kakao_login;
    Intent mapIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mapIntent = new Intent(this, PhotoActivity.class);
        startActivity(mapIntent);
        mContext = getApplicationContext();
        mCallbackManager = CallbackManager.Factory.create();
        mLoginCallback = new LoginCallback();

        btn_facebook_login = (LoginButton) findViewById(R.id.btn_facebook_login);
        btn_facebook_login.setReadPermissions(Arrays.asList("public_profile", "email"));
        btn_facebook_login.registerCallback(mCallbackManager, mLoginCallback);

        btn_custom_login_fb = (Button) findViewById(R.id.btn_custom_login_fb);
        btn_custom_login_fb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                btn_facebook_login.performClick();
            }
        });


        mContext_kakao = getApplicationContext();
        btn_custom_login = (Button) findViewById(R.id.btn_custom_login);
        btn_custom_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                btn_kakao_login.performClick();
            }
        });

        btn_kakao_login = (com.kakao.usermgmt.LoginButton) findViewById(R.id.btn_kakao_login);

        EditText idText = (EditText)findViewById(R.id.idText);
        EditText passwordText = (EditText)findViewById(R.id.passwordText);
        Button loginButton = (Button)findViewById(R.id.loginButton);
        TextView registerButton = (TextView)findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}

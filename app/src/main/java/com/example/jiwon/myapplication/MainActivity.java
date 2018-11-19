package com.example.jiwon.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button button_photo=(Button)findViewById(R.id.main_photo);
        Button button_recommend = (Button)findViewById(R.id.main_recommed) ;
        Button button_history = (Button)findViewById(R.id.main_history);

        button_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        button_recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RecommendActivity.class);
                startActivity(intent);
            }
        });

        button_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}

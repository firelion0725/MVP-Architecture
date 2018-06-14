package com.leo.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.leo.test.business.task.TaskActivity;
import com.leo.test.business.user.UserActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, UserActivity.class));
//        startActivity(new Intent(this, TaskActivity.class));
    }
}

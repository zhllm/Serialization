package com.beyourself.serialization;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.beyourself.serialization.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication application = (MyApplication) getApplication();
        // application.student;
        ActivityMain2Binding binding = DataBindingUtil.setContentView(
                 this, R.layout.activity_main2);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        Teacher student = bundle.getParcelable("teacher");
        // 如果刚跳转到这个界面，而且没有错误输出，先检查下传递Parcelable数据是否全部被wirte
        binding.name.setText(student.getName());
        binding.age.setText(String.valueOf(student.getAge()));
        binding.math.setText(String.valueOf(student.getScores().getMath()));
        binding.english.setText(String.valueOf(student.getScores().getEnglish()));
    }
}
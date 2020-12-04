package com.beyourself.serialization;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.beyourself.serialization.databinding.ActivityParcelMainBinding;

public class ParcelMainActivity extends AppCompatActivity {
    private static String FILE_NAME = "student.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcel_main);
        ActivityParcelMainBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_parcel_main);
        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.name.getText().toString();
                int age = Integer.parseInt(binding.age.getText().toString());
                int math = Integer.parseInt(binding.math.getText().toString());
                int english = Integer.parseInt(binding.english.getText().toString());

                Teacher teacher = new Teacher(
                        name, age, new Scores(math, english)
                );

                Intent intent = new Intent(ParcelMainActivity.this,
                        MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("teacher", teacher);
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });
    }
}
package com.beyourself.serialization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextAge, editTextMath, editTextEnglish, editTextChinese;
    Button buttonSave, buttonLoad;
    TextView textViewGrade;
    private static String FILE_NAME = "student.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAge = findViewById(R.id.age);
        editTextChinese = findViewById(R.id.chinese);
        editTextEnglish = findViewById(R.id.english);
        editTextMath = findViewById(R.id.math);
        editTextName = findViewById(R.id.name);
        textViewGrade = findViewById(R.id.grade);
        buttonLoad = findViewById(R.id.load);
        buttonSave = findViewById(R.id.save);


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int math = Integer.parseInt(editTextMath.getText().toString());
                int english = Integer.parseInt(editTextEnglish.getText().toString());
                int chinese = Integer.parseInt(editTextChinese.getText().toString());
                Score score = new Score(math, english, chinese);
                String name = editTextName.getText().toString();
                int age = Integer.parseInt(editTextAge.getText().toString());
                Student student = new Student(name, age, score);

                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream(
                        openFileOutput(FILE_NAME, MODE_PRIVATE)
                    );
                } catch (IOException e) {
                    Log.d("MyTag", e.getMessage());
                }
            }
        });
    }
}
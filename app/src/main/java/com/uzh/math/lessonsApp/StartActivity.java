package com.uzh.math.lessonsApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.uzh.math.lessonsApp.lesson_1.L1_MainActivity;
import com.uzh.math.lessonsApp.lesson_2.L2_MainActivity;

public class StartActivity extends AppCompatActivity {

    CardView cv_lesson_1;
    CardView cv_lesson_2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        cv_lesson_1 = findViewById(R.id.cv_lesson_1);
        cv_lesson_2 = findViewById(R.id.cv_lesson_2);

        cv_lesson_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, L1_MainActivity.class));
            }
        });

        cv_lesson_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, L2_MainActivity.class));
            }
        });
    }
}

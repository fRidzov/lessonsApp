package com.uzh.math.lessonsApp.lesson_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.uzh.math.lessonsApp.R;

public class SecondActivity extends AppCompatActivity {

    TextView tv_value;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO задаємо макет нашому актівіті  (верстку)
        setContentView(R.layout.l2_second_activity);
        //TODO знаходимо компонент
        tv_value = findViewById(R.id.tv_value);
        //TODO витягуємо значення яке передали на попередньому актівіті за домопогою getIntent().getStringExtra(). з відповідним ключем
        tv_value.setText(getIntent().getStringExtra("key"));
    }
}

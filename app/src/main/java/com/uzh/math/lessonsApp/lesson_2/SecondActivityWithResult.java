package com.uzh.math.lessonsApp.lesson_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uzh.math.lessonsApp.R;

public class SecondActivityWithResult extends AppCompatActivity {

    EditText et_input_result;
    Button btn_result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO задаємо макет нашому актівіті  (верстку)
        setContentView(R.layout.l2_second_activity_for_result);
        //TODO знаходимо компоненти
        et_input_result = findViewById(R.id.et_input_result);
        btn_result = findViewById(R.id.btn_result);

        //TODO витягуємо значення яке передали на попередньому актівіті за домопогою getIntent().getStringExtra(). з відповідним ключем
        et_input_result.setText(getIntent().getStringExtra("key"));

        //TODO Ставимо обробник натискання на кнопку
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Перевіряємо чи ми ввели текст, якщо ні то показуємо Toast що треба ввести число
                if (et_input_result.getText().toString().isEmpty()) {
                    Toast.makeText(SecondActivityWithResult.this, "Введіть дані", Toast.LENGTH_LONG).show();
                } else {
                    //TODO створюємо intent для передачі на попереднє актівіті
                    Intent intent = new Intent();
                    //TODO записуємо по нашому ключю значення яке хочемо передати
                    intent.putExtra("key", et_input_result.getText().toString());
                    //TODO setResult для передачі даних назад RESULT_OK-сигналізує те що все пройшло корекнто
                    //TODO intent дані які передаємо
                    setResult(RESULT_OK, intent);
                    //TODO закриважмо поточне актівіті
                    finish();
                }
            }
        });

    }
}

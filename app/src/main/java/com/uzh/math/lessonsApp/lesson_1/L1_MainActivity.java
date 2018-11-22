package com.uzh.math.lessonsApp.lesson_1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uzh.math.lessonsApp.R;

public class L1_MainActivity extends AppCompatActivity {

    EditText et_input;
    Button btn_minus;
    Button btn_plus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l1_main_activity);

        //TODO Знаходимо наші елементи з макету l1_main_activity
        et_input = findViewById(R.id.et_input);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);

        //TODO Ставимо оброник на натискання кнопки (Обробник - те що має виконатися коли кнопки натиснута)
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Перевіряємо чи ми ввели текст, якщо ні то показуємо Toast що треба ввести число
                if (et_input.getText().toString().isEmpty()) {
                    Toast.makeText(L1_MainActivity.this, "Введіть число", Toast.LENGTH_LONG).show();
                } else {
                    //TODO Якщо текст введено то зчитуємо текст з поля вводу, віднімаємо 1 і записуємо текст новий текст у поле вводу
                    int number = Integer.valueOf(et_input.getText().toString());
                    number--;
                    et_input.setText(String.valueOf(number));
                }
            }
        });

        //TODO Ставимо оброник на натискання кнопки (Обробник - те що має виконатися коли кнопки натиснута)
        //TODO Проводимо аналогічну операцію з кнопкою, перевіркою тексту, виводом тексту тільки додаємо число а не віднімаємо
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_input.getText().toString().isEmpty()) {
                    Toast.makeText(L1_MainActivity.this, "Введіть число", Toast.LENGTH_LONG).show();
                } else {
                    int number = Integer.valueOf(et_input.getText().toString());
                    number++;
                    et_input.setText(String.valueOf(number));
                }
            }
        });
    }
}

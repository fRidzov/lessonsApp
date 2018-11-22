package com.uzh.math.lessonsApp.lesson_2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uzh.math.lessonsApp.R;

public class L2_MainActivity extends AppCompatActivity {

    EditText et_input_start_activity;
    Button btn_start_activity;

    EditText et_input_start_activity_for_result;
    Button btn_start_activity_for_result;

    Button btn_call;
    Button btn_map;
    Button btn_site;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l2_main_activity);

        //TODO Знаходимо наші коемпоненти  xml файлу
        et_input_start_activity = findViewById(R.id.et_input_start_activity);
        btn_start_activity = findViewById(R.id.btn_start_activity);
        et_input_start_activity_for_result = findViewById(R.id.et_input_start_activity_for_result);
        btn_start_activity_for_result = findViewById(R.id.btn_start_activity_for_result);
        btn_call = findViewById(R.id.btn_call);
        btn_map = findViewById(R.id.btn_map);
        btn_site = findViewById(R.id.btn_site);


        //TODO Ставимо обробник натискання на кнопку
        btn_start_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Перевіряємо чи ми ввели текст, якщо ні то показуємо Toast що треба ввести число
                if (et_input_start_activity.getText().toString().isEmpty()) {
                    Toast.makeText(L2_MainActivity.this, "Введіть дані", Toast.LENGTH_LONG).show();
                } else {
                    //TODO інакше створюємо intent для запуску другого актівіті
                    Intent intent = new Intent(L2_MainActivity.this, SecondActivity.class);
                    //TODO записуємо текст введений у поле вводу в інтент за допомогою ключа "key" (може бути будь яка стрінга)
                    intent.putExtra("key", et_input_start_activity.getText().toString());
                    //TODO запускаємо актівіті за допомогою метода передаючи йому intent
                    startActivity(intent);
                }
            }
        });

        //TODO Ставимо обробник натискання на кнопку
        btn_start_activity_for_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Перевіряємо чи ми ввели текст, якщо ні то показуємо Toast що треба ввести число
                if (et_input_start_activity_for_result.getText().toString().isEmpty()) {
                    Toast.makeText(L2_MainActivity.this, "Введіть дані", Toast.LENGTH_LONG).show();
                } else {
                    //TODO інакше створюємо intent для запуску другого актівіті "SecondActivityWithResult"
                    Intent intent = new Intent(L2_MainActivity.this, SecondActivityWithResult.class);
                    //TODO записуємо текст введений у поле вводу в інтент за допомогою ключа "key" (може бути будь яка стрінга)
                    intent.putExtra("key", et_input_start_activity_for_result.getText().toString());
                    //TODO запускаємо актівіті за допомогою метода передаючи йому intent і "requestCode" за яким у методі "onActivityResult" зможемо ідентифікувати саме цей запуск
                    startActivityForResult(intent, 101);
                }
            }
        });

        //TODO Ставимо обробник натискання на кнопку
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:466"));
                startActivity(intent);
            }
        });

        //TODO Ставимо обробник натискання на кнопку
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:466"));
                startActivity(intent);
            }
        });

        //TODO Ставимо обробник натискання на кнопку
        btn_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
                startActivity(intent);
            }
        });
    }


    //TODO цей метод потрібен для того щоб ловити результат після обробки актівіті яке ми запускаємо. у даному прикладі при натисканні на кнопку btn_start_activity_for_result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //TODO requestCode при поверненні повинен співпадати з requestCode коли запускали нове актівіті (може бути декілька різних таких запусків і цим ми можемо їх рохрізняти)
        //TODO resultCode повитет бути такий який ви ставите при виході із запускаючого еркана (зазвичай це Activity.RESULT_OK при успішній обробці або Activity.RESULT_CANCELED при скасуванні або помилці)
        if (requestCode == 101 && resultCode == Activity.RESULT_OK) {
            if (data != null)
                //TODO показуємо повідомлення тексту яке відправлено з попереднього актівіті
                Toast.makeText(this, data.getStringExtra("key"), Toast.LENGTH_LONG).show();
        }
    }
}

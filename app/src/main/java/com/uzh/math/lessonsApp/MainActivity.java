package com.uzh.math.lessonsApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String LOG_TAG = "TAG";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Log.d(LOG_TAG, "activity started");
        Button startSecond = findViewById(R.id.first_btn);
        startSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "button pressed");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("stringValue", "test");
                startActivityForResult(intent, 101);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK) {
            Log.d(LOG_TAG, "on activity result");
            Toast.makeText(this, data.getStringExtra("stringValue"), Toast.LENGTH_LONG)
                    .show();
        }
    }
}

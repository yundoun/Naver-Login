package com.example.myfirstapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    String[] items = {"한국어", "english", "中文"}; // 스피너 아이템

    public int convertDpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        spinner.setAdapter(adapter);

        spinner.setSelection(0); // 기본값 한국어

        EditText username = (EditText) findViewById(R.id.username);
        Drawable idIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.id_icon);
        int idIconSize = convertDpToPx(20); // 예를 들어, 아이콘을 20dp 크기로 설정
        idIcon.setBounds(0, 0, idIconSize, idIconSize);
        username.setCompoundDrawables(idIcon, null, null, null);

        EditText password = (EditText) findViewById(R.id.password);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.password_icon);
        int passwordIconSize = convertDpToPx(20); // 예를 들어, 아이콘을 20dp 크기로 설정
        drawable.setBounds(0, 0, passwordIconSize, passwordIconSize);
        password.setCompoundDrawables(drawable, null, null, null);


    }
}
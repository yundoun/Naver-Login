package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    String[] items = {"한국어", "english", "中文"}; // 스피너 아이템
    TextView signUpTextView;
    EditText username;
    EditText password;
    Spinner spinner;
    Drawable idIcon;
    Drawable drawable;
    public int convertDpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUpTextView = (TextView) findViewById(R.id.signUp);
        username = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        spinner = findViewById(R.id.spinner);
        idIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.id_icon);
        drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.password_icon);


        // 스피너 아이템 추가
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        spinner.setAdapter(adapter);
        spinner.setSelection(0); // 기본값 한국어

        // 로그인 아이콘 사이즈
        int idIconSize = convertDpToPx(20); // 예를 들어, 아이콘을 20dp 크기로 설정
        idIcon.setBounds(0, 0, idIconSize, idIconSize);
        username.setCompoundDrawables(idIcon, null, null, null);

        // 비밀번호 아이콘 사이즈
        int passwordIconSize = convertDpToPx(20); // 예를 들어, 아이콘을 20dp 크기로 설정
        drawable.setBounds(0, 0, passwordIconSize, passwordIconSize);
        password.setCompoundDrawables(drawable, null, null, null);

        // 회원가입 창 전환
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
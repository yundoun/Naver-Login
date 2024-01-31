package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class MainActivity extends IconBaseActivity {
    String[] items = {"한국어", "english", "中文"}; // 스피너 아이템
    TextView signUpTextView;
    Spinner spinner;
    EditText userName, password;
    Drawable idIcon, passwordIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUpTextView = (TextView) findViewById(R.id.signUp);
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        spinner = findViewById(R.id.spinner);
        idIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_id);
        passwordIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_password);

        // 로그인 아이콘
        setIconSize(userName, idIcon,20);
        // 비밀번호 아이콘 사이즈
        setIconSize(password,passwordIcon,20);

        // 스피너 아이템 추가
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        spinner.setAdapter(adapter);
        spinner.setSelection(0); // 기본값 한국어


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
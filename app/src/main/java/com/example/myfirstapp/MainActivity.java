package com.example.myfirstapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class MainActivity extends IconBaseActivity {
    String[] items = {"한국어", "english", "中文"}; // 스피너 아이템
    TextView signUpTextView, tvLoginState;
    Spinner spinner;
    EditText userName, password;
    Drawable idIcon, passwordIcon;
    CheckBox cbLoginState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        initializeIcons();
        setAdapter();
        setCheckbox();
        startSignUpActivity();
    }

    private void initializeViews() {
        signUpTextView = findViewById(R.id.tvSignUp);
        userName = findViewById(R.id.etUserNameInMain);
        password = findViewById(R.id.etPasswordInMain);
        spinner = findViewById(R.id.spLanguage);
        cbLoginState = findViewById(R.id.cbLonginState);
        tvLoginState = findViewById(R.id.tvLoginState);
    }

    private void initializeIcons() {
        idIcon = ContextCompat.getDrawable(this, R.drawable.a_id);
        passwordIcon = ContextCompat.getDrawable(this, R.drawable.a_password);
        setIconSize(userName, idIcon, 20);
        setIconSize(password, passwordIcon, 20);
    }

    private void setAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0); // 기본값 한국어

    }

    private void setCheckbox() {
        tvLoginState.setOnClickListener(view -> {
            cbLoginState.setChecked(!cbLoginState.isChecked());
        });
    }

    private void startSignUpActivity() {
        signUpTextView.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }
}

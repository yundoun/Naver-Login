package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class SignUpActivity extends AppCompatActivity  {
    EditText etAgency;
    Spinner spinnerOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etAgency = findViewById(R.id.et_agency);
        spinnerOptions = findViewById(R.id.spinnerOptions);

        etAgency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerOptions.performClick();
            }
        });

    }
}
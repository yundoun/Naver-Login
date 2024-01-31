package com.example.myfirstapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.core.content.ContextCompat;


public class SignUpActivity extends IconBaseActivity {
    EditText etAgency;
    Spinner spinnerOptions;

    EditText agency;
    EditText id, password, email, userName, birth, phone;
    Drawable idIcon, passwordIcon, emailIcon, userNameIcon, birthIcon, agencyIcon, phoneIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        id = (EditText) findViewById(R.id.et_userId);
        password = (EditText) findViewById(R.id.et_password);
        email = (EditText) findViewById(R.id.et_email);
        userName = (EditText) findViewById(R.id.et_userName);
        birth = (EditText) findViewById(R.id.et_userBirth);
        agency = (EditText) findViewById(R.id.et_agency);
        phone = (EditText) findViewById(R.id.et_phone);


        idIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_id);
        passwordIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_password);
        emailIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_email);
        userNameIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_id);
        birthIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_birth);
        agencyIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_agency);
        phoneIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_phone);


        setIconSize(id, idIcon, 20);
        setIconSize(password, passwordIcon, 20);
        setIconSize(email, emailIcon, 20);
        setIconSize(userName, userNameIcon, 20);
        setIconSize(birth, birthIcon, 20);
        setIconSize(agency, agencyIcon, 20);
        setIconSize(phone, phoneIcon, 20);


    }
}
package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SignUpActivity extends IconBaseActivity {

    EditText id, password, email, userName, birth, phone;
    Drawable idIcon, passwordIcon, emailIcon, userNameIcon, birthIcon, agencyIcon, phoneIcon;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        id = (EditText) findViewById(R.id.et_userId);
        password = (EditText) findViewById(R.id.et_password);
        email = (EditText) findViewById(R.id.et_email);
        userName = (EditText) findViewById(R.id.et_userName);
        birth = (EditText) findViewById(R.id.et_userBirth);
        phone = (EditText) findViewById(R.id.et_phone);

        idIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_id);
        passwordIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_password);
        emailIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_email);
        userNameIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_id);
        birthIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_birth);
        phoneIcon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a_phone);


        setIconSize(id, idIcon, 20);
        setIconSize(password, passwordIcon, 20);
        setIconSize(email, emailIcon, 20);
        setIconSize(userName, userNameIcon, 20);
        setIconSize(birth, birthIcon, 20);
        setIconSize(phone, phoneIcon, 20);

        Spinner spinner = (Spinner) findViewById(R.id.sp_agency);
        List<CharSequence> items = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.agency_items)));
        items.add("통신사 선택"); // 리스트의 마지막에 "통신사 선택" 추가

        System.out.println(items);

        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // 스피너 초기 선택을 "통신사 선택"으로 설정
        spinner.setSelection(adapter.getCount());

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position < adapter.getCount()) {
                    adapter.setSelectedPosition(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                adapter.setSelectedPosition(-1);
            }
        });





    }
}
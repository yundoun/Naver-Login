package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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


        TextView spinnerReplacement = findViewById(R.id.tv_agency);

        List<CharSequence> items = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.agency_items)));
        items.add("통신사 선택");

        // GridView를 설정하고 어댑터를 붙입니다.
        GridView gridView = new GridView(this);
        gridView.setNumColumns(2); // 2열로 설정

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, R.layout.sign_up_custom_grid, R.id.text, items) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                // 추가 조건
                return view;
            }
        };

        // 마지막 아이템인 "통신사 선택"을 제외하고 어댑터를 설정합니다.
        items.remove(items.size() - 1); // 마지막 아이템 제거
        gridView.setAdapter(adapter);

        // PopupWindow 준비
        PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setContentView(gridView);
        popupWindow.setWidth(550);
        popupWindow.setHeight(200);
        popupWindow.setFocusable(true); // 팝업 외부 클릭시 닫히게 설정
        popupWindow.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.sign_up_popup_background));

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            CharSequence selectedItem = adapter.getItem(position);
            spinnerReplacement.setText(selectedItem); // TextView를 선택된 아이템의 텍스트로 업데이트
            popupWindow.dismiss(); // 팝업 닫기
        });

        // TextView 클릭 시 PopupWindow 표시
        spinnerReplacement.setOnClickListener(v -> popupWindow.showAsDropDown(spinnerReplacement));


    }
}
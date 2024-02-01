package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
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
    Drawable idIcon, passwordIcon, emailIcon, userNameIcon, birthIcon, phoneIcon;
    TextView tvRealName, tv_agency;
    CheckBox cbRealName;
    View agencyLayout;

    ArrayAdapter<CharSequence> adapter;
    PopupWindow popupWindow;
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
        tv_agency = findViewById(R.id.tv_agency);
        tvRealName = findViewById(R.id.tv_realName);
        cbRealName = findViewById(R.id.cb_realName) ;
        agencyLayout = findViewById(R.id.agencyLayout);

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

        tvRealName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 체크박스의 현재 체크 상태를 반전시킵니다.
                cbRealName.setChecked(!cbRealName.isChecked());
            }
        });


        List<CharSequence> items = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.agency_items)));

        // GridView를 설정하고 어댑터를 붙입니다.
        GridView gridView = new GridView(this);
        gridView.setNumColumns(2); // 2열로 설정

       adapter = new ArrayAdapter<CharSequence>(this, R.layout.sign_up_custom_grid, R.id.text, items) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView = view.findViewById(R.id.text);

                // 아이템 클릭 시 텍스트 색상을 검정색으로 변경합니다.
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView.setTextColor(Color.BLACK); // 검정색으로 변경
                        CharSequence selectedItem = adapter.getItem(position);
                        tv_agency.setText(selectedItem); // TextView를 선택된 아이템의 텍스트로 업데이트
                        popupWindow.dismiss(); // 팝업 닫기
                    }
                });


                return view;
            }
        };

        gridView.setAdapter(adapter);

        // PopupWindow 준비
        popupWindow = new PopupWindow(this);
        popupWindow.setContentView(gridView);
        popupWindow.setWidth(550);
        popupWindow.setHeight(200);
        popupWindow.setFocusable(true); // 팝업 외부 클릭시 닫히게 설정
        popupWindow.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.sign_up_popup_background));

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            CharSequence selectedItem = adapter.getItem(position);
            tv_agency.setText(selectedItem); // TextView를 선택된 아이템의 텍스트로 업데이트
            popupWindow.dismiss(); // 팝업 닫기
        });

        // TextView 클릭 시 PopupWindow 표시
        tv_agency.setOnClickListener(v -> popupWindow.showAsDropDown(tv_agency));

        cbRealName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // 체크박스가 선택된 경우
                    agencyLayout.setVisibility(View.VISIBLE);
                } else {
                    // 체크박스가 선택되지 않은 경우
                    agencyLayout.setVisibility(View.GONE);
                }
            }
        });

    }
}
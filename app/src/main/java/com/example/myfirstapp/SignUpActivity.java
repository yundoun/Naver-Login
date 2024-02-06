package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignUpActivity extends IconBaseActivity {

    private EditText id, password, email, userName, birth, phone;
    private Drawable idIcon, passwordIcon, emailIcon, userNameIcon, birthIcon, phoneIcon;
    private TextView tvRealName, tvAgency;
    private CheckBox cbRealName;
    private View agencyLayout, countryNumberLayout;
    private ArrayAdapter<CharSequence> agencyAdapter;
    private ArrayAdapter<String> countryAdapter;
    private PopupWindow popupWindow;
    private Spinner countrySpinner;
    private String[] countries;

    @SuppressLint("MissingInflatedId") // android:id 에러 무시
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initializeViews();
        initializeIcons();
        setupViewListeners();
        setupAdapters();

        // 초기 가시성 설정
        updateViewVisibility(cbRealName.isChecked());

    }

    private void initializeViews() { // 뷰 초기화 메소드 분리 1
        id = findViewById(R.id.etUserId);
        password = findViewById(R.id.etPasswordInSignUp);
        email = findViewById(R.id.etEmail);
        userName = findViewById(R.id.etUserNameInSignUp);
        birth = findViewById(R.id.etUserBirth);
        phone = findViewById(R.id.etPhone);
        tvAgency = findViewById(R.id.tvAgency);
        tvRealName = findViewById(R.id.tvRealName);
        cbRealName = findViewById(R.id.cbRealName);
        agencyLayout = findViewById(R.id.agencyLayout);
        countryNumberLayout = findViewById(R.id.countryNumberLayout);
        countrySpinner = findViewById(R.id.countryNumberSpinner);
    }

    private void initializeIcons() { // 뷰 초기화 메소드 분리 2
        //액티비티의 컨텍스트가 이미 Context.Compat.getDrawable 함수에 적합하기 때문에 this 사용
        idIcon = ContextCompat.getDrawable(this, R.drawable.a_id);
        passwordIcon = ContextCompat.getDrawable(this, R.drawable.a_password);
        emailIcon = ContextCompat.getDrawable(this, R.drawable.a_email);
        userNameIcon = ContextCompat.getDrawable(this, R.drawable.a_id);
        birthIcon = ContextCompat.getDrawable(this, R.drawable.a_birth);
        phoneIcon = ContextCompat.getDrawable(this, R.drawable.a_phone);

        setIconSize(id, idIcon, 20);
        setIconSize(password, passwordIcon, 20);
        setIconSize(email, emailIcon, 20);
        setIconSize(userName, userNameIcon, 20);
        setIconSize(birth, birthIcon, 20);
        setIconSize(phone, phoneIcon, 20);
    }

    private void setupViewListeners() { // 뷰 리스너 설정
        // buttonView는 체크 상태 변경 이벤트가 발생한 CheckBox의 인스턴스를 나타낸다. 이 경우 리스너가 등록된 View 객체, 즉 CheckBox를 참조
        cbRealName.setOnCheckedChangeListener((buttonView, isChecked) -> updateViewVisibility(isChecked));
        tvRealName.setOnClickListener(v -> cbRealName.setChecked(!cbRealName.isChecked())); // 텍스트뷰 클릭 리스너 : 체크박스 상태 반전
        tvAgency.setOnClickListener(v -> popupWindow.showAsDropDown(tvAgency)); // 팝업 윈도우 표시
    }

    private void setupAdapters() { // 어댑터 설정
        // 어댑터 초기화
        List<CharSequence> agencyItems = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.agency_items)));
        agencyAdapter = new ArrayAdapter<>(this, R.layout.sign_up_custom_grid, R.id.text, agencyItems);
        // GridView 설정 및 초기화
        setupGridView(agencyAdapter);

        // 국가 번호 가져오기
        countries = getResources().getStringArray(R.array.countries_array);
        countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(countryAdapter);
    }

    private void setupGridView(ArrayAdapter<CharSequence> adapter) { // GiredView 설정 및 PopupWindow 초기화
        GridView gridView = new GridView(this);
        gridView.setNumColumns(2);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            CharSequence selectedItem = adapter.getItem(position);
            tvAgency.setText(selectedItem);
            popupWindow.dismiss();
        });

        // PopupWindow 붙이기
        popupWindow = new PopupWindow(gridView, 550, 200, true);
        popupWindow.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.sign_up_popup_background));
    }

    // 뷰 가시성 업데이트 ( 실명 인증 체크박스 상태에 따라 바뀜 )
    private void updateViewVisibility(boolean isChecked) {
        agencyLayout.setVisibility(isChecked ? View.VISIBLE : View.GONE);
        countryNumberLayout.setVisibility(isChecked ? View.GONE : View.VISIBLE);
    }

}

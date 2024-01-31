package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.EditText;

public class IconBaseActivity extends AppCompatActivity {
    protected void setIconSize(EditText editText, Drawable icon, int dpSize) {
        int iconSize = convertDpToPx(dpSize);
        icon.setBounds(0, 0, iconSize, iconSize);
        editText.setCompoundDrawables(icon, null, null, null);
    }
    private int convertDpToPx(int dp) {
        return (int) (dp * getResources().getDisplayMetrics().density);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_base);
    }
}
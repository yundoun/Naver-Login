package com.example.myfirstapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;



public class CustomSpinnerAdapter extends ArrayAdapter<CharSequence> {
    private Context context;
    private List<CharSequence> items;

    private int selectedPosition = -1; // 초기 선택 위치 설정

    public CustomSpinnerAdapter(Context context, int resource, List<CharSequence> items) {
        super(context, resource, items);
        this.context = context; // context 초기화 추가
        this.items = items;
    }

    public int getCount() {
        // 실제 아이템 개수보다 하나 적게 반환하여 마지막 항목("통신사 선택")을 숨김
        return super.getCount() - 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        if (selectedPosition < 0) {
            view.setTextColor(ContextCompat.getColor(context, R.color.gray)); // 회색 텍스트
        } else {
            view.setText(items.get(selectedPosition));
            view.setTextColor(ContextCompat.getColor(context, R.color.black)); // 검정색 텍스트
        }
        return view;
    }


    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);
        view.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white)); // 흰색 배경
        return view;
    }


    public void setSelectedPosition(int position) {
        this.selectedPosition = position;
        notifyDataSetChanged();
    }
}

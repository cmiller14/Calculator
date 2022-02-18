package com.a02283751.calculator;

import android.content.Context;
import android.util.Log;
import android.widget.GridLayout;


import androidx.appcompat.widget.AppCompatButton;

public class CalcButton extends AppCompatButton {
    public CalcButton(Context context, CalcButtonData calcButtonData, OnClickListener onClickListener) {
        super(context);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(calcButtonData.row, 1, 1);
        params.columnSpec = GridLayout.spec(calcButtonData.col, calcButtonData.colSpan, 1);
        setLayoutParams(params);
        setText(calcButtonData.text);
        setOnClickListener(onClickListener);
        if (calcButtonData.type == CalcButtonData.ButtonType.INPUT) {
            setBackgroundColor(getResources().getColor(R.color.numberButtonBackground, null));
        }else if (calcButtonData.type == CalcButtonData.ButtonType.SOLVE) {
            setBackgroundColor(getResources().getColor(R.color.equalButtonBackground, null));
        }else {
            setBackgroundColor(getResources().getColor(R.color.operatorButtonBackground, null));
        }

    }
}

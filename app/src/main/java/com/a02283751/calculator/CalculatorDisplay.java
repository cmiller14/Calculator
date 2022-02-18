package com.a02283751.calculator;

import android.content.Context;
import android.view.Gravity;


import androidx.appcompat.widget.AppCompatTextView;

public class CalculatorDisplay extends AppCompatTextView {
    private String expression = "";
    public CalculatorDisplay(Context context) {
        super(context);
        setGravity(Gravity.LEFT);
        setPadding(24, 64, 24, 64);
        setTextSize(24);
    }

    public void setExpression(String expression) {
        this.expression = expression;
        this.setText(expression);
    }

    public String getExpression() {
        return this.expression;
    }


}

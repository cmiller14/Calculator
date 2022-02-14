package com.a02283751.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<CalcButtonData> calcButtonData = new ArrayList<CalcButtonData>() {
        {
            add(new CalcButtonData("0", 3,0,1));
            add(new CalcButtonData("1", 2,0,1));
            add(new CalcButtonData("2", 2,1,1));
            add(new CalcButtonData("3", 2,2,1));
            add(new CalcButtonData("4", 1,0,1));
            add(new CalcButtonData("5", 1,1,1));
            add(new CalcButtonData("6", 1,2,1));
            add(new CalcButtonData("7", 0,0,1));
            add(new CalcButtonData("8", 0,1,1));
            add(new CalcButtonData("9", 0,2,1));
            add(new CalcButtonData("/", 0,3,1));
            add(new CalcButtonData("x", 1,3,1));
            add(new CalcButtonData("-", 2,3,1));
            add(new CalcButtonData("+", 3,3,1));
            add(new CalcButtonData("=", 3,2,1));
            add(new CalcButtonData("clear", 3,1,1));


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        AppCompatTextView displayTextView = new AppCompatTextView(this);
        displayTextView.setText("Hello world");

        GridLayout calcButtonsLayout = new GridLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        calcButtonsLayout.setLayoutParams(params);
        calcButtonsLayout.setColumnCount(4);

        for (CalcButtonData data : calcButtonData) {
            CalcButton button = new CalcButton(
                    this,
                    data,
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    }
            );
            calcButtonsLayout.addView(button);
        }

        layout.addView(displayTextView);
        layout.addView(calcButtonsLayout);


        setContentView(layout);
    }

}
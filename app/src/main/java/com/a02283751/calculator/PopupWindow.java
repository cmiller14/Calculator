package com.a02283751.calculator;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import java.util.ArrayList;
import java.util.Stack;

public class PopupWindow extends LinearLayout {
    private boolean isOpen = false;
    private LinearLayout content;


    public PopupWindow(Context context) {
        super(context);
        setOrientation(VERTICAL);
        setBackgroundColor(Color.argb(.5f,0,0,0));
        setVisibility(INVISIBLE);
        setPadding(48,48,48,48);
        setGravity(Gravity.CENTER);


        LinearLayout wrapper = new LinearLayout(context);
        wrapper.setOrientation(VERTICAL);
        wrapper.setBackgroundColor(Color.WHITE);
        wrapper.setOnClickListener(view -> {});

        content = new LinearLayout(context);
        content.setOrientation(VERTICAL);

        wrapper.addView(content);
        AppCompatButton closeButton = new AppCompatButton(context);
        closeButton.setText("Close");
        closeButton.setOnClickListener(view -> this.close());

        wrapper.addView(closeButton);
        addView(wrapper);

    }


    public void display(Stack<String> expressions) {
        setVisibility(VISIBLE);
        isOpen = true;
        content.removeAllViews();
        while (!expressions.isEmpty()) {
            String expression = expressions.pop();
            AppCompatTextView textView = new AppCompatTextView(getContext());
            textView.setText(expression);
            textView.setTextSize(32);
            content.addView(textView);
        }
    }

    public void close() {
        setVisibility(INVISIBLE);
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }
}

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

    private ArrayList<CalcButtonData> calcButtonData;
    private ArrayList<String> expressions;

    private void initializeData() {
        calcButtonData = new ArrayList<CalcButtonData>() {
            {
                add(new CalcButtonData("0", 3, 1, 1));
                add(new CalcButtonData("1", 2, 0, 1));
                add(new CalcButtonData("2", 2, 1, 1));
                add(new CalcButtonData("3", 2, 2, 1));
                add(new CalcButtonData("4", 1, 0, 1));
                add(new CalcButtonData("5", 1, 1, 1));
                add(new CalcButtonData("6", 1, 2, 1));
                add(new CalcButtonData("7", 0, 0, 1));
                add(new CalcButtonData("8", 0, 1, 1));
                add(new CalcButtonData("9", 0, 2, 1));
                add(new CalcButtonData(" / ", 0, 3, 1, CalcButtonData.ButtonType.OPERATOR));
                add(new CalcButtonData(" x ", 1, 3, 1, CalcButtonData.ButtonType.OPERATOR));
                add(new CalcButtonData(" - ", 2, 3, 1, CalcButtonData.ButtonType.OPERATOR));
                add(new CalcButtonData(" + ", 3, 3, 1, CalcButtonData.ButtonType.OPERATOR));
                add(new CalcButtonData(" = ", 4, 0, 4, CalcButtonData.ButtonType.SOLVE));
                add(new CalcButtonData(getString(R.string.clearButton), 3, 0, 1, CalcButtonData.ButtonType.CLEAR));
                add(new CalcButtonData(getString(R.string.dumpButton), 3, 2, 1, CalcButtonData.ButtonType.DUMP));
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeData();
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);


        CalculatorDisplay calculatorDisplay = new CalculatorDisplay(this);

        GridLayout calcButtonsLayout = new GridLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        calcButtonsLayout.setLayoutParams(params);
        calcButtonsLayout.setColumnCount(4);

        for (final CalcButtonData data : calcButtonData) {
            CalcButton button = new CalcButton(
                    this,
                    data,
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (data.type == CalcButtonData.ButtonType.SOLVE) {
                                // need to evaluate the expression
                                double result = CalculatorProcessor.evaluate(calculatorDisplay.getExpression());
                                String solution = "" + result;
                                if (Double.isNaN(result)) {
                                    calculatorDisplay.setExpression("");
                                }
                                else if (Double.isInfinite(result)) {
                                    calculatorDisplay.setExpression("" + result);
                                }
                                else {
                                    calculatorDisplay.setExpression("" + result);
                                }

                            }
                            if (data.type == CalcButtonData.ButtonType.CLEAR) {
                                // need to clear the expression feild
                                calculatorDisplay.setExpression("");


                            }
                            if (data.type == CalcButtonData.ButtonType.DUMP) {
                                // need to dump all the data

                            }
                            if (data.type == CalcButtonData.ButtonType.INPUT || data.type == CalcButtonData.ButtonType.OPERATOR){
                                // this is input data and needs to be added to the string history
                                calculatorDisplay.setExpression(calculatorDisplay.getText() + data.text);

                            }

                        }
                    }
            );
            calcButtonsLayout.addView(button);
        }

        layout.addView(calculatorDisplay);
        layout.addView(calcButtonsLayout);


        setContentView(layout);
    }

}
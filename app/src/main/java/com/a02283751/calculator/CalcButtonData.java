package com.a02283751.calculator;

public class CalcButtonData {
    public String text;
    public int row;
    public int col;
    public int colSpan;

    public CalcButtonData(String text, int row, int col, int colSpan) {
        this.text = text;
        this.row = row;
        this.col = col;
        this.colSpan = colSpan;
    }

}

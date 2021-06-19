package com.hfad.calculator;

import java.io.Serializable;

public class Calc implements Serializable {


    private String btn0, btn1,btn2, btn3, btn4,
            btn5, btn6, btn7, btn8, btn9, btnTchk,
            btnClear, btnSqrt, btnGneration,
            btnDegree, btnSubtraction, btnAddition, btnPercent;



    public String getBtnPercent() {
        return "%";
    }

    public String getBtnGneration() {
        return "*";
    }

    public String getBtnDegree() {
        return "/";
    }

    public String getBtnSubtraction() {
        return "-";
    }

    public String getBtnAddition() {
        return "+";
    }

    public String getBtn0() {
        return "0";
    }

    public String getBtn1() {
        return "1";
    }

    public String getBtn2() {
        return "2";
    }

    public String getBtn3() {
        return "3";
    }

    public String getBtn4() {
        return "4";
    }

    public String getBtn5() {
        return "5";
    }

    public String getBtn6() {
        return "6";
    }

    public String getBtn7() {
        return "7";
    }

    public String getBtn8() {
        return "8";
    }

    public String getBtn9() {
        return "9";
    }
    public String getbtnTchk() {
        return ".";
    }
}

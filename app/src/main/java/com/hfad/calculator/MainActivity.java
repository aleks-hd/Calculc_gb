package com.hfad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn0, btnTchk, btn1, btn2, btn3, btn4,
            btn5, btn6, btn7, btn8, btn9,
            btnClear, btnPercent, btnSqrt, btnGneration,
            btnDegree, btnSubtraction, btnAddition, btnEqualli;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        innitBtnEdit();
    }

    private void innitBtnEdit() {
        btn0 = findViewById(R.id._0);
        btn1 = findViewById(R.id._1);
        btn2 = findViewById(R.id._2);
        btn3 = findViewById(R.id._3);
        btn4 = findViewById(R.id._4);
        btn5 = findViewById(R.id._5);
        btn6 = findViewById(R.id._6);
        btn7 = findViewById(R.id._7);
        btn8 = findViewById(R.id._8);
        btn9 = findViewById(R.id._9);
        btnClear = findViewById(R.id._C);
        btnPercent = findViewById(R.id._percent);
        btnSqrt = findViewById(R.id._sqrt);
        btnGneration = findViewById(R.id._generation); //умножение
        btnDegree = findViewById(R.id._degree);         //деление
        btnSubtraction = findViewById(R.id._subtraction);//вычитание
        btnAddition = findViewById(R.id._addition);//сложение
        btnEqualli = findViewById(R.id._equalli);//равно
        editText = findViewById(R.id._result);
    }

}

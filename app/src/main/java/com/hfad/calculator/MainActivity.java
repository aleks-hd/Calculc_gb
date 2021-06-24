package com.hfad.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.radiobutton.MaterialRadioButton;

import java.io.Serializable;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn0, btnTchk, btn1, btn2, btn3, btn4,
            btn5, btn6, btn7, btn8, btn9,
            btnClear, btnPercent, btnSqrt, btnGneration,
            btnDegree, btnSubtraction, btnAddition, btnEqualli;
    EditText editText;
    Calc calc;
    String numberSymbol = "";
    //Эксперимент - запоминаем аргумент 1 и 2 и операцию
    Double perem1, perem2;
    String operation;
    Double result;
    RadioButton radioButton_0;
    RadioButton radioButton_1;
    RadioButton radioButton_2;
    private final String keyCounters = "Counters";
    //Имя настроек
    private static final String NameSharedPrefer = "LOGINYS";
    private static final String AppTheme = "APP_THEME";
    //name thema's
    private static final int MyStyleLife = 0;
    private static final int MyThemeLight = 1;
    private static final int MyThemeDark = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.WhiteStyle));
        setContentView(R.layout.activity_main);
        calc = new Calc();
        initTheme();
        innitBtnEdit();



    }

    private void initTheme() {
        initButton(findViewById(R.id.radioDark), MyThemeDark);
        initButton(findViewById(R.id.radioLight), MyThemeLight);
        initButton(findViewById(R.id.radioRedYellow), MyStyleLife);

         RadioGroup rg = findViewById(R.id.radio);
         ((MaterialRadioButton)rg.getChildAt(getCodeStyle(MyThemeLight))).setChecked(true);

    }

    private void initButton(View btn, final int codeStyle) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("warning", codeStyle + "");
                setAppTheme(codeStyle);

                //restart activity
                recreate();
            }
        });
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int codeStyle) {
        //read config
        SharedPreferences sharPref = getSharedPreferences(NameSharedPrefer, MODE_PRIVATE);
        return sharPref.getInt(AppTheme, codeStyle);
    }

    //Метод для сохранения настроев, с именем настроек NameSharedPrefer
    private void setAppTheme(int codeStyle) {
        //Получаем файл настроек для активити,  передав имя общих настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPrefer, MODE_PRIVATE);
        //Чтобы сохранить настроки надо использовать Editor
        SharedPreferences.Editor editor = sharedPref.edit();
        //Сохраняем настройки
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }

    private int codeStyleId(int codeStyle) {
        switch (codeStyle) {
            case MyThemeLight:

                return R.style.AppThemeLight;
            case MyThemeDark:

                return R.style.AppThemeDark;
            default:

                return R.style.WhiteStyle;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(keyCounters, (Serializable) numberSymbol);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle outState) {
        super.onRestoreInstanceState(outState);
        numberSymbol = outState.getString(keyCounters);
        editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));

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
        btnTchk = findViewById(R.id._tchk);
        btnClear = findViewById(R.id._C);
        btnPercent = findViewById(R.id._percent);
        btnSqrt = findViewById(R.id._sqrt);
        btnGneration = findViewById(R.id._generation); //умножение
        btnDegree = findViewById(R.id._degree);         //деление
        btnSubtraction = findViewById(R.id._subtraction);//вычитание
        btnAddition = findViewById(R.id._addition);//сложение
        btnEqualli = findViewById(R.id._equalli);//равно
        editText = findViewById(R.id._result);

        btn0.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);
        btnTchk.setOnClickListener(listener);

        btnClear.setOnClickListener(listener);
        btnDegree.setOnClickListener(listener);
        btnPercent.setOnClickListener(listener);
        btnGneration.setOnClickListener(listener);
        btnAddition.setOnClickListener(listener);
        btnEqualli.setOnClickListener(listener);
        btnSubtraction.setOnClickListener(listener);
        btnSqrt.setOnClickListener(listener);


    }

    //метод добавления текста в editText


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id._0:
                    numberSymbol += calc.getBtn0();
                    editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._1:
                    numberSymbol += calc.getBtn1();
                    editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._2:
                    numberSymbol += calc.getBtn2();
                    editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._3:
                    numberSymbol += calc.getBtn3();
                    editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._4:
                    numberSymbol += calc.getBtn4();
                    editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._5:
                    numberSymbol += calc.getBtn5();
                    editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._6:
                    numberSymbol += calc.getBtn6();
                    editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._7:
                    numberSymbol += calc.getBtn7();
                    editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._8:
                    numberSymbol += calc.getBtn8();
                    editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._9:
                    numberSymbol += calc.getBtn9();
                    editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._tchk:
                    if (numberSymbol.equals("")) {
                    } else {
                        numberSymbol += calc.getbtnTchk();
                        editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    }
                    break;
                case R.id._addition:

                    perem1 = Double.parseDouble(numberSymbol);
                    operation = "+";
                    numberSymbol = "";
                    editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._generation:
                    perem1 = Double.parseDouble(numberSymbol);
                    operation = "*";
                    numberSymbol = "";
                    //editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._subtraction:
                    perem1 = Double.parseDouble(numberSymbol);
                    operation = "-";
                    numberSymbol = "";
                    //editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._degree:
                    perem1 = Double.parseDouble(numberSymbol);
                    operation = "/";
                    numberSymbol = "";
                    //editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._percent:
                    perem1 = Double.parseDouble(numberSymbol);
                    operation = "%";
                    numberSymbol = "";
                    //editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
                case R.id._sqrt:
                    perem1 = Double.parseDouble(numberSymbol);
                    operation = "sqrt";
                    numberSymbol = "";
                    Toast.makeText(MainActivity.this, "Пока не работает", Toast.LENGTH_SHORT);
                    break;
                case R.id._equalli:
                    perem2 = Double.parseDouble(numberSymbol);
                    //потом исправить(на свич), сейчас для проверки

                    if (operation == "+") {
                        result = perem1 + perem2;
                    } else if (operation == "-") {
                        result = perem1 - perem2;
                    } else if (operation == "/") {
                        result = perem1 + perem2;
                    } else if (operation == "*") {
                        result = perem1 * perem2;
                    } else if (operation == "%") {
                        result = (perem1 / perem2) * 100;
                    } else {
                        Toast.makeText(MainActivity.this, "Пока не доделал", Toast.LENGTH_SHORT);
                    }
                    editText.setText(String.format(Locale.getDefault(), "%s", result));
                    numberSymbol = String.format(Locale.getDefault(), "%s", result);
                    perem1 = result;
                    break;
                case R.id._C:
                    numberSymbol = "";
                    editText.setText(String.format(Locale.getDefault(), "%s", numberSymbol));
                    break;
            }
        }
    };

    /*private void result(String a){
         //Оталось самое сложное - преобразовать введеную строку в математическое выражение, как это сделать - не знаю, скорее всего цифры в Integer, а символы в char, и писать это в переменную типа double.
         По нажатию на кнопку = сделать вычисление
    }*/

}

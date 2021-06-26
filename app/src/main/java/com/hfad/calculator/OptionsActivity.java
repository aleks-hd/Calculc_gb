package com.hfad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class OptionsActivity extends AppCompatActivity {
    //Имя настроек
    private static final String NameSharedPrefer = "LOGINYS";
    private static final String AppTheme = "APP_THEME";
    //name thema's

    private static final int MyThemeLight = 0;
    private static final int MyThemeDark = 1;
    private static final int MyStyleLife = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.Theme_Light));
        setContentView(R.layout.activity_options);
        initTheme();
        iniBtn();
    }

    private void iniBtn() {
        Button btn = findViewById(R.id.btnNext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initTheme() {

        initButton(findViewById(R.id.radioLight), MyThemeLight);
        initButton(findViewById(R.id.radioDark), MyThemeDark);
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
        //Читаем конфиг и возвращаем идентификатор сохраненой в конфиге стиля
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

                return R.style.Theme_Light;
            case MyThemeDark:

                return R.style.Theme_Night;
            case MyStyleLife:
                return R.style.Theme_RedYellow;

             default:

                return R.style.AppTheme;
        }
    }

}
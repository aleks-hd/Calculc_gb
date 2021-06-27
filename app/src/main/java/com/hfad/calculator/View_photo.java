package com.hfad.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import java.net.URI;

public class View_photo extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photo);

        initImageView();

        getAction();

    }

    private void initImageView() {
        img = findViewById(R.id.imageView);
    }

    private void getAction() {
        Intent intent = getIntent();
        String act = intent.getAction();
        //String type = intent.getType();

        if (Intent.ACTION_SEND.equals(act)) {
            img.setImageURI(intent.getParcelableExtra(intent.EXTRA_STREAM));
        }
    }

}
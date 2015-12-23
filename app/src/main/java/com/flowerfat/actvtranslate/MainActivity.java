package com.flowerfat.actvtranslate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.flowerfat.actvtranslate.one.startActivity1;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Click1(View v) {
        startActivity(new Intent(this, startActivity1.class));
    }
}

package com.flowerfat.actvtranslate.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.flowerfat.actvtranslate.R;
import com.flowerfat.actvtranslate.entity.ElementInfo;
import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "onCreate");
        init();
    }

    Toolbar toolbar ;
    private void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void girlClick(View v){
        int[] startingLocation = new int[2];
        int imageRes = R.mipmap.girl0;
        if(v.getId() == R.id.start1_beautifulGirl1) {
            imageRes = R.mipmap.girl1 ;
        } else if(v.getId() == R.id.start1_beautifulGirl2) {
            imageRes = R.mipmap.girl2 ;
        } else if(v.getId() == R.id.start1_beautifulGirl3) {
            imageRes = R.mipmap.girl3 ;
        }
        startingLocation[0] = v.getLeft() ;
        startingLocation[1] = v.getTop() ;
        Log.i("startingLocation 1", startingLocation[0] + "   " + startingLocation[1]);
        ElementInfo info = new ElementInfo(v.getLeft(), v.getTop());
        DemoActivity1.startFromLocation(new Gson().toJson(info), imageRes, this, DemoActivity1.class);
        overridePendingTransition(0, 0);


        int[] toolbarLocation = new int[2];
        toolbar.getLocationOnScreen(toolbarLocation);
        Log.i("toolbarLocation", toolbarLocation[0] + "   " + toolbarLocation[1]);
    }
}

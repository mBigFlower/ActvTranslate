package com.flowerfat.actvtranslate.one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.flowerfat.actvtranslate.R;

public class startActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity1);

        init();
    }

    private void init() {

    }

    public void girlClick(View v){
        int[] startingLocation = new int[2];
        startingLocation[0] = v.getLeft() ;
        startingLocation[1] = v.getTop() ;
        endActivity1.startFromLocation(startingLocation, this);
        overridePendingTransition(0, 0);
    }




}

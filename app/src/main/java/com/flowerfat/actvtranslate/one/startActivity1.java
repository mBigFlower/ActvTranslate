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
        endActivity1.startFromLocation(startingLocation, imageRes, this);
        overridePendingTransition(0, 0);
    }




}

package com.flowerfat.actvtranslate.one;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flowerfat.actvtranslate.R;

public class endActivity1 extends AppCompatActivity {

    public static final String ARG_REVEAL_START_LOCATION = "reveal_start_location";

    private LinearLayout rootLayout;
    private ImageView girlIv;
    private TextView contentTv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_activity1);

        initContent();

        setupRevealBackground(savedInstanceState);
    }


    private void initContent() {
        girlIv = (ImageView) findViewById(R.id.end1_beautifulGirl);
        rootLayout = (LinearLayout) findViewById(R.id.end1_rootLayout);
        contentTv = (TextView) findViewById(R.id.end1_content);

    }

    /**
     * 变化的圆的动画控制
     *
     * @param savedInstanceState
     */
    private void setupRevealBackground(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            final int[] startingLocation = getIntent().getIntArrayExtra(ARG_REVEAL_START_LOCATION);
            girlIv.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    girlIv.getViewTreeObserver().removeOnPreDrawListener(this);
                    rootLayout.setPadding(0, startingLocation[1], 0, 0);
                    girlIv.setImageResource(R.mipmap.girl2);

                    animIn();
                    return true;
                }
            });
        }
    }

    private void animIn() {

    }


    public static void startFromLocation(int[] startingLocation, Activity startingActivity) {
        Intent intent = new Intent(startingActivity, endActivity1.class);
        intent.putExtra(ARG_REVEAL_START_LOCATION, startingLocation);
        startingActivity.startActivity(intent);
    }

}

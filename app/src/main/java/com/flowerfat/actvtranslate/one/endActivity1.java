package com.flowerfat.actvtranslate.one;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.flowerfat.actvtranslate.R;

public class endActivity1 extends AppCompatActivity {

    public static final String START_LOCATION = "start_location";
    public static final String IMAGE_RES = "image_res";
    // 加速减速插值器
    private AccelerateDecelerateInterpolator INTERPOLATOR_ONE = new AccelerateDecelerateInterpolator();

    private int emptyPaddingTop = 0;

    private FrameLayout emptyView;
    private ImageView girlIv;
    private TextView contentTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_activity1);

        initContent();

        setupRevealBackground(savedInstanceState);
    }


    private void initContent() {
        girlIv = (ImageView) findViewById(R.id.end1_beautifulGirl);
        emptyView = (FrameLayout) findViewById(R.id.end1_emptyView);
        contentTv = (TextView) findViewById(R.id.end1_content);

    }

    /**
     * �仯��Բ�Ķ�������
     *
     * @param savedInstanceState
     */
    private void setupRevealBackground(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            final int[] startingLocation = getIntent().getIntArrayExtra(START_LOCATION);
            emptyPaddingTop = startingLocation[1];
            final int imageRes = getIntent().getIntExtra(IMAGE_RES, 0);
            girlIv.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    Log.i("onPreDraw", "onPreDraw");
                    girlIv.getViewTreeObserver().removeOnPreDrawListener(this);
                    emptyView.setPadding(0, emptyPaddingTop, 0, 0);
                    contentTv.setPadding(0, emptyPaddingTop, 0, 0);
                    girlIv.setImageResource(imageRes);

                    animIn();
                    animIn2();
                    return true;
                }
            });
        }
    }

    private void animIn() {
        contentTv.animate().alpha(1).setDuration(500).start();
        emptyView.animate().alpha(1).setDuration(500).start();
    }

    public void animIn2() {
        ObjectAnimator anim = ObjectAnimator//
                .ofInt(emptyView, "emptyPaddingTop", emptyPaddingTop, 36)//
                .setDuration(888);//
        anim.setInterpolator(INTERPOLATOR_ONE);
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int paddingTop = (int) animation.getAnimatedValue();
                emptyView.setPadding(0, paddingTop, 0, 0);
                contentTv.setPadding(0, paddingTop, 0, 0);
            }
        });
    }

    public int getEmptyPaddingTop() {
        return emptyPaddingTop;
    }

    public void setEmptyPaddingTop(int emptyPaddingTop) {
        this.emptyPaddingTop = emptyPaddingTop;
    }

    public static void startFromLocation(int[] startingLocation, int imageRes, Activity startingActivity) {
        Intent intent = new Intent(startingActivity, endActivity1.class);
        intent.putExtra(START_LOCATION, startingLocation);
        intent.putExtra(IMAGE_RES, imageRes);
        startingActivity.startActivity(intent);
    }

}

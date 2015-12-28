package com.flowerfat.actvtranslate.activity.base;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.flowerfat.actvtranslate.R;
import com.flowerfat.actvtranslate.entity.ElementInfo;
import com.flowerfat.actvtranslate.utils.Util;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2015/12/27.
 */
public abstract class TransActivity extends AppCompatActivity {

    public static final String ELEMENT_INFO = "start_location";
    public static final String IMAGE_RES = "image_res";
    public static final int TIME_ANIM = 888;
    public static String TAG;
    // 自定义的目标界面布局   共用元素的布局
    private View userLayout, sameLayout;
    public ImageView animIv;


    public int imgRes;
    public ElementInfo imgInfo;
    public int topDistance;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();

        setContentView(R.layout.base_trans_layout);

        init();
        setupRevealBackground(savedInstanceState);
    }

    public abstract int initUserLayoutId();
    public abstract int initSameLayoutId();

    public abstract void initData();

    private void init() {
        // init the layout
        int sameLayoutRes = initSameLayoutId();
        int userLayoutRes = initUserLayoutId();
        if(sameLayoutRes == 0)
            throw new NullPointerException("You should add your same layout in initUserLayoutId");
        if(userLayoutRes == 0)
            throw new NullPointerException("You should add your aim layout in initUserLayoutId");
        // get the same layout and the widget
        ViewStub sameVs = (ViewStub) findViewById(R.id.trans_sameLayout);
        sameVs.setLayoutResource(sameLayoutRes);
        sameLayout = sameVs.inflate();
        animIv = (ImageView) sameLayout.findViewById(R.id.trans_img);
        // get the user layout
        ViewStub userVs = (ViewStub) findViewById(R.id.trans_userLayout);
        userVs.setLayoutResource(userLayoutRes);
        userLayout = userVs.inflate();
        userView(userLayout);
    }



    private void setupRevealBackground(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            imgInfo = new Gson().fromJson(getIntent().getStringExtra(ELEMENT_INFO), ElementInfo.class);
            imgRes = getIntent().getIntExtra(IMAGE_RES, 0);
            topDistance = imgInfo.getY() + Util.dpToPx(56);

            animIv.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    Log.i("onPreDraw", "onPreDraw");
                    animIv.getViewTreeObserver().removeOnPreDrawListener(this);

                    animInit();
                    animLayout();
                    animImg();

                    return true;
                }
            });
        }
    }

    private void animLayout() {
        userLayout.animate().alpha(1).setDuration(TIME_ANIM).start();
    }

    private void animInit() {
        animIv.setImageResource(imgRes);
        setAnimIvMargin(32, topDistance, 32, 152);

        userLayout.setAlpha(0);
    }



    private void animImg() {
        ObjectAnimator anim = ObjectAnimator//
                .ofInt(animIv, "topDistance", topDistance, 0)//
                .setDuration(TIME_ANIM);//
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int topDistancing = (int) animation.getAnimatedValue();
                int leftRightDis = topDistancing * 12 / topDistance;
                int bottomDistance = topDistancing * Util.dpToPx(256-180) / topDistance;

                setAnimIvMargin(leftRightDis, topDistancing, leftRightDis, bottomDistance);
                if (topDistancing == 0) {
                    animOver();
                }
            }
        });
    }

    private void setAnimIvMargin(int left, int top, int right, int height) {
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) animIv.getLayoutParams();
        lp.leftMargin = left;
        lp.rightMargin = right;
        lp.topMargin = top;
        lp.height = Util.dpToPx(256) - height;
        animIv.setLayoutParams(lp);
    }

    public static void startFromLocation(String info, int imageRes, Activity startAct, Class endAct) {
        Intent intent = new Intent(startAct, endAct);
        intent.putExtra(ELEMENT_INFO, info);
        intent.putExtra(IMAGE_RES, imageRes);
        startAct.startActivity(intent);
    }


    public void userView(View view) {
    }

    public void animOver() {
        animIv.animate().alpha(0).setDuration(300).setStartDelay(800).start();
    }
}

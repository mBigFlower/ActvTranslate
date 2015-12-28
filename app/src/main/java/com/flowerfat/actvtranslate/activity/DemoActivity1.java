package com.flowerfat.actvtranslate.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.flowerfat.actvtranslate.R;
import com.flowerfat.actvtranslate.activity.base.TransActivity;

public class DemoActivity1 extends TransActivity {

    @Override
    public int initUserLayoutId() {
        return R.layout.activity_demo1;
    }

    @Override
    public int initSameLayoutId() {
        return R.layout.layoutsame_demo1;
    }

    @Override
    public void initData() {

    }

    @Override
    public void animOver() {
        super.animOver();
        initTop();
    }

    private void initTop() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("beautiful world");

        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        imageView.setImageResource(imgRes);
        Log.i("高度", "高度：" + collapsingToolbar.getHeight());
    }
}

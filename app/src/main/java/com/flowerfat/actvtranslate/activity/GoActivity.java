package com.flowerfat.actvtranslate.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.flowerfat.actvtranslate.R;
import com.flowerfat.actvtranslate.activity.base.TransActivity;

public class GoActivity extends TransActivity {

    @Override
    public int setLayoutId() {
        return R.layout.activity_go;
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

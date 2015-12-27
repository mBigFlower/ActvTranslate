package com.flowerfat.actvtranslate.utils;

import android.content.res.Resources;

/**
 * Created by Administrator on 2015/12/26.
 */
public class Util {

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}

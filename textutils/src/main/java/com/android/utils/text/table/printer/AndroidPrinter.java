package com.android.utils.text.table.printer;

import android.util.Log;

/**
 * @author Pinned
 * @since 2019-05-05
 */
public class AndroidPrinter extends Printer {
    private String mTag = "";

    @Override
    public void output(String result) {
        Log.d(mTag, result);
    }

    public void setTag(String tag) {
        mTag = tag;
    }
}

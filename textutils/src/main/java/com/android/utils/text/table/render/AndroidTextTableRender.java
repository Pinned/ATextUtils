package com.android.utils.text.table.render;

import com.android.utils.text.table.printer.AndroidPrinter;
import com.android.utils.text.table.printer.Printer;

/**
 * @author Pinned
 * @since 2019-05-05
 */
public class AndroidTextTableRender extends TextTableRender {

    private String mTag;
    private AndroidPrinter mPrinter;

    public AndroidTextTableRender(String tag) {
        super();
        this.mTag = tag;
        mPrinter.setTag(mTag);
    }

    @Override
    protected Printer createPrinter() {
        mPrinter = new AndroidPrinter();
        return mPrinter;
    }
}

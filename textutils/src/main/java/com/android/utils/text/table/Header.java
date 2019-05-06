package com.android.utils.text.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pinned
 * @since 2019-05-05
 */
public class Header<T> {
    private LogTable mTable;
    private List<T> mHeaders;

    public Header(LogTable table, T... header) {
        mTable = table;
        mHeaders = new ArrayList<>();
        mHeaders.addAll(Arrays.asList(header));
    }

    public Header next(T value) {
        mHeaders.add(value);
        return this;
    }

    public LogTable end() {
        return this.mTable;
    }

    public List<T> getHeaders() {
        return mHeaders;
    }

    public T getItem(int index) {
        return mHeaders.get(index);
    }
}

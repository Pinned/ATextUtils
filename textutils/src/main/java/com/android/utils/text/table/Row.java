package com.android.utils.text.table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pinned
 * @since 2019-05-05
 */
public class Row<T> {

    private List<T> mRows;
    private LogTable mTable;

    public Row(LogTable table, T... items) {
        this.mTable = table;
        mRows = new ArrayList<>();
        mRows.addAll(Arrays.asList(items));
    }

    public Row next(T item) {
        mRows.add(item);
        return this;
    }

    public LogTable end() {
        return mTable;
    }

    public List<T> getRows() {
        return mRows;
    }
}

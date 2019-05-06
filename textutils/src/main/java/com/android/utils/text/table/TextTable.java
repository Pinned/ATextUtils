package com.android.utils.text.table;

import com.android.utils.text.table.model.TableModel;


/**
 * @author Pinned
 * @since 2019-05-05
 */
public class TextTable {
    private TableModel<?> mTableModel;
    private boolean mShowSeparator = false;

    public TextTable(TableModel<?> tableModel) {
        this.mTableModel = tableModel;
    }

    public TableModel<?> getTableModel() {
        return mTableModel;
    }

    public void setShowSeparator(boolean showSeparator) {
        mShowSeparator = showSeparator;
    }

    public boolean isShowSeparator() {
        return mShowSeparator;
    }
}

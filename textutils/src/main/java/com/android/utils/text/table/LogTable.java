package com.android.utils.text.table;

import com.android.utils.text.table.render.AndroidTextTableRender;
import com.android.utils.text.table.render.TextTableRender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pinned
 * @since 2019-05-05
 */
public class LogTable {
    private Header mHeader;
    private List<Row<String>> mRows;
    private TextTableRender mTableRender = null;
    private boolean mShowSeparator = true;

    public Header headers(String... headers) {
        if (mHeader != null) {
            throw new IllegalArgumentException("Headers can only be set once");
        }
        mHeader = new Header(this, headers);
        return mHeader;
    }

    public Row rows(String... rows) {
        if (mRows == null) {
            mRows = new ArrayList<>();
        }
        Row<String> row = new Row<>(this, rows);
        mRows.add(row);
        return row;
    }

    public LogTable render(TextTableRender render) {
        this.mTableRender = render;
        return this;
    }

    public LogTable showSeparator(boolean showSeparator) {
        this.mShowSeparator = showSeparator;
        return this;
    }

    public void log() {
        int maxSize = 0;
        for (Row<String> row : mRows) {
            int columnSize = row.getRows().size();
            maxSize = Math.max(maxSize, columnSize);
        }
        if (mHeader == null) {
            mHeader = new Header(this);
        }
        int headerLength = mHeader.getHeaders().size();
        for (int i = headerLength; i < maxSize; i++) {
            mHeader.next("-");
        }
        TextTable textTable = new TextTable(new BaseTableModel<String>(mHeader, mRows));
        if (mTableRender == null) {
            mTableRender = new AndroidTextTableRender("TABLE");
        }
        textTable.setShowSeparator(this.mShowSeparator);
        mTableRender.setTextTable(textTable);
        mTableRender.render(0);
    }


}

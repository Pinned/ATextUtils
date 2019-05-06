package com.android.utils.text.table;

import com.android.utils.text.table.model.TableModel;

import java.util.List;

/**
 * @author Pinned
 * @since 2019-05-05
 */
public class BaseTableModel<T> implements TableModel<T> {

    private Header<String> mHeader;
    private List<Row<T>> mRows;

    public BaseTableModel(Header<String> header, List<Row<T>> rows) {
        mHeader = header;
        mRows = rows;
    }

    @Override
    public int getRowCount() {
        return mRows.size();
    }

    @Override
    public int getColumnCount() {
        return mHeader.getHeaders().size();
    }

    @Override
    public String getColumnName(int column) {
        return mHeader.getItem(column);
    }

    @Override
    public T getValueAt(int row, int column) {
        if (row < mRows.size() && row >= 0) {
            List<T> columns = mRows.get(row).getRows();
            if (column < columns.size() && column >= 0) {
                return columns.get(column);
            }
        }
        return null;
    }

    @Override
    public void setValueAt(T value, int row, int column) {
    }
}

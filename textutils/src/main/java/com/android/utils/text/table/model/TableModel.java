package com.android.utils.text.table.model;

/**
 * @author Pinned
 * @since 2019-05-05
 */
public interface TableModel<T> {
    int getRowCount();

    int getColumnCount();

    String getColumnName(int column);

    T getValueAt(int row, int column);

    void setValueAt(T value, int row, int column);
}

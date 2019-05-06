package com.android.utils.text.table.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Pinned
 * @since 2019-05-05
 */
public class MapBasedTableModel<T> implements TableModel<T> {

    private List<Map<String, T>> mDatas;
    private List<String> mColumnNames;

    public MapBasedTableModel(List<Map<String, T>> datas) {
        this.mColumnNames = new ArrayList<>(datas.get(0).keySet());
        mDatas = datas;
    }

    @Override
    public int getRowCount() {
        return mDatas.size();
    }

    @Override
    public int getColumnCount() {
        return mColumnNames.size();
    }

    @Override
    public String getColumnName(int column) {
        return mColumnNames.get(column);
    }

    @Override
    public T getValueAt(int row, int column) {
        Map<String, T> m = mDatas.get(row);
        String columnName = mColumnNames.get(column);
        return m.get(columnName);
    }

    @Override
    public void setValueAt(T value, int row, int column) {
    }
}

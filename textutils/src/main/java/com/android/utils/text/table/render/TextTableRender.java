package com.android.utils.text.table.render;

import com.android.utils.text.table.utils.StringUtils;
import com.android.utils.text.table.model.TableModel;
import com.android.utils.text.table.TextTable;
import com.android.utils.text.table.printer.Printer;

/**
 * @author Pinned
 * @since 2019-05-05
 */
public abstract class TextTableRender implements TableRender {
    private TextTable mTextTable;
    private boolean showNulls = false;
    protected String[] formats;
    protected int[] lengths;

    private Printer mPrinter;


    public TextTableRender() {
        mPrinter = createPrinter();
    }

    public void setTextTable(TextTable textTable) {
        mTextTable = textTable;
    }

    protected abstract Printer createPrinter();

    @Override
    public void render(int indent) {
        TableModel tableModel = mTextTable.getTableModel();
        String indentStr = StringUtils.repeat(" ", indent);
        lengths = resolveColumnLengths(tableModel);
        String separator = resolveSeparator(tableModel, lengths);

        int rowCount = tableModel.getRowCount();
        int rowCountStrSize = Integer.toString(rowCount).length();
        String indexFormat = "%1$-" + rowCountStrSize + "s  ";
        int totLength = resolveFormats();

        printLine(tableModel, indentStr, indexFormat, totLength, mPrinter);
        printTableLineContent(tableModel, indentStr, indexFormat, mPrinter, -1);
        if (!mTextTable.isShowSeparator()) {
            printLine(tableModel, indentStr, indexFormat, totLength, mPrinter);
        }
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (mTextTable.isShowSeparator()) {
                mPrinter.print(indentStr);
                mPrinter.println(separator);
                mPrinter.flush();
            }
            printTableLineContent(tableModel, indentStr, indexFormat, mPrinter, i);
        }
    }

    private void printTableLineContent(TableModel tableModel, String indentStr, String indexFormat1, Printer printer, int row) {
        printer.print(indentStr);
        for (int j = 0; j < tableModel.getColumnCount(); j++) {
            if (row < 0) {
                printer.print(String.format(formats[j], tableModel.getColumnName(j)));
            } else {
                Object value = tableModel.getValueAt(row, j);
                if (value == null) {
                    printer.print(String.format(formats[j], ""));
                } else {
                    printer.print(String.format(formats[j], value));
                }
            }
        }
        printer.println();
        printer.flush();
    }


    private void printLine(TableModel tableModel, String indentStr, String indexFormat1, int totLength, Printer printer) {
        String headerStartSep = StringUtils.repeat("_", totLength + tableModel.getColumnCount() * 2);
        printer.print(indentStr);
        printer.println(headerStartSep);
        printer.flush();
    }


    private int[] resolveColumnLengths(TableModel<?> tableModel) {
        int[] lengths = new int[tableModel.getColumnCount()];

        for (int col = 0; col < tableModel.getColumnCount(); col++) {
            for (int row = 0; row < tableModel.getRowCount(); row++) {
                Object val = tableModel.getValueAt(row, col);
                String valStr = String.valueOf(val);
                if (!showNulls && val == null) {
                    valStr = "";
                }
                lengths[col] = Math.max(valStr.length(), lengths[col]);
            }
        }
        return lengths;
    }

    private String resolveSeparator(TableModel<?> tableModel, int[] lengths) {
        StringBuilder sepSb = new StringBuilder();

        for (int j = 0; j < tableModel.getColumnCount(); j++) {
            if (j == 0) {
                sepSb.append("|");
            }
            lengths[j] = Math.max(tableModel.getColumnName(j).length(), lengths[j]);
            // add 1 because of the leading space in each column
            sepSb.append(StringUtils.repeat("-", lengths[j] + 2));
            sepSb.append("|");
        }
        String separator = sepSb.toString();
        return separator;
    }

    private int resolveFormats() {
        int totLength = 0;
        formats = new String[lengths.length];
        for (int i = 0; i < lengths.length; i++) {
            StringBuilder sb = new StringBuilder();
            if (i == 0) {
                sb.append("|");
            }
            sb.append(" %1$-");
            sb.append(lengths[i]);
            sb.append("s |");
            sb.append(i + 1 == lengths.length ? "\n" : "");
            formats[i] = sb.toString();
            totLength += (lengths[i] + 1);
        }
        return totLength;
    }
}

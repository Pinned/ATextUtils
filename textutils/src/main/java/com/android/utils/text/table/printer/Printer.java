package com.android.utils.text.table.printer;

/**
 * @author Pinned
 * @since 2019-05-05
 */
public abstract class Printer {
    private StringBuilder sepSb = new StringBuilder();

    public void print(String s) {
        sepSb.append(s);
    }

    public void println(String s) {
        sepSb.append(s);
        sepSb.append("\n");
    }

    public void println() {
        sepSb.append("\n");
    }

    public void flush() {
        output(sepSb.toString());
        sepSb = new StringBuilder();
    }

    public abstract void output(String result);

}

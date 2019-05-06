package com.android.utils.text.table.utils;


/**
 * @author Pinned
 * @since 2019-05-05
 */
public final class StringUtils {

    public static String repeat(String str, int count) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < count; ++i) {
            sb.append(str);
        }

        return sb.toString();
    }
}

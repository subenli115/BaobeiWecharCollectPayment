package com.ziran.meiliao.Logger;

import android.util.Log;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class Logger {

    private static final String TAG = "MRR";

    public static final void v(String log) {
        Log.v(TAG, log);
    }

    public static final void d(String log) {
        Log.d(TAG, log);
    }

    public static final void i(String log) {
        Log.i(TAG, log);
    }

    public static final void w(String log) {
        Log.w(TAG, log);
    }

    public static final void e(String log) {
        Log.e(TAG, log);
    }
}

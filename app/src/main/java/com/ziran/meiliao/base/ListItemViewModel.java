package com.ziran.meiliao.base;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class ListItemViewModel<T extends BaseActivity> {

    protected T mActivity;

    public ListItemViewModel(T activity) {
        mActivity = activity;
    }
}
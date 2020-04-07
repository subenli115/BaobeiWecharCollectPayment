package com.ziran.meiliao;

import android.view.View;

import com.ziran.meiliao.base.BaseViewModel;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class MainViewModel extends BaseViewModel<MainActivity> {

    public MainViewModel(MainActivity activity) {
        super(activity);
    }

    public void onUserInfoBtnClick(View view) {
        mActivity.startUserInfoPage();
    }

    public void onFriendListBtnClick(View view) {
        mActivity.startFriendListPage();
    }

    public void onChatListBtnClick(View view) {
        mActivity.startChatListPage();
    }

    public void onFansBtnClick(View view) {
        mActivity.startFansPage();
    }

    @Override
    public void clear() {

    }
}

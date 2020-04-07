package com.ziran.meiliao;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.ziran.meiliao.base.BaseActivity;
import com.ziran.meiliao.chatlist.ChatListActivity;
import com.ziran.meiliao.databinding.ActivityMainBinding;
import com.ziran.meiliao.friendlist.FriendListActivity;
import com.ziran.meiliao.fanslist.FansListActivity;
import com.ziran.meiliao.userinfo.UserInfoActivity;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding mMainBinding;

    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainViewModel = new MainViewModel(this);
        mMainBinding.setMainViewModel(mMainViewModel);
    }

    public void startUserInfoPage() {
        startActivity(new Intent(this, UserInfoActivity.class));
    }

    public void startFriendListPage() {
        startActivity(new Intent(this, FriendListActivity.class));
    }

    public void startChatListPage() {
        startActivity(new Intent(this, ChatListActivity.class));
    }

    public void startFansPage() {
        startActivity(new Intent(this, FansListActivity.class));
    }
}

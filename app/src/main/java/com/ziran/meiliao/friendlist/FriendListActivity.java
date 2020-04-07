package com.ziran.meiliao.friendlist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.ziran.meiliao.BR;
import com.ziran.meiliao.R;
import com.ziran.meiliao.adapter.CommonAdapter;
import com.ziran.meiliao.base.BaseActivity;
import com.ziran.meiliao.databinding.ActivityFriendListBinding;
import com.ziran.meiliao.util.VerticalDecoration;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class FriendListActivity extends BaseActivity {

    private ActivityFriendListBinding mFriendListBinding;

    private FriendListViewModel mFriendListViewModel;

    private CommonAdapter<FriendViewModel> mFriendsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFriendListBinding = DataBindingUtil.setContentView(this, R.layout.activity_friend_list);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("好友列表");
        }

        mFriendListViewModel = new FriendListViewModel(this);
        mFriendListBinding.setFriendListViewModel(mFriendListViewModel);

        mFriendListBinding.friendListRecyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mFriendListBinding.friendListRecyclerView.addItemDecoration(new VerticalDecoration(this));
        mFriendsAdapter = new CommonAdapter<>(R.layout.list_item_friend, BR.friendViewModel);
        mFriendListBinding.friendListRecyclerView.setAdapter(mFriendsAdapter);

        mFriendListViewModel.loadFriendList();
    }
}

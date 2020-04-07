package com.ziran.meiliao.chatlist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.ziran.meiliao.R;
import com.ziran.meiliao.adapter.MultiTypeAdapter;
import com.ziran.meiliao.base.BaseActivity;
import com.ziran.meiliao.databinding.ActivityChatListBinding;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class ChatListActivity extends BaseActivity {

    private ActivityChatListBinding mChatListBinding;

    private ChatListViewModel mChatListViewModel;

    private MultiTypeAdapter<MessageViewModel> mMessageAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mChatListBinding = DataBindingUtil.setContentView(this, R.layout.activity_chat_list);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("聊天");
        }

        mChatListViewModel = new ChatListViewModel(this);
        mChatListBinding.setChatListViewModel(mChatListViewModel);

        mChatListBinding.friendListRecyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mMessageAdapter = new MultiTypeAdapter<>(this);
        mChatListBinding.friendListRecyclerView.setAdapter(mMessageAdapter);

        mChatListViewModel.loadChatList();
    }
}

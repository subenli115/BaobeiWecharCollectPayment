package com.ziran.meiliao.userinfo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.ziran.meiliao.BR;
import com.ziran.meiliao.R;
import com.ziran.meiliao.adapter.CommonAdapter;
import com.ziran.meiliao.base.BaseActivity;
import com.ziran.meiliao.databinding.ActivityUserInfoBinding;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class UserInfoActivity extends BaseActivity {

    private ActivityUserInfoBinding mUserInfoBinding;

    private UserInfoViewModel mUserInfoViewModel;

    private CommonAdapter<HobbyViewModel> mHobbiesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_info);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("用户信息");
        }

        mUserInfoViewModel = new UserInfoViewModel(this);
        mUserInfoBinding.setUserInfoViewModel(mUserInfoViewModel);

        mUserInfoBinding.hobbyRecyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mHobbiesAdapter = new CommonAdapter<>(R.layout.list_item_hobby, BR.hobbyViewModel);
        mUserInfoBinding.hobbyRecyclerView.setAdapter(mHobbiesAdapter);

        mUserInfoViewModel.loadUserInfo();
    }
}

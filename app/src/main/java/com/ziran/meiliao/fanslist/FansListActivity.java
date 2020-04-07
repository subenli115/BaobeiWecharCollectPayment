package com.ziran.meiliao.fanslist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.ziran.meiliao.BR;
import com.ziran.meiliao.R;
import com.ziran.meiliao.adapter.CommonAdapter;
import com.ziran.meiliao.base.BaseActivity;
import com.ziran.meiliao.databinding.ActivityFansListBinding;
import com.ziran.meiliao.util.VerticalDecoration;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class FansListActivity extends BaseActivity {

    private ActivityFansListBinding mFansListBinding;

    private FansListViewModel mFansListViewModel;

    private CommonAdapter<FansViewModel> mFansAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFansListBinding = DataBindingUtil.setContentView(this, R.layout.activity_fans_list);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("粉丝列表");
        }

        mFansListViewModel = new FansListViewModel(this);
        mFansListBinding.setFansListViewModel(mFansListViewModel);

        mFansListBinding.fansListRecyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mFansListBinding.fansListRecyclerView.addItemDecoration(new VerticalDecoration(this));
        mFansAdapter = new CommonAdapter<>(R.layout.list_item_fans, BR.fansViewModel);
        mFansListBinding.fansListRecyclerView.setAdapter(mFansAdapter);

        mFansListViewModel.loadFansList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFansListViewModel.clear();
    }
}

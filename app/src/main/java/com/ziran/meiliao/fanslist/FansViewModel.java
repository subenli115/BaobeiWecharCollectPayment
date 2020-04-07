package com.ziran.meiliao.fanslist;

import android.databinding.ObservableField;
import android.view.View;
import android.widget.Toast;

import com.ziran.meiliao.base.ListItemViewModel;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class FansViewModel extends ListItemViewModel<FansListActivity> {

    public ObservableField<String> mHeadImgUrl = new ObservableField<>();

    public ObservableField<String> mNickName = new ObservableField<>();

    public ObservableField<String> mLastMessage = new ObservableField<>();

    public FansViewModel(FansListActivity activity) {
        super(activity);
    }

    public FansViewModel setData(String headImgUrl, String nickName, String lastMessage) {
        mHeadImgUrl.set(headImgUrl);
        mNickName.set(nickName);
        mLastMessage.set(lastMessage);
        return this;
    }

    public void onFansClick(View view) {
        Toast.makeText(mActivity, mLastMessage.get(), Toast.LENGTH_LONG).show();
    }
}

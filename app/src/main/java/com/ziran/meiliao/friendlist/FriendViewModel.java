package com.ziran.meiliao.friendlist;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
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
public class FriendViewModel extends ListItemViewModel<FriendListActivity> {

    public ObservableInt mHeadImgResId = new ObservableInt();

    public ObservableField<String> mNickName = new ObservableField<>();

    public ObservableField<String> mLastMessage = new ObservableField<>();

    public FriendViewModel(FriendListActivity activity) {
        super(activity);
    }

    public FriendViewModel setData(int headImgResId, String nickName, String lastMessage) {
        mHeadImgResId.set(headImgResId);
        mNickName.set(nickName);
        mLastMessage.set(lastMessage);
        return this;
    }

    public void onFriendClick(View view) {
        Toast.makeText(mActivity, mLastMessage.get(), Toast.LENGTH_LONG).show();
    }
}

package com.ziran.meiliao.chatlist;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.ziran.meiliao.BR;
import com.ziran.meiliao.base.MultiTypeListItemViewModel;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class MessageViewModel extends MultiTypeListItemViewModel<ChatListActivity> {

    public ObservableInt mHeadImgResId = new ObservableInt();

    public ObservableField<String> mNickName = new ObservableField<>();

    public ObservableField<String> mMessage = new ObservableField<>();

    public MessageViewModel(ChatListActivity activity) {
        super(activity);
    }

    @Override
    public int variableId() {
        return BR.messageViewModel;
    }

    public MessageViewModel setData(int type, int headImgResId, String nickName, String lastMessage) {
        mType = type;
        mHeadImgResId.set(headImgResId);
        mNickName.set(nickName);
        mMessage.set(lastMessage);
        return this;
    }
}

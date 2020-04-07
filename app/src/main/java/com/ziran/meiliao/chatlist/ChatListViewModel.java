package com.ziran.meiliao.chatlist;

import android.databinding.ObservableField;
import android.util.SparseIntArray;

import com.ziran.meiliao.R;
import com.ziran.meiliao.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class ChatListViewModel extends BaseViewModel<ChatListActivity> {

    public static final int TYPE_MESSAGE_LEFT = 101;
    public static final int TYPE_MESSAGE_RIGHT = 102;

    public ObservableField<List<MessageViewModel>> mChatListViewModel = new ObservableField<>();

    public ObservableField<SparseIntArray> mLayoutMapping = new ObservableField<>();

    public ChatListViewModel(ChatListActivity activity) {
        super(activity);
    }

    public void loadChatList() {
        SparseIntArray sia = new SparseIntArray();
        sia.put(TYPE_MESSAGE_LEFT, R.layout.list_item_message_left);
        sia.put(TYPE_MESSAGE_RIGHT, R.layout.list_item_message_right);
        mLayoutMapping.set(sia);

        List<MessageViewModel> message = new ArrayList<>();
        message.addAll(requestData());
        mChatListViewModel.set(message);
    }

    private List<MessageViewModel> requestData() {
        List<MessageViewModel> data = new ArrayList<>();
        data.add(new MessageViewModel(mActivity).setData(TYPE_MESSAGE_LEFT, R.drawable.head_image_01, "张婧", "哈喽~"));
        data.add(new MessageViewModel(mActivity).setData(TYPE_MESSAGE_RIGHT, R.drawable.head_image_02, "王琳琳", "干嘛呀"));
        data.add(new MessageViewModel(mActivity).setData(TYPE_MESSAGE_LEFT, R.drawable.head_image_01, "张婧", "周末有空不？"));
        data.add(new MessageViewModel(mActivity).setData(TYPE_MESSAGE_RIGHT, R.drawable.head_image_02, "王琳琳", "有啊"));
        data.add(new MessageViewModel(mActivity).setData(TYPE_MESSAGE_RIGHT, R.drawable.head_image_02, "王琳琳", "要请我吃饭嘛^_^"));
        data.add(new MessageViewModel(mActivity).setData(TYPE_MESSAGE_LEFT, R.drawable.head_image_01, "张婧", "正有此意"));
        data.add(new MessageViewModel(mActivity).setData(TYPE_MESSAGE_LEFT, R.drawable.head_image_01, "张婧", "学校旁友刚开了个pizza店，据说味道还不错，要不要去尝尝"));
        data.add(new MessageViewModel(mActivity).setData(TYPE_MESSAGE_RIGHT, R.drawable.head_image_02, "王琳琳", "你请客什么都好说"));
        data.add(new MessageViewModel(mActivity).setData(TYPE_MESSAGE_LEFT, R.drawable.head_image_01, "张婧", "好哒~"));
        data.add(new MessageViewModel(mActivity).setData(TYPE_MESSAGE_RIGHT, R.drawable.head_image_02, "王琳琳", "爱你"));
        data.add(new MessageViewModel(mActivity).setData(TYPE_MESSAGE_RIGHT, R.drawable.head_image_02, "王琳琳", "么么哒~"));
        data.add(new MessageViewModel(mActivity).setData(TYPE_MESSAGE_LEFT, R.drawable.head_image_01, "张婧", ">_>"));
        return data;
    }

    @Override
    public void clear() {

    }
}
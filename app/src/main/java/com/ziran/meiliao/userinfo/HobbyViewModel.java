package com.ziran.meiliao.userinfo;

import android.databinding.ObservableField;

import com.ziran.meiliao.base.ListItemViewModel;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class HobbyViewModel extends ListItemViewModel<UserInfoActivity> {

    public ObservableField<String> hobby = new ObservableField<>();

    public HobbyViewModel(UserInfoActivity activity) {
        super(activity);
    }

    public HobbyViewModel(UserInfoActivity activity, String hobby) {
        super(activity);
        this.hobby.set(hobby);
    }

    public void setValue(String hobby) {
        this.hobby.set(hobby);
    }
}

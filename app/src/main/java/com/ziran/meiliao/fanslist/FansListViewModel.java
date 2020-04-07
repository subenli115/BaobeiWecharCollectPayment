package com.ziran.meiliao.fanslist;

import android.databinding.ObservableField;

import com.ziran.meiliao.base.BaseViewModel;
import com.ziran.meiliao.http.bean.FansBean;
import com.ziran.meiliao.http.exception.OverTimeException;
import com.ziran.meiliao.http.exception.ResponseErrorException;
import com.ziran.meiliao.http.model.FansListModel;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.functions.Action0;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class FansListViewModel extends BaseViewModel<FansListActivity> {

    public ObservableField<List<FansViewModel>> mFansListViewModel = new ObservableField<>();

    private FansListModel mFansListModel = new FansListModel();

    public FansListViewModel(FansListActivity activity) {
        super(activity);
    }

    public void loadFansList() {
        mFansListModel.requestFansList(new Action0() {
            @Override
            public void call() {
                // showLoadingView();
            }
        }, new Subscriber<List<FansBean>>() {
            @Override
            public void onCompleted() {
                // finishLoadingView();
            }

            @Override
            public void onError(Throwable e) {
                if (e instanceof OverTimeException) {
                    mActivity.showToast("");
                } else if (e instanceof ResponseErrorException) {
                    mActivity.showToast("");
                } else {
                    mActivity.showToast("服务器连接失败，请稍后再试~");
                }
                // finishLoadingView();
            }

            @Override
            public void onNext(List<FansBean> fansList) {
                if (fansList == null) {
                    return;
                }

                List<FansViewModel> fansViewModelList = new ArrayList<>();
                for (FansBean bean : fansList) {
                    FansViewModel fansViewModel = new FansViewModel(mActivity);
                    fansViewModel.setData(bean.getImgUrl(), bean.getNickName(), bean.getLastMessage());
                    fansViewModelList.add(fansViewModel);
                }
                mFansListViewModel.set(fansViewModelList);
            }
        });
    }

    @Override
    public void clear() {
        mFansListModel.cancelRequest();
    }
}
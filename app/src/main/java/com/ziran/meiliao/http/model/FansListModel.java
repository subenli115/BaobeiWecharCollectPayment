package com.ziran.meiliao.http.model;

import com.ziran.meiliao.http.HttpRequestFunc;
import com.ziran.meiliao.http.RetrofitManager;
import com.ziran.meiliao.http.RxTransformer;
import com.ziran.meiliao.http.bean.FansBean;
import com.ziran.meiliao.http.service.FansListService;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public class FansListModel {

    Subscription mFansListSubscription;

    FansListService mFansListService = RetrofitManager.getInstance().getDefaultRetrofit().create(FansListService.class);

    public void requestFansList(Action0 preAction, Subscriber<List<FansBean>> subscriber) {
        mFansListSubscription = mFansListService.requestFansList()
                .map(new HttpRequestFunc<List<FansBean>>())
                .compose(RxTransformer.<List<FansBean>>applyIoTransformer())
                .doOnSubscribe(preAction)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void cancelRequest() {
        if (mFansListSubscription != null && !mFansListSubscription.isUnsubscribed()) {
            mFansListSubscription.unsubscribe();
        }
    }
}

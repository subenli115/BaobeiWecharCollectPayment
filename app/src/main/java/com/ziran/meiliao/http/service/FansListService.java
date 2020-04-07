package com.ziran.meiliao.http.service;

import com.ziran.meiliao.http.HttpResponse;
import com.ziran.meiliao.http.bean.FansBean;

import java.util.List;

import retrofit2.http.POST;
import rx.Observable;

/**
 * 类说明
 *
 * @author renjialiang
 * @version [版本]
 * @see [相关类]
 * @since [模块]
 */
public interface FansListService {

    @POST("testFriendList.do")
    public Observable<HttpResponse<List<FansBean>>> requestFansList();
}

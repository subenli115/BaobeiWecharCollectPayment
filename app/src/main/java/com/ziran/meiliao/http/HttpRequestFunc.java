package com.ziran.meiliao.http;

import com.ziran.meiliao.http.exception.OverTimeException;
import com.ziran.meiliao.http.exception.ResponseErrorException;
import com.ziran.meiliao.util.UrlsFiled;

import rx.functions.Func1;

/**
 * Created by seph_von on 2018/3/25.
 */

public class HttpRequestFunc<T> implements Func1<HttpResponse<T>,T> {
    @Override
    public T call(HttpResponse<T> tHttpResponse) {
        if(UrlsFiled.RESPONSE_SUCCESS.equals(tHttpResponse.getCode())){
            return tHttpResponse.getContent();
        }else if(UrlsFiled.RESPONSE_OVER_TIME.equals(tHttpResponse.getCode())){
            throw new OverTimeException(tHttpResponse.getCode());
        }else{
            throw new ResponseErrorException(tHttpResponse.getCode(),tHttpResponse.getDesc());
        }
    }
}
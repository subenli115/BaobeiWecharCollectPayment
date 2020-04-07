package com.ziran.meiliao.http.exception;

/**
 * Created by seph_von on 2018/3/25.
 */

public class ResponseErrorException extends RuntimeException {

    private String code;

    public ResponseErrorException(String code ,String desc){
        super(desc);
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

}

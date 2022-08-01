package com.zbx.rilsy.common.res;

import cn.hutool.core.date.DateUtil;
import com.zbx.rilsy.common.status.Status;
import lombok.Data;

/**
 * @author zbx
 * @date 2022/8/1
 * @describe
 **/
@Data
public class Result<T> {

    private int code;

    private String msg;

    private T data;

    private long time = DateUtil.currentSeconds();

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {
        return ofStatus(Status.SUCCESS, data);
    }

    public static <T> Result<T> failed() {
        return failed(null);
    }

    public static <T> Result<T> failed(T data) {
        return ofStatus(Status.FAILED, data);
    }

    public static <T> Result<T> error() {
        return error(null);
    }

    public static <T> Result<T> error(T data) {
        return ofStatus(Status.ERROR, data);
    }

    public static <T> Result<T> ofStatus(Status statusCode) {
        return ofStatus(statusCode,null);
    }

    public static <T> Result<T> ofStatus(Status statusCode, T data) {
        return new Result<>(statusCode.getCode(), statusCode.getMsg(), data);
    }
}

package com.zbx.rilsy.common.exception;

import com.zbx.rilsy.common.status.Status;
import lombok.Getter;

/**
 * @author zbx
 * @date 2022/8/1
 * @describe
 **/
@Getter
public class BaseException extends RuntimeException{

    private final Status status;

    public BaseException(Status status) {
        super(status.getMsg());
        this.status = status;
    }

}

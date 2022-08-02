package com.zbx.rilsy.config.exception;

import com.zbx.rilsy.common.exception.BaseException;
import com.zbx.rilsy.common.res.Result;
import com.zbx.rilsy.common.status.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.util.List;

/**
 * @author zbx
 * @date 2022/7/19
 * @describe
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 基类异常处理
    @ExceptionHandler(BaseException.class)
    public Result<?> handlerException(BaseException e) {
        return Result.ofStatus(e.getStatus());
    }

    @ExceptionHandler(BindException.class)
    public Result<?> handlerException(BindException e) {
        List<FieldError> allErrors = e.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError errorMessage : allErrors) {
            sb.append(errorMessage.getDefaultMessage()).append(" ");
            log.info("参数校验错误: {} => {}", errorMessage.getField(), errorMessage.getDefaultMessage());
        }
        return Result.ofStatus(Status.PARAM_ERROR, sb.toString());
    }

    @ExceptionHandler(ValidationException.class)
    public Result<?> handlerException(ValidationException e) {
        log.info("参数校验错误: {}", e.getMessage());
        return Result.ofStatus(Status.PARAM_ERROR, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<?> handlerException(Exception e) {
        return Result.ofStatus(Status.FAILED, e.getMessage());
    }
}

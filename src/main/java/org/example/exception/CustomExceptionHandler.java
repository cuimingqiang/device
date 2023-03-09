package org.example.exception;


import org.example.base.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理类
 */
@ControllerAdvice
public class CustomExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResult handle(Exception e) {
        logger.error("[ 系统异常 ]{}", e.getMessage());
        if (e instanceof HttpException) {
            HttpException xdException = (HttpException) e;
            return BaseResult.error(xdException.getCode(), xdException.getMsg());

        } else {
            return BaseResult.error("全局异常，未知错误");
        }
    }

}

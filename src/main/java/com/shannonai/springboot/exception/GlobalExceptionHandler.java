package com.shannonai.springboot.exception;

import com.shannonai.springboot.base.tips.ErrorTip;
import com.shannonai.springboot.base.tips.ExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @author ligang
 * @date 2020年10月09日 下午3:19:56
 */
@RestController
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler implements ErrorController {

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ErrorTip notFount(Exception e) {
        if (e instanceof NoHandlerFoundException) {
            return new ErrorTip(ExceptionEnum.EXCEPTION_ERROR_400.getCode(), ExceptionEnum.EXCEPTION_ERROR_400.getMessage());
        }
        if (e instanceof RspException) {
            return new ErrorTip(ExceptionEnum.EXCEPTION_ERROR_400.getCode(), e.getMessage());
        }
        log.error(e.getMessage(), e);
        return new ErrorTip(ExceptionEnum.EXCEPTION_ERROR_500.getCode(), ExceptionEnum.EXCEPTION_ERROR_500.getMessage());
    }

    @Override
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return "/error";
    }

    @RequestMapping("/error")
    @ResponseBody
    public Object handlerError(){
        return new ErrorTip(ExceptionEnum.EXCEPTION_ERROR_404.getCode(), ExceptionEnum.EXCEPTION_ERROR_404.getMessage());
    }

}

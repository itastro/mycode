package cn.shengrui.common.handle;

import cn.shengrui.common.beans.JsonResult;
import cn.shengrui.common.exception.ParamException;
import cn.shengrui.common.exception.PermissionException;
import cn.shengrui.common.exception.SystemException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public JsonResult handlerException(Exception ex) throws Exception {
        if (ex instanceof UnknownAccountException) {
            return JsonResult.build(500, "用户名或者密码错误", "UnknownAccountException");
        } else if (ex instanceof UnauthorizedException) {
            return JsonResult.build(301, "无此权限,请联系管理员", "UnauthorizedException");
        } else if (ex instanceof SystemException) {
            SystemException systemException = (SystemException) ex;
            return JsonResult.build(systemException.getCode(), systemException.getMessage(), "UnauthorizedException");
        } else {
            throw new Exception();
        }

    }


    @ExceptionHandler(PermissionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handlerPermissionException(PermissionException ex) {
        return JsonResult.build(ex.getCode(), ex.getMessage(), "permissionException");
    }


    @ExceptionHandler(ParamException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handlerParamException(ParamException ex) {

        return JsonResult.build(ex.getCode(), ex.getMessage(), "paramException");
    }

    @ExceptionHandler(SystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handlerParamException(SystemException ex) {

        return JsonResult.build(ex.getCode(), ex.getMessage(), "systemException");
    }

}

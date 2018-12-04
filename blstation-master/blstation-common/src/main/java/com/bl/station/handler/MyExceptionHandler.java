package com.bl.station.handler;


import com.bl.station.exception.CustomException;
import com.bl.station.exception.ParamException;
import com.bl.station.exception.PermissionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {

  @ExceptionHandler(CustomException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

  public Map<String, Object> handlerCustomException(CustomException ex) {
      Map<String,Object> result = new HashMap<>();

      result.put("message", ex.getMessage());
      result.put("error type", "MyException");
      return result;
  }


    @ExceptionHandler(PermissionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerPermissionException(PermissionException ex) {
        Map<String,Object> result = new HashMap<>();
        result.put("message", ex.getMessage());
        result.put("error type", "PermissionException");
        return result;
    }


    @ExceptionHandler(ParamException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerParamException(ParamException ex) {

        Map<String,Object> result = new HashMap<>();
        result.put("message", ex.getMessage());
        result.put("error type", "ParamException");
        return result;
    }

}

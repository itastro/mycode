package cn.shengrui.common.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName ErrorResult
 * @Description 错误异常结果集
 * @Date 2018/10/10 15:35
 * @Author itastro
 * @Version 1.0
 **/

@Getter
@Setter
@AllArgsConstructor
public class ErrorResult<T> {

    private Integer code;

    private String msg;

    private T data;


    /**
     * 错误返回结果集
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static  ErrorResult errorResult(Integer code,String msg,Object data){

        return new ErrorResult(code,msg,data);

    }






}

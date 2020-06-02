package com.atguigu.springcloud.entities;

/**
 * @author baijunguang
 * @date 2020/5/25-12:11
 */
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T      data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String message, T data){
        this.code = code;
        this.message= message;
        this.data = data;
    }
    public CommonResult(Integer code, String message){
       this(code,message,null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

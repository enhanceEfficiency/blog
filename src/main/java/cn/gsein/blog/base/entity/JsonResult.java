package cn.gsein.blog.base.entity;

import java.io.Serializable;

/**
 * Created by G.Seinfeld on 2017/5/18.
 * 用于处理前台请求，以json数据的形式给前台反馈
 */
public class JsonResult<T> implements Serializable{

    /**
     * 返回状态码
     */
    private String code;
    /**
     * 返回状态信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
        return "JsonResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

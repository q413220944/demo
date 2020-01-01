package com.djfy.demo.model;

/**
 * 响应请求状态枚举类 FaceInterfaceEnum
 *
 * @author guochao
 * @since 1.0.0
 */
public enum CodeMessageEnum {
    /**
     *
     */
    OK(200, "操作成功"),
    /**
     *
     */
    ERROR(500, "操作失败"),
    /**
     *
     */
    UNBIND(4001, "用户未绑定"),
    /**
     *
     */
    AUTH(401, "身份验证错误");

    private Integer code;
    private String msg;

    CodeMessageEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}

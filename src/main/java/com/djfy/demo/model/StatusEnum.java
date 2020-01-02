package com.djfy.demo.model;

/**
 * 状态枚举类
 * @author QuinPluto
 */

public enum StatusEnum {
    /**
     *
     */
    NORMAL(1, "正常"),
    /**
     *
     */
    PENDING(0, "待审核"),
    /**
     *
     */
    REJECT(2, "已驳回");

    private Integer code;
    private String msg;

    StatusEnum(Integer code, String msg) {
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

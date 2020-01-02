package com.djfy.demo.model;

import lombok.Data;

/**
 * @author QuinPluto
 */

@Data
public class Result {

    private Integer code;
    private String msg;
    private Object data;
    private Long count;

    private Result(Integer code, String msg, Object data, Long count){
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    private Result(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static Result buildOk(){
        return new Result(CodeMessageEnum.OK.code(), CodeMessageEnum.OK.msg());
    }

    public static Result buildOk(String msg){
        return new Result(CodeMessageEnum.OK.code(), msg);
    }

    public static Result buildOk(Object data){
        return new Result(CodeMessageEnum.OK.code(),CodeMessageEnum.OK.msg(), data,null);
    }

    public static Result buildOk(Object data, Long count){
        return new Result(CodeMessageEnum.OK.code(), CodeMessageEnum.OK.msg(), data, count);
    }

    public static Result buildError(){
        return new Result(CodeMessageEnum.ERROR.code(), CodeMessageEnum.ERROR.msg());
    }

    public static Result buildError(String msg){
        return new Result(CodeMessageEnum.ERROR.code(), msg);
    }

    public static Result bindError(){
        return new Result(CodeMessageEnum.UNBIND.code(), CodeMessageEnum.UNBIND.msg());
    }
    public static Result AuthError(){
        return new Result(CodeMessageEnum.AUTH.code(), CodeMessageEnum.AUTH.msg());
    }

}

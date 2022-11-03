package com.hyn.mybatisplus.generator.entity;

import com.hyn.mybatisplus.generator.entity.params.PageParams;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ：Polarbear
 * @date ：Created 2022/11/2 16:07
 * @description：
 */
@Data
@AllArgsConstructor
public class Result {
    private boolean success;
    private int code;
    private String msg;
    private Object data;


    public static Result success(Object data){
        return new Result(true,200,"success",data);
    }

    public static Result fail (int code,String msg){
        return new Result(false,code,msg,null);
    }
}

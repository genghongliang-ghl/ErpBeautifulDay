package com.erp.vo;

import lombok.Data;

/**
 * @author : Du
 * @date : 2019/8/24 22:09
 * @description :
 */
@Data
public class Result {
    private Integer status;
    private String msg;
    private Object data;
    private Object dataList;

    public Result() {

    }

    public Result(Integer status) {
        this.status = status;
    }

    public Result(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Result(Integer status, String msg, Object data,Object dataList) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.dataList=dataList;
    }
    public Result(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;

    }
}

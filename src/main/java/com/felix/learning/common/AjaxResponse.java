package com.felix.learning.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("响应")
public class AjaxResponse {
    /**
     * 成功
     */
    public static final int SUCCESS = 0;
    public static final String SUCCESS_MSG = "success";
    /**
     * 失败
     */
    public static final int FAIL = -1;
    public static final String FAIL_MSG = "fail";
    /**
     * 响应码
     */
    @ApiModelProperty("响应码")
    private int code;
    /**
     * 响应描述
     */
    @ApiModelProperty("响应描述")
    private String msg;
    /**
     * 响应数据
     */
    @ApiModelProperty("响应数据")
    private Object data;

    public static <T> AjaxResponse success() {
        AjaxResponse response = new AjaxResponse();
        response.setCode(SUCCESS);
        response.setMsg(SUCCESS_MSG);
        return response;
    }

    public static <T> AjaxResponse success(T data) {
        AjaxResponse response = new AjaxResponse();
        response.setCode(SUCCESS);
        response.setMsg(SUCCESS_MSG);
        response.setData(data);
        return response;
    }

    public static <T> AjaxResponse success(List<T> data) {
        AjaxResponse response = new AjaxResponse();
        response.setCode(SUCCESS);
        response.setMsg(SUCCESS_MSG);
        response.setData(data);
        return response;
    }

    public static <T> AjaxResponse fail() {
        AjaxResponse response = new AjaxResponse();
        response.setCode(FAIL);
        response.setMsg(FAIL_MSG);
        return response;
    }
}

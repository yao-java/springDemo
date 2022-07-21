package com.test.eum;

import com.test.service.StatusCode;
import lombok.Getter;

/**
 * @author yao
 * @description
 * @date 2022-07-06 15:25
 */
@Getter
public enum ResultCode implements StatusCode {
    SUCCESS(0, "请求成功"),
    FAILED(1001, "请求失败"),
    VALIDATE_ERROR(1002, "参数校验失败"),
    RESPONSE_PACK_ERROR(1003, "response返回包装失败");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

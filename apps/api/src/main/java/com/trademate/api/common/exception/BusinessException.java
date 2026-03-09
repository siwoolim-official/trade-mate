package com.trademate.api.common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private  final  int status; // HTTP 상태코드: 400, 404 등

    public BusinessException(int status, String message) {
        super(message);
        this.status = status;
    }

}

package com.trademate.api.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // BusinessException 발생시 처리
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
        ErrorResponse response = ErrorResponse.of(e.getStatus(), e.getMessage());

        return ResponseEntity.status(e.getStatus()).body(response);
    }

    // 그 외 에러 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("서버에 예상치 못한 에러 발생: ", e);
        ErrorResponse response = ErrorResponse.of(500, "서버에 일시적인 문제가 발생했습니다.");

        return ResponseEntity.status(500).body(response);
    }
}

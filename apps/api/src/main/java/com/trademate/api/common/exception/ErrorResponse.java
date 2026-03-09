package com.trademate.api.common.exception;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public record ErrorResponse(
        int status,             // HTTP 상태코드: 400, 404, 500
        String message,         // 에러 설명
        OffsetDateTime time     // 에러가 발생한 시간
) {
    public static ErrorResponse of(int status, String message) {
        return new ErrorResponse(status, message, OffsetDateTime.now(ZoneOffset.UTC));
    }
}

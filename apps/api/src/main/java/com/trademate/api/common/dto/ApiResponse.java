package com.trademate.api.common.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponse<T> {
    private boolean success;    // 성공 여부 (true/false)
    private String message;     // 사용자에게 보여줄 메시지
    private T data;             // 실제 데이터
    private String errorCode;    // 에러 발생시 식별 코드

    // 반환 데이터가 있는 성공 응답
    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .message("요청이 성공적으로 처리되었습니다.")
                .data(data)
                .build();
    }

    // 반환 데이터가 없는 성공 응답
    public static <T> ApiResponse<T> success() {
        return ApiResponse.<T>builder()
                .success(true)
                .message("요청이 성공적으로 처리되었습니다.")
                .build();
    }

    // 에러가 발생했을때 응답
    public static <T> ApiResponse<T> error(String errorCode, String message) {
        return ApiResponse.<T>builder()
                .success(false)
                .errorCode(errorCode)
                .message(message)
                .build();
    }
}

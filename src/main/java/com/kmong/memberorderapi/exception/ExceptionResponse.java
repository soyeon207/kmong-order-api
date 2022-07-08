package com.kmong.memberorderapi.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExceptionResponse {
    int statusCode;  // 상태 코드
    String message;     // 오류 메시지
}
package com.kmong.memberorderapi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JwtTokenInfo {
    String accessToken;
    String refreshToken;
}

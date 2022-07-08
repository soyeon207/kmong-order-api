package com.kmong.memberorderapi.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class OrderCreateRequest {

    @NotNull(message = "회원 아이디는 필수값입니다.")
    private Long memberId;

    @NotNull(message = "상품 아이디는 필수값입니다.")
    private Long productId;

}

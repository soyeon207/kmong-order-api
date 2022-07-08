package com.kmong.memberorderapi.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
public class MemberLoginRequest {
    @Email
    @NotNull(message = "이메일은 필수값입니다.")
    protected String email;

    @NotNull(message = "비밀번호는 필수값입니다.")
    protected String password;
}

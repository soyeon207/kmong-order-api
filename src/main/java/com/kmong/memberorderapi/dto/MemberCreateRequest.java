package com.kmong.memberorderapi.dto;

import com.kmong.memberorderapi.enumeration.UserRole;
import lombok.Getter;

import java.util.Optional;

@Getter
public class MemberCreateRequest extends MemberLoginRequest {

    protected UserRole userRole;

    protected String name;

    protected String phone;

    public UserRole convertUserRole() {
        return Optional.ofNullable(this.getUserRole()).orElse(UserRole.USER);
    }

}

package com.kmong.memberorderapi.dto;

import com.kmong.memberorderapi.enumeration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MembersDto {
    protected Long id;
    protected UserRole userRole;
    protected String email;
//    protected String password; -> 보안 상 노출하지 않음
    protected String name;
    protected String phone;
}

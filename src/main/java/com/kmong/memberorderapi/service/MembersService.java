package com.kmong.memberorderapi.service;

import com.kmong.memberorderapi.dto.MemberCreateRequest;
import com.kmong.memberorderapi.dto.MemberLoginRequest;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface MembersService {

    ResponseEntity<?> createMember(MemberCreateRequest memberCreateRequest);

    ResponseEntity<?> login(MemberLoginRequest memberLoginRequest);

    ResponseEntity<?> logout(HttpServletRequest httpServletRequest);

    ResponseEntity<?> getOrdersByMember(Long memberId);

}

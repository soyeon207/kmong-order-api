package com.kmong.memberorderapi.service;

import com.kmong.memberorderapi.dto.MemberCreateRequest;
import com.kmong.memberorderapi.dto.MemberLoginRequest;
import org.springframework.http.ResponseEntity;

public interface MembersService {

    ResponseEntity<?> createMember(MemberCreateRequest memberCreateRequest);

    ResponseEntity<?> login(MemberLoginRequest memberLoginRequest);

}

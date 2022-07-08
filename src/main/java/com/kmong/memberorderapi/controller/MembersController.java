package com.kmong.memberorderapi.controller;

import com.kmong.memberorderapi.dto.MemberCreateRequest;
import com.kmong.memberorderapi.dto.MemberLoginRequest;
import com.kmong.memberorderapi.service.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MembersController {

    private final MembersService membersService;

    @PostMapping
    public ResponseEntity<?> createMember(@Valid @RequestBody MemberCreateRequest memberCreateRequest) {
        return membersService.createMember(memberCreateRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody MemberLoginRequest memberLoginRequest) {
        return membersService.login(memberLoginRequest);
    }


}

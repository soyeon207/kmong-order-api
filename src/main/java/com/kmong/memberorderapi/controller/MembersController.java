package com.kmong.memberorderapi.controller;

import com.kmong.memberorderapi.dto.MemberCreateRequest;
import com.kmong.memberorderapi.dto.MemberLoginRequest;
import com.kmong.memberorderapi.service.MembersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MembersController {

    private final MembersService membersService;

    @PostMapping
    @Operation(summary = "회원가입 API")
    public ResponseEntity<?> createMember(@Valid @RequestBody MemberCreateRequest memberCreateRequest) {
        return membersService.createMember(memberCreateRequest);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인 API")
    public ResponseEntity<?> login(@Valid @RequestBody MemberLoginRequest memberLoginRequest) {
        return membersService.login(memberLoginRequest);
    }

    @PostMapping("/logout")
    @PreAuthorize("isAuthenticated()")
    @Operation(summary = "로그아웃 API")
    public ResponseEntity<?> logout(HttpServletRequest httpServletRequest) {
        return membersService.logout(httpServletRequest);
    }

    @GetMapping("/{memberId}/orders")
    @PreAuthorize("isAuthenticated()")
    @Operation(summary = "회원 주문 내역 조회 API")
    public ResponseEntity<?> getOrdersByMember(@PathVariable Long memberId) {
        return membersService.getOrdersByMember(memberId);
    }

}


package com.kmong.memberorderapi.service.impl;

import com.kmong.memberorderapi.config.JwtConfig;
import com.kmong.memberorderapi.dto.JwtTokenInfo;
import com.kmong.memberorderapi.dto.MemberCreateRequest;
import com.kmong.memberorderapi.dto.MemberLoginRequest;
import com.kmong.memberorderapi.dto.ResponseDto;
import com.kmong.memberorderapi.entity.Members;
import com.kmong.memberorderapi.mapper.MemberMapper;
import com.kmong.memberorderapi.repository.MembersRepository;
import com.kmong.memberorderapi.service.MembersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MembersServiceImpl implements MembersService {

    private final JwtConfig jwtConfig;
    private final MemberMapper memberMapper;
    private final MembersRepository membersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ResponseEntity<?> createMember(MemberCreateRequest memberCreateRequest) {
        Members members = membersRepository.save(Members
                .builder()
                .userRole(memberCreateRequest.convertUserRole())
                .email(memberCreateRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(memberCreateRequest.getPassword()))
                .name(memberCreateRequest.getName())
                .phone(memberCreateRequest.getPhone())
                .build());

        return ResponseDto.success(memberMapper.toDto(members), "회원가입 성공");
    }

    @Override
    public ResponseEntity<?> login(MemberLoginRequest memberLoginRequest) {
        Members members = Optional
                .ofNullable(membersRepository.findByEmail(memberLoginRequest.getEmail()))
                .orElseThrow(() -> new BadCredentialsException("존재하지 않는 회원입니다. 이메일을 다시 확인해주세요."));

        if (!bCryptPasswordEncoder.matches(memberLoginRequest.getPassword(), members.getPassword())) {
            throw new BadCredentialsException("비밀번호를 확인해주세요.");
        }

        JwtTokenInfo jwtTokenInfo = jwtConfig.createToken(members.getEmail(), Collections.singletonList(members.getUserRole().toString()));
        return ResponseDto.success(jwtTokenInfo, "로그인 성공");
    }

}

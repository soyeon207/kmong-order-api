package com.kmong.memberorderapi.config;

import com.kmong.memberorderapi.dto.JwtTokenInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtConfig {

    private final StringRedisTemplate stringRedisTemplate;

    private static final String ROLES_KEY = "roles";
    private static final String JWT_HEADER_KEY = "Authorization";

    @Value("${JWT_TOKEN}")
    private String secretKey;

    @Value("${JWT_EXPIRE_TIME}")
    private long expireTime;

    @Value("${JWT_REFRESH_TIME}")
    private long refreshTime;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public JwtTokenInfo createToken(String userEmail, List<String> roleList) {
        // JWT payload 에 저장되는 정보단위
        Claims claims = Jwts.claims().setSubject(userEmail);
        claims.put(ROLES_KEY, roleList);

        Date now = new Date();
        String accessToken = Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + expireTime)) // set Expire Time
                .signWith(SignatureAlgorithm.HS256, secretKey)  // 사용할 암호화 알고리즘과 signature 에 들어갈 secret값 세팅
                .compact();

        String refreshToken = Jwts.builder()
                .setExpiration(new Date(now.getTime() + refreshTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return JwtTokenInfo
                .builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    // JWT 토큰에서 인증 정보 조회
    public Authentication getAuthentication(String token) {
        Claims claims = Jwts
                .parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        Collection<? extends GrantedAuthority> authorities = Optional
                .ofNullable(claims.get(ROLES_KEY))
                .stream()
                .map(Object::toString)
                .map(b->b.replace("[", ""))
                .map(c->c.replace("]", ""))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        UserDetails principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    // Request의 Header에서 token 값을 가져옴 "Authorization" : "Bearer TOKEN값'
    public String resolveToken(HttpServletRequest request) {
        return Optional
                .ofNullable(request.getHeader(JWT_HEADER_KEY))
                .map(token->token.substring("Bearer ".length()))
                .orElse(null);
    }

    // 토큰의 유효성 + 만료일자 확인
    public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(jwtToken);

            return !claims.getBody().getExpiration().before(new Date()) && stringRedisTemplate.opsForValue().get(jwtToken) == null;
        } catch (Exception e) {
            return false;
        }
    }

}
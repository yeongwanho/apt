package com.project.apt.service;

import com.project.apt.dto.LoginForm;
import com.project.apt.entity.Member;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Component
@Slf4j
public class JwtService {
    private String code="apt";
    public String create(Member member){
        JwtBuilder builder = Jwts.builder();
        builder.setHeaderParam("type","JWT");
        builder.setSubject("로그인토큰")
                .setExpiration(new Date(System.currentTimeMillis() +1000*60 *5))// 유효시간
                .claim("User",member);
        builder.signWith(SignatureAlgorithm.HS256,code.getBytes());
        String token = builder.compact();
        System.out.println(token);
        return token;
    }
    public void checkValid(String jwt){
        try{
        Jwts.parser().setSigningKey(code.getBytes()).parseClaimsJws(jwt);
        }catch (Exception e){
            log.trace(e.getMessage());
        }

    }
    public Map<String,Object> get(String jwt){
        Jws<Claims> claimsJws =null;
        try {
            claimsJws=Jwts.parser().setSigningKey(code.getBytes()).parseClaimsJws(jwt);
        }catch (Exception e){
            throw new RuntimeException();
        }
        return claimsJws.getBody();

    }

}

package com.project.apt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.apt.entity.Member;
import com.project.apt.service.JwtService;
import com.project.apt.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    private final JwtService jwtService;

    private ObjectMapper objectMapper = new ObjectMapper();


    @PostMapping("/api/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody String login) throws JsonProcessingException {
        Member member = objectMapper.readValue(login, Member.class);
        Map<String,Object> resultMap= new HashMap<>();
        HttpStatus status= null;
        try {
            List<Member> members = memberService.loginMember(member);
            Member member1 = members.get(0);
            String token = jwtService.create(member1);
            resultMap.put("loginId",member1.getLoginId());
            resultMap.put("status",true);
            resultMap.put("data",member1);
            resultMap.put("token",token);
            status= HttpStatus.ACCEPTED;
            System.out.println(token);
        }catch (RuntimeException e){
            resultMap.put("message",e.getMessage());
            status=HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return  new ResponseEntity<Map<String,Object>>(resultMap,status);
    }

}

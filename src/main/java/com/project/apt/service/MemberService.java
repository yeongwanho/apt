package com.project.apt.service;

import com.project.apt.entity.Member;
import com.project.apt.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public List<Member> findAll(){
        List<Member> members = memberRepository.finAll();
        return members;
    }

    public List<Member> loginMember(Member member){
        List<Member> byLoginId = memberRepository.findByLoginId(member);
        System.out.println(byLoginId);
        if (byLoginId.isEmpty()){
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        return byLoginId;

    }

}

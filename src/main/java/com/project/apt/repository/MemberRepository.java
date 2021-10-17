package com.project.apt.repository;

import com.project.apt.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);

    }
    public Member findOne(Long id){
        return em.find(Member.class,id);
    }

    public List<Member> finAll(){
        return em.createQuery("select  m from Member m", Member.class).getResultList();
    }
    public List<Member> findByLoginId(Member member){
        return em.createQuery("select m from Member m where m.loginId=:loginId and m.password=:password",Member.class)
                .setParameter("loginId",member.getLoginId())
                .setParameter("password",member.getPassword())
                .getResultList();
    }
}

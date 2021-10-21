package com.project.apt.repository;

import com.project.apt.entity.Comments;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CommentRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    public CommentRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }
    public void save(Comments comments){
        em.persist(comments);
    }
}

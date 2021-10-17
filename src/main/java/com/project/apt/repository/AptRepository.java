package com.project.apt.repository;

import com.project.apt.entity.Apt;

import com.project.apt.entity.QApt;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AptRepository {

    private final JPAQueryFactory queryFactory;

    public AptRepository(EntityManager em){
        this.queryFactory= new JPAQueryFactory(em);
    }

    public Page<Apt> searchPage(Pageable pageable){
        QueryResults<Apt> results=queryFactory
                .select(QApt.apt)
                .from(QApt.apt)
                .orderBy(QApt.apt.cityL.desc())
                .groupBy(QApt.apt.aptName)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        List<Apt> content = results.getResults();
        long total = results.getTotal();
        return new PageImpl<>(content,pageable,total);
    }
    public Apt aptFindById(Long id){
        return queryFactory
                .selectFrom(QApt.apt)
                .where(QApt.apt.id.eq(id))
                .fetchOne();
    }
    public List<Apt> aptFindByName(String name){
        return queryFactory
                .selectFrom(QApt.apt)
                .where(QApt.apt.aptName.eq(name))
                .fetch();
    }

    public Page<Apt> searchApt(Apt apt,Pageable pageable){
        List<Apt> content = queryFactory
                .selectFrom(QApt.apt)
                .where(citylEq(apt.getCityL()), citymEq(apt.getCityM()), citysEq(apt.getCityS()))
                .orderBy(QApt.apt.cityL.desc())
                .groupBy(QApt.apt.aptName)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .selectFrom(QApt.apt)
                .where(citylEq(apt.getCityL()), citymEq(apt.getCityM()), citysEq(apt.getCityS()))
                .fetchCount();

        return new PageImpl<>(content,pageable,total);

    }

    private Predicate citylEq(String cityL) {
        System.out.println(cityL+"체크한번");
        System.out.println(cityL==null ? null :QApt.apt.cityL.eq(cityL));
        return cityL == null ? null :QApt.apt.cityL.eq(cityL);
    }

    private Predicate citymEq(String cityM) {

        System.out.println(cityM==null ? null :QApt.apt.cityM.eq(cityM));
        return cityM==null ? null :QApt.apt.cityM.eq(cityM);
    }

    private Predicate citysEq(String cityS) {
        return cityS== null ? null : QApt.apt.cityS.eq(cityS);
    }
}

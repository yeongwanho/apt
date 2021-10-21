package com.project.apt.repository;

import com.project.apt.dto.*;
import com.project.apt.entity.Apt;

import static com.project.apt.entity.QApt.apt;
import static com.project.apt.entity.QComments.comments;

import com.project.apt.entity.QApt;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AptRepository {

    private final JPAQueryFactory queryFactory;

    public AptRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public Page<AptQueryDto> searchPage(Pageable pageable) {
        QueryResults<AptQueryDto> results = queryFactory
                .select(new QAptQueryDto(
                        apt.id,
                        apt.aptName,
                        apt.cityL,
                        apt.cityM,
                        apt.cityS,
                        apt.aptRow,
                        apt.ContractDate,
                        apt.price
                ))
                .from(apt)
                .orderBy(apt.cityL.desc())
                .groupBy(apt.aptName)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        List<AptQueryDto> content = results.getResults();
        long total = results.getTotal();
        return new PageImpl<>(content, pageable, total);
    }

    public String aptFindById(Long id) {
        return queryFactory
                .select(apt.aptName)
                .from(QApt.apt)
                .where(QApt.apt.id.eq(id))
                .fetchOne();
    }

    public List<CommentQueryDto> aptFindByName(String name) {
        List<CommentQueryDto> results = queryFactory
                .select(
                        new QCommentQueryDto(
                                apt.id,
                                apt.aptName,
                                apt.ContractDate,
                                apt.price
                        )

                )
                .from(apt)
                .where(apt.aptName.eq(name))
                .fetch();

        List<Long> aptIds = results
                .stream().map(o -> o.getAptId())
                .collect(Collectors.toList());
        List<AptDtoComment> commentlist = queryFactory
                .select(
                        new QAptDtoComment(
                                apt.id,
                                comments.id,
                                comments.createDate,
                                comments.content,
                                comments.loginId
                        ))
                .from(comments)

                .where(apt.id.in(aptIds))
                .fetch();
        Map<Long, List<AptDtoComment>> commentMap = commentlist.stream()
                .collect(Collectors.groupingBy(AptDtoComment -> AptDtoComment.getAptId()));
        results.forEach(o -> o.setComments(commentMap.get(o.getAptId())));
        return results;

    }

    public Page<AptQueryDto> searchApt(Apt apts, Pageable pageable) {
        QueryResults<AptQueryDto> results = queryFactory
                .select(new QAptQueryDto(
                        apt.id,
                        apt.aptName,
                        apt.cityL,
                        apt.cityM,
                        apt.cityS,
                        apt.aptRow,
                        apt.ContractDate,
                        apt.price
                ))
                .from(apt)
                .where(citylEq(apts.getCityL()), citymEq(apts.getCityM()), citysEq(apts.getCityS()))
                .orderBy(apt.cityL.desc())
                .groupBy(apt.aptName)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<AptQueryDto> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);

    }

    private Predicate citylEq(String cityL) {

        return cityL == null ? null : QApt.apt.cityL.eq(cityL);
    }

    private Predicate citymEq(String cityM) {

        return cityM == null ? null : QApt.apt.cityM.eq(cityM);
    }

    private Predicate citysEq(String cityS) {
        return cityS == null ? null : QApt.apt.cityS.eq(cityS);
    }
}

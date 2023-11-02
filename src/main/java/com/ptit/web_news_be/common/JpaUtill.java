package com.ptit.web_news_be.common;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.HashMap;

public class JpaUtill {
    private static Query buildQuery(EntityManager em, StringBuilder sql, HashMap<String, Object> params, String mapClass, Pageable pageable){
        String sqlFinal;
        if (pageable == null) {
            sqlFinal = "SELECT COUNT(1) FROM (" + sql + ") a";
        } else {
            sql.append(" ORDER BY ");
            Sort sort = pageable.getSort();
            sort.forEach(val -> {
                sql.append(val.getProperty()).append(" ").append(val.getDirection().name()).append(",");
            });
            sql.deleteCharAt(sql.length() - 1);
            sqlFinal = sql.toString();
        }
        Query query = pageable != null ? em.createNativeQuery(sqlFinal, mapClass) : em.createNativeQuery(sqlFinal);
        if (pageable != null) {
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
            query.setMaxResults(pageable.getPageSize());
        }
        params.forEach(query::setParameter);
        return query;
    }

    private static Query buildQuery (EntityManager em, StringBuilder sql, HashMap<String, Object> params, Class mapClass, Pageable pageable){
        String sqlFinal;
        if (pageable == null) {
            sqlFinal = "SELECT COUNT(1) FROM (" + sql + ") a";
        } else {
            sql.append(" ORDER BY ");
            Sort sort = pageable.getSort();
            sort.forEach(val -> {
                sql.append(val.getProperty()).append(" ").append(val.getDirection().name()).append(",");
            });
            sql.deleteCharAt(sql.length() - 1);
            sqlFinal = sql.toString();
        }
        Query query = pageable != null ? em.createNativeQuery(sqlFinal, mapClass) : em.createNativeQuery(sqlFinal);
        if (pageable != null) {
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
            query.setMaxResults(pageable.getPageSize());
        }
        params.forEach(query::setParameter);
        return query;
    }

//    public static <T> PageImpl<T> getPageableResult (EntityManager em, StringBuilder sql, HashMap<String, Object> params, String mapClass, Pageable pageable) {
//        Query queryCount = buildQuery(em, sql, params, mapClass, null);
//        long countResult = queryCount.getSingleResult();
//    }
}

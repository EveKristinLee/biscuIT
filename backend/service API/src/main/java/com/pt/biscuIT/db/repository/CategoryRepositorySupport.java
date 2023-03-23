package com.pt.biscuIT.db.repository;

import com.pt.biscuIT.db.entity.Category;
import com.pt.biscuIT.db.entity.QCategory;
import com.pt.biscuIT.db.entity.QContent;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class CategoryRepositorySupport {
    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;
    QCategory qCategory = QCategory.category;
}

package com.viet.news.repository;


import com.viet.news.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * @Description
 * @Author lucio
 * @Email lucio0314@163.com
 * @Date
 * @Version
 */
@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

    List<T> findByDeleted(boolean deleted);

    Page<T> findByDeleted(boolean deleted, Pageable pageable);

    T findOneById(Long id);

}

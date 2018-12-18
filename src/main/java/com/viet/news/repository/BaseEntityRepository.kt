package com.viet.news.repository


import com.viet.news.entity.BaseEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

/**
 * @Description
 * @Author lucio
 * @Email lucio0314@163.com
 * @Date
 * @Version
 */
@NoRepositoryBean
interface BaseEntityRepository<T : BaseEntity> : JpaRepository<T, Long> {

    fun findByDeleted(deleted: Boolean): List<T>

    fun findByDeleted(deleted: Boolean, pageable: Pageable): Page<T>

    fun findOneById(id: Long?): T

}

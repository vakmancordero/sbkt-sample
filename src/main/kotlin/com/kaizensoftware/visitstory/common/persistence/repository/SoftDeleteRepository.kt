package com.kaizensoftware.visitstory.common.persistence.repository

import com.kaizensoftware.visitstory.common.persistence.model.BaseEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

import org.springframework.transaction.annotation.Transactional
import org.springframework.data.repository.NoRepositoryBean

import org.springframework.util.Assert
import java.io.Serializable
import java.util.*

@NoRepositoryBean
interface SoftDeleteRepository<T : BaseEntity<ID>, ID : Serializable> : JpaRepository<T, ID> {

//    @Transactional
//    @Query("select e from #{#entityName} e where e.id = ?1 and e.deleted = false")
//    override fun findById(id: ID): Optional<T>
//
//    @Transactional
//    @Query("select e from #{#entityName} e where e.id = ?1 and e.deleted = true")
//    fun findInactiveById(id: ID): Optional<T>
//
//    @Transactional
//    @Query("select e from #{#entityName} e where e.deleted = false")
//    override fun findAll(): List<T>
//
//    @Query("select e from #{#entityName} e where e.deleted = true")
//    fun findAllInactive(): List<T>
//
//    @Transactional
//    @Query("select e from #{#entityName} e where e.id in ?1 and e.deleted = false")
//    override fun findAllById(ids: Iterable<ID>): List<T>
//
//    @Transactional
//    @Query("select e from #{#entityName} e where e.id in ?1 and e.deleted = true")
//    fun findAllDeletedById(ids: Iterable<ID>): List<T>
//
//    @Transactional
//    @Modifying
//    fun softDeleteAll(entities: Iterable<T>) {
//        Assert.notNull(entities, "The given Iterable of model not be null!")
//        for (entity in entities) {
//            softDelete(entity)
//        }
//    }
//
//    @Modifying
//    @Query("update #{#entityName} e set e.deleted = true where e.id = ?1")
//    fun softDeleteById(id: ID?)
//
//    fun softDelete(entity: T) {
//        this.softDeleteById(entity.id)
//    }

}
package com.kaizensoftware.visitstory.common.persistence.model

import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.CreatedDate

import javax.persistence.*

import java.io.Serializable
import java.time.LocalDateTime

import org.springframework.data.jpa.domain.support.AuditingEntityListener

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity<T : Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: T? = null

    @CreatedDate
    @Column(updatable = false)
    var createdAt: LocalDateTime? = null

    @LastModifiedDate
    var modifiedAt: LocalDateTime? = null

    private var deleted: Boolean = false

    @PrePersist
    fun setAuditInfo() {
        this.deleted = false
    }

}
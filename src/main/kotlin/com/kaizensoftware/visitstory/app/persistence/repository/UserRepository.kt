package com.kaizensoftware.visitstory.app.persistence.repository

//import com.kaizensoftware.visitstory.common.persistence.repository.SoftDeleteRepository
import com.kaizensoftware.visitstory.app.persistence.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByName(name: String): User?

}
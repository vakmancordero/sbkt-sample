package com.kaizensoftware.visitstory.app.controller

import com.kaizensoftware.visitstory.app.persistence.model.User
import com.kaizensoftware.visitstory.app.persistence.repository.UserRepository
import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/user")
class UserController(
        val userRepository: UserRepository
) {

    @GetMapping("/{id}")
    fun findUser(@PathVariable id: Long): User {
        return userRepository.findById(id).orElseThrow {
            throw EntityNotFoundException("User with id $id not found")
        }
    }

    @PostMapping
    fun createUser(@RequestBody user: User) : User {
        return userRepository.save(user)
    }

}
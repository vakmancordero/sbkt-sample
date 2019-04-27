package com.kaizensoftware.visitstory.app.dto.user.create

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class UserCreateRequest(
        @Email
        @NotEmpty(message = "{user.create.empty.email}")
        var email: String? = null,

        @NotEmpty(message = "{user.create.empty.name}")
        var name: String? = null,

        @NotEmpty(message = "{user.create.empty.last-name}")
        var lastName: String? = null,

        var aboutMe: String? = null
)
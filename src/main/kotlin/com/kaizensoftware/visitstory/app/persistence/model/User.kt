package com.kaizensoftware.visitstory.app.persistence.model

import com.kaizensoftware.visitstory.common.persistence.model.BaseEntity
import javax.persistence.Entity

@Entity
data class User(
        var name: String? = null,
        var age: Int? = null
) : BaseEntity<Long>()
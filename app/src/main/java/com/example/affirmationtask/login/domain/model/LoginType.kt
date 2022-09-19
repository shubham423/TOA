package com.example.affirmationtask.login.domain.model

import com.example.affirmationtask.login.domain.usecase.Email
import com.example.affirmationtask.login.domain.usecase.Password

sealed class LoginType {
    data class Credentials(
        val email: Email,
        val password: Password,
    ) : LoginType()

    object Google : LoginType()
}

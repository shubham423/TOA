package com.example.affirmationtask.login.domain.usecase

import com.example.affirmationtask.login.domain.model.LoginResult

@Suppress("UnusedPrivateMember")
@JvmInline
value class Email(private val email: String)

@Suppress("UnusedPrivateMember")
@JvmInline
value class Password(private val password: String)

/**
 * This use case consumes any information required to log in the user, and attempts to do so.
 */
interface CredentialsLoginUseCase {

    suspend operator fun invoke(
        email: Email,
        password: Password,
    ): LoginResult
}
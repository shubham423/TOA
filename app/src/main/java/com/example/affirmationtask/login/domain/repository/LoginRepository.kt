package com.example.affirmationtask.login.domain.repository

import com.example.affirmationtask.core.data.Result
import com.example.affirmationtask.login.domain.model.Credentials
import com.example.affirmationtask.login.domain.model.LoginResponse

/**
 * The data layer for any requests related to logging in the user.
 */
interface LoginRepository {

    /**
     * Given some user [credentials], try to login the user.
     *
     * @return A [Result] that contains the [LoginResponse] if successful, or an error otherwise.
     */
    suspend fun login(
        credentials: Credentials
    ): Result<LoginResponse>
}

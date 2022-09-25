package com.example.affirmationtask.fakes

import com.example.affirmationtask.core.data.Result
import com.example.affirmationtask.login.domain.model.Credentials
import com.example.affirmationtask.login.domain.model.LoginResponse
import com.example.affirmationtask.login.domain.repository.LoginRepository
import io.mockk.coEvery
import io.mockk.mockk

/**
 * A fake implementation of a [LoginRepository] that wraps all of our mock work.
 */
class FakeLoginRepository {
    val mock: LoginRepository = mockk()

    fun mockLoginWithCredentials(
        credentials: Credentials,
        result: Result<LoginResponse>,
    ) {
        coEvery {
            mock.login(credentials)
        } returns result
    }
}

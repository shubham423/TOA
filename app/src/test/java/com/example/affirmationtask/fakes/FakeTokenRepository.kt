package com.example.affirmationtask.fakes

import com.example.affirmationtask.login.domain.model.Token
import com.example.affirmationtask.login.domain.repository.TokenRepository
import io.mockk.coVerify
import io.mockk.mockk

class FakeTokenRepository {

    val mock: TokenRepository = mockk(
        relaxUnitFun = true,
    )

    fun verifyTokenStored(token: Token) {
        coVerify {
            mock.storeToken(token)
        }
    }

    fun verifyNoTokenStored() {
        coVerify(exactly = 0) {
            mock.storeToken(any())
        }
    }
}

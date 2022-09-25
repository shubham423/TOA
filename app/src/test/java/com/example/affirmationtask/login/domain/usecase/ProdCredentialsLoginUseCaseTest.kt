package com.example.affirmationtask.login.domain.usecase

import com.example.affirmationtask.core.data.Result
import com.example.affirmationtask.fakes.FakeLoginRepository
import com.example.affirmationtask.fakes.FakeTokenRepository
import com.example.affirmationtask.login.domain.model.AuthToken
import com.example.affirmationtask.login.domain.model.Credentials
import com.example.affirmationtask.login.domain.model.Email
import com.example.affirmationtask.login.domain.model.InvalidCredentialsException
import com.example.affirmationtask.login.domain.model.LoginResponse
import com.example.affirmationtask.login.domain.model.LoginResult
import com.example.affirmationtask.login.domain.model.Password
import com.example.affirmationtask.login.domain.model.RefreshToken
import com.example.affirmationtask.login.domain.model.Token
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

class ProdCredentialsLoginUseCaseTest {
    private val defaultCredentials = Credentials(
        email = Email("testy@mctestface.com"),
        password = Password("Hunter2"),
    )

    private val defaultToken = Token(
        authToken = AuthToken("Auth"),
        refreshToken = RefreshToken("Refresh"),
    )

    private lateinit var loginRepository: FakeLoginRepository
    private lateinit var tokenRepository: FakeTokenRepository

    @Before
    fun setUp() {
        loginRepository = FakeLoginRepository()
        tokenRepository = FakeTokenRepository()
    }

    @Test
    fun testSuccessfulLogin() = runBlockingTest {
        val loginResponse = Result.Success(
            LoginResponse(
                token = defaultToken,
            )
        )

        loginRepository.mockLoginWithCredentials(
            defaultCredentials,
            loginResponse,
        )

        val useCase = ProdCredentialsLoginUseCase(
            loginRepository = loginRepository.mock,
            tokenRepository = tokenRepository.mock,
        )

        val result = useCase(defaultCredentials)
        assertThat(result).isEqualTo(LoginResult.Success)
        tokenRepository.verifyTokenStored(defaultToken)
    }

    @Test
    fun testUnknownFailureLogin() = runBlockingTest {
        val loginResponse: Result<LoginResponse> = Result.Error(
            Throwable("Adam fucked up")
        )

        loginRepository.mockLoginWithCredentials(
            defaultCredentials,
            loginResponse,
        )

        val useCase = ProdCredentialsLoginUseCase(
            loginRepository = loginRepository.mock,
            tokenRepository = tokenRepository.mock,
        )

        val result = useCase(defaultCredentials)
        assertThat(result).isEqualTo(LoginResult.Failure.Unknown)
        tokenRepository.verifyNoTokenStored()
    }

    @Test
    fun testInvalidCredentialLogin() = runBlockingTest {
        val loginResponse: Result<LoginResponse> = Result.Error(
            InvalidCredentialsException()
        )

        loginRepository.mockLoginWithCredentials(
            defaultCredentials,
            loginResponse,
        )

        val useCase = ProdCredentialsLoginUseCase(
            loginRepository = loginRepository.mock,
            tokenRepository = tokenRepository.mock,
        )

        val result = useCase(defaultCredentials)
        assertThat(result).isEqualTo(LoginResult.Failure.InvalidCredentials)
        tokenRepository.verifyNoTokenStored()
    }
}

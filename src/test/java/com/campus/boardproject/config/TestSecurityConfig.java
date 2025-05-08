package com.campus.boardproject.config;

import com.campus.boardproject.domain.UserAccount;
import com.campus.boardproject.repository.UserAccountRepository;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;
@Import(SecurityConfig.class)
public class TestSecurityConfig {

    @MockitoBean
    private UserAccountRepository userAccountRepository;

    @BeforeTestMethod
    public void securitySetUp() {
        given(userAccountRepository.findById(anyString())).willReturn(Optional.of(UserAccount.of(
                "unoTest",
                "pw",
                "uno-test@email.com",
                "uno-test",
                "test memo"
        )));
    }

}
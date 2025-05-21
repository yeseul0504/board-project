package com.campus.boardproject.config;

import com.campus.boardproject.dto.UserAccountDto;
import com.campus.boardproject.service.UserAccountService;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.BDDMockito.anyString;
import static org.mockito.BDDMockito.given;
@Import(SecurityConfig.class)
public class TestSecurityConfig {

    @MockitoBean private UserAccountService userAccountService;

    @BeforeTestMethod
    public void securitySetUp() {
        given(userAccountService.searchUser(anyString())).willReturn(Optional.of(createUserAccountDto()));
        given(userAccountService.saveUser(anyString(), anyString(), anyString(), anyString(), anyString()))
                .willReturn(createUserAccountDto());
    }

    private UserAccountDto createUserAccountDto() {
        return UserAccountDto.of(
                "unoTest",
                "pw",
                "uno-test@email.com",
                "uno-test",
                "test memo"
        );
    }
}
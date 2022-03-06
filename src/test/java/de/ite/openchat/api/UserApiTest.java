package de.ite.openchat.api;

import de.ite.openchat.domain.RegistrationData;
import de.ite.openchat.domain.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserApiTest {

    public static final String USER_NAME = "username";
    public static final String USER_ABOUT = "about";
    public static final String USER_PASSWORD = "password";
    @Mock
    private UserService userService;
    private UserApi sut;

    @BeforeEach
    void setUp() {
        sut = new UserApi(userService);
    }

    @Test
    void should_register_an_user() {
        sut.register(RegisterRequest.builder().username(USER_NAME).about(USER_ABOUT).password(USER_PASSWORD).build());
        verify(userService).createUser(RegistrationData.builder()
                .username(USER_NAME)
                .about(USER_ABOUT)
                .password(USER_PASSWORD)
                .build());
    }
}

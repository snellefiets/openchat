package de.ite.openchat.api;

import de.ite.openchat.domain.RegistrationData;
import de.ite.openchat.domain.User;
import de.ite.openchat.domain.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
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
        final User user = User.builder().id("id").name(USER_NAME).password(USER_PASSWORD).about(USER_ABOUT).build();
        doReturn(user).when(userService).createUser(any(RegistrationData.class));

        final RegisterRequest request = RegisterRequest.builder()
                .username(USER_NAME)
                .about(USER_ABOUT)
                .password(USER_PASSWORD)
                .build();

        final ResponseEntity<RegisterResponse> response = sut.register(request);
        verify(userService).createUser(RegistrationData.builder()
                .username(USER_NAME)
                .about(USER_ABOUT)
                .password(USER_PASSWORD)
                .build());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(RegisterResponse.builder().userId("id").message("").build());
    }
}

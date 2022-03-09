package de.ite.openchat.domain;

import de.ite.openchat.repository.UserDbo;
import de.ite.openchat.repository.UserRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private static final String USER_ID = "userId";
    private static final String USER_NAME = "name";
    private static final String USER_PASSWORD = "password";
    private static final String USER_ABOUT = "about";
    private RegistrationData registrationData;
    private UserService sut;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        sut = new UserService(userRepository);
        registrationData = RegistrationData.builder().username(USER_NAME).password(USER_PASSWORD).about(USER_ABOUT).build();
    }

    @SneakyThrows
    @Test
    void should_create_new_user() {
        doReturn(USER_ID).when(userRepository).save(any(UserDbo.class));

        final User user = sut.createUser(registrationData);

        verify(userRepository).save(UserDbo.builder()
                .name(USER_NAME)
                .password(USER_PASSWORD)
                .about(USER_ABOUT)
                .build());

        assertThat(user).isEqualTo(User.builder()
                .id(USER_ID)
                .name(USER_NAME)
                .password(USER_PASSWORD)
                .about(USER_ABOUT)
                .build());
    }

    @Test
    void should_fail_dueTo_user_already_exists() {
        doReturn(true).when(userRepository).existsByName(USER_NAME);

        assertThatThrownBy(() -> sut.createUser(registrationData)).isInstanceOf(UserAlreadyInUseException.class);
        verify(userRepository).existsByName(USER_NAME);
    }

}

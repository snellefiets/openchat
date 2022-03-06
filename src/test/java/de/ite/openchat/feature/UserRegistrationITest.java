package de.ite.openchat.feature;

import de.ite.openchat.api.RegisterRequest;
import de.ite.openchat.api.RegisterResponse;
import de.ite.openchat.helper.JsonUtil;
import de.ite.openchat.repository.UserDbo;
import de.ite.openchat.repository.UserRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRegistrationITest {

    private static final String USER_NAME = "Batman";
    private static final String USER_PASSWORD = "BruceWayne";
    private static final String USER_ABOUT = "The most famous superhero in the world, no matter what Marvel says!";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @SneakyThrows
    @Test
    void should_register_and_create_a_new_user() {

        final RegisterRequest request = RegisterRequest.builder()
                .username(USER_NAME).password(USER_PASSWORD).about(USER_ABOUT).build();
        final MockHttpServletResponse httpResponse = sendRequest(request);

        assertThat(httpResponse.getStatus()).isEqualTo(HttpStatus.CREATED.value());

        final RegisterResponse response = JsonUtil.toObject(httpResponse.getContentAsString(), RegisterResponse.class);
        final String userId = response.getUserId();

        assertThat(response).isEqualTo(RegisterResponse.builder().userId(userId).message("").build());

        final UserDbo userDbo = userRepository.findById(userId);

        assertThat(userDbo).isEqualTo(UserDbo.builder()
                .id(userId)
                .name(USER_NAME)
                .password(USER_PASSWORD)
                .about(USER_ABOUT)
                .build());

    }

    private MockHttpServletResponse sendRequest(RegisterRequest request)
            throws Exception {
        return mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/user/register")
                        .content(JsonUtil.toString(request))
                        .contentType(APPLICATION_JSON))
                .andReturn()
                .getResponse();
    }

}

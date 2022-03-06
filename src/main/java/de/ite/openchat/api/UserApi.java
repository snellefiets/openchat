package de.ite.openchat.api;

import de.ite.openchat.domain.RegistrationData;
import de.ite.openchat.domain.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserApi {

    private final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {
        userService.createUser(toRegistrationData(request));
    }

    private RegistrationData toRegistrationData(RegisterRequest request) {
        return RegistrationData.builder()
                .username(request.getUsername())
                .about(request.getAbout())
                .password(request.getPassword())
                .build();
    }
}

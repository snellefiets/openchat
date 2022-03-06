package de.ite.openchat.api;

import de.ite.openchat.domain.RegistrationData;
import de.ite.openchat.domain.User;
import de.ite.openchat.domain.UserAlreadyInUseException;
import de.ite.openchat.domain.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        final User user;
        try {
            user = userService.createUser(toRegistrationData(request));
        } catch (UserAlreadyInUseException e) {
            return toUserAlreadyInUseResponse();
        }
        return toUserRegisteredResponse(user);
    }

    private ResponseEntity<RegisterResponse> toUserAlreadyInUseResponse() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RegisterResponse.builder()
                .userId("")
                .message("user already in use")
                .build());
    }

    private ResponseEntity<RegisterResponse> toUserRegisteredResponse(User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(RegisterResponse.builder()
                .userId(user.getId())
                .message("")
                .build());
    }

    private RegistrationData toRegistrationData(RegisterRequest request) {
        return RegistrationData.builder()
                .username(request.getUsername())
                .about(request.getAbout())
                .password(request.getPassword())
                .build();
    }
}

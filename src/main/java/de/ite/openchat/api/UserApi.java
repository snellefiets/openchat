package de.ite.openchat.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserApi {

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {
        throw new UnsupportedOperationException();
    }
}

package de.ite.openchat.api;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RegisterRequest {
    private final String username;
    private final String password;
    private final String about;
}

package de.ite.openchat.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class RegistrationData {
    private final String username;
    private final String password;
    private final String about;
}

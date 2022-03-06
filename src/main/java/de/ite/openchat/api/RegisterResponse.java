package de.ite.openchat.api;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class RegisterResponse {
    private final String userId;
    private final String message;
}

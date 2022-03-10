package de.ite.openchat.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {
    private String userId;
    private String message;
}

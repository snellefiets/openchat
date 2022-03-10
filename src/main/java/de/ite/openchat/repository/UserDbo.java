package de.ite.openchat.repository;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class UserDbo {
    private final String id;
    private final String name;
    private final String password;
    private final String about;
}

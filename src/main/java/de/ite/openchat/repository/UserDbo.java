package de.ite.openchat.repository;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class UserDbo {
    private String id;
    private String name;
    private String password;
    private String about;
}

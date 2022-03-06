package de.ite.openchat.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private String id;
    private String name;
    private String password;
    private String about;
}

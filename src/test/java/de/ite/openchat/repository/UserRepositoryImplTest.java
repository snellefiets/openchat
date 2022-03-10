package de.ite.openchat.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserRepositoryImplTest {

    private UserRepositoryImpl sut;

    @BeforeEach
    void setUp() {
        sut = new UserRepositoryImpl();
    }

    @Test
    void should_find_a_user_existence() {
        sut.userList.add(UserDbo.builder().name("name").password("password").about("about").build());
        assertThat(sut.existsByName("name")).isTrue();
    }

    @Test
    void should_NOT_find_a_user_existence() {
        assertThat(sut.existsByName("user")).isFalse();
    }
}

package de.ite.openchat.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserRepositoryImplTest {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";
    private static final String ABOUT = "about";
    private UserRepositoryImpl sut;
    private UserDbo user;

    @Mock
    private IdGenerator idGenerator;

    @BeforeEach
    void setUp() {
        sut = new UserRepositoryImpl(idGenerator);
        user = UserDbo.builder().id(ID).name(NAME).password(PASSWORD).about(ABOUT).build();
    }

    @Test
    void should_find_an_user_existence() {
        sut.userList.add(user);
        assertThat(sut.existsByName(NAME)).isTrue();
    }

    @Test
    void should_NOT_find_an_user_existence() {
        assertThat(sut.existsByName(NAME)).isFalse();
    }

    @Test
    void should_find_an_user_by_id() {
        sut.userList.add(user);
        assertThat(sut.findById(ID)).isEqualTo(user);
    }

    @Test
    void should_NOT_find_an_user_by_id() {
        assertThat(sut.findById(ID)).isNull();
    }

    @Test
    void should_save_an_user() {
        doReturn("newId").when(idGenerator).nextId();

        assertThat(sut.save(user)).isEqualTo("newId");
        
        user.setId("newId");

        verify(idGenerator).nextId();
        assertThat(sut.userList.get(0)).isEqualTo(user);
    }
}

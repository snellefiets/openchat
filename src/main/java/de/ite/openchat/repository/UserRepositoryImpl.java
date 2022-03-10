package de.ite.openchat.repository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {
    final List<UserDbo> userList;
    private final IdGenerator idGenerator;

    public UserRepositoryImpl(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
        this.userList = new ArrayList<>();
    }

    @Override
    public UserDbo findById(String userId) {
        return userList.stream().findFirst().filter(u -> userId.equals(u.getId())).orElse(null);
    }

    @Override
    public String save(UserDbo user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsByName(String name) {
        return userList.stream().anyMatch(u -> name.equals(u.getName()));
    }
}

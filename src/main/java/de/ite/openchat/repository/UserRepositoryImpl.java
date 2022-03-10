package de.ite.openchat.repository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {
    final List<UserDbo> userList;

    public UserRepositoryImpl() {
        this.userList = new ArrayList<>();
    }

    @Override
    public UserDbo findById(String userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String save(UserDbo user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsByName(String name) {
        throw new UnsupportedOperationException();
    }
}

package de.ite.openchat.repository;

import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {
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

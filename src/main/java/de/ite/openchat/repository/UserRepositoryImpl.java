package de.ite.openchat.repository;

import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {
    @Override
    public UserDbo findById(String userId) {
        throw new UnsupportedOperationException();
    }
}

package de.ite.openchat.repository;

import java.util.Optional;

public interface UserRepository {
    Optional<UserDbo> findById(String userId);

    String save(UserDbo user);

    boolean existsByName(String name);
}

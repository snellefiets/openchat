package de.ite.openchat.repository;

public interface UserRepository {
    UserDbo findById(String userId);
}

package de.ite.openchat.domain;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User createUser(RegistrationData registrationData) throws UserAlreadyInUseException {
        throw new UnsupportedOperationException();
    }
}

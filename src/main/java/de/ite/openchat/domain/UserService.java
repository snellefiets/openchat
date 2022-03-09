package de.ite.openchat.domain;

import de.ite.openchat.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(RegistrationData registrationData) throws UserAlreadyInUseException {
        throw new UnsupportedOperationException();
    }
}

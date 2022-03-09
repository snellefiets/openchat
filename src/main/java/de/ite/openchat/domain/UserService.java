package de.ite.openchat.domain;

import de.ite.openchat.repository.UserDbo;
import de.ite.openchat.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(RegistrationData registrationData) throws UserAlreadyInUseException {
        final String userId = userRepository.save(UserDbo.builder().name(registrationData.getUsername()).password(registrationData.getPassword()).about(registrationData.getAbout()).build());
        return User.builder().id(userId).name(registrationData.getUsername()).password(registrationData.getPassword()).about(registrationData.getAbout()).build();
    }
}

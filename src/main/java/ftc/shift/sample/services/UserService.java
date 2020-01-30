package ftc.shift.sample.services;

import ftc.shift.sample.models.User;
import ftc.shift.sample.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User provideUser(String userId, String personId) { return userRepository.fetchUser(userId, personId); }

    public User updateUser(String userId, String personId, User user) {
        return userRepository.updateUser(userId, personId, user);
    }

    public void deleteUser(String userId, String personId) {
        userRepository.deleteUser(userId, personId);
    }

    public User createUser(String userId, User user) {
        return userRepository.createUser(userId, user);
    }

    public Collection<User> provideUsers(String userId) {
        return userRepository.getAllUsers(userId);
    }
}

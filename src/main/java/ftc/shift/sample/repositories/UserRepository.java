package ftc.shift.sample.repositories;

import ftc.shift.sample.models.User;

import java.util.Collection;

public interface UserRepository {
    User fetchUser(String userId, String personId);

    User updateUser(String userId, String personId, User user);

    void deleteUser(String userId, String personId);

    User createUser(String userId, User user);

    Collection<User> getAllUsers(String userId);
}

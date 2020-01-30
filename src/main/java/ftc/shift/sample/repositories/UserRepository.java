package ftc.shift.sample.repositories;

import ftc.shift.sample.models.User;

import java.util.Collection;

public interface UserRepository {
    User fetchUser(String id);

    /*User updateUser(String id, User user);

    User createUser(String Id, User user);
    */
}

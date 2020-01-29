package ftc.shift.sample.repositories;

import ftc.shift.sample.exception.NotFoundException;
import ftc.shift.sample.models.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
@ConditionalOnProperty(name = "use.database", havingValue = "false")
public class InMemoryUserRepository implements UserRepository{

    private Map<String, Map<String, User>> userCache = new HashMap<>();

    public InMemoryUserRepository() {
        // Заполним репозиторий тестовыми данными
        // В тестовых данных существует всего 3 пользователя: UserA / UserB / UserC

        userCache.put("UserA", new HashMap<>());
        userCache.get("UserA").put("1", new User("1", "login1", "password1", "name1", 50, "avatar1", "registrationDate1"));
        userCache.get("UserA").put("2", new User("2", "login2", "password2", "name2", 1450, "avatar2", "registrationDate2"));

        userCache.put("UserB", new HashMap<>());
        userCache.get("UserB").put("3", new User("3", "login3", "password3", "name3", 1, "avatar3", "registrationDate3"));

        userCache.put("UserC", new HashMap<>());
    }

    @Override
    public User fetchUser(String userId, String personId) {
        if (!userCache.containsKey(userId)) {
            throw new NotFoundException();
        }

        Map<String, User> userUsers = userCache.get(userId);

        if (!userUsers.containsKey(personId)) {
            throw new NotFoundException();
        }

        return userUsers.get(personId);
    }

    @Override
    public User updateUser(String userId, String personId, User user) {
        if (!userCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        Map<String, User> userUsers = userCache.get(userId);

        if (!userUsers.containsKey(personId)) {
            // У пользователя не найдена книга
            throw new NotFoundException();
        }

        user.setPersonId(personId);
        userUsers.put(personId, user);
        return user;
    }

    @Override
    public void deleteUser(String userId, String personId) {
        if (!userCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        Map<String, User> userUsers = userCache.get(userId);

        if (!userUsers.containsKey(userId)) {
            // У пользователя не найдена книга
            throw new NotFoundException();
        }

        userCache.remove(userId);
    }

    @Override
    public User createUser(String userId, User user) {
        if (!userCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        Map<String, User> userUsers = userCache.get(userId);

        // Плохой способ генерирования случайных идентификаторов, использовать только для примеров
        user.setPersonId(String.valueOf(System.currentTimeMillis()));
        userUsers.put(user.getPersonId(), user);
        return user;
    }

    @Override
    public Collection<User> getAllUsers(String userId) {
        if (!userCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        return userCache.get(userId).values();
    }
}

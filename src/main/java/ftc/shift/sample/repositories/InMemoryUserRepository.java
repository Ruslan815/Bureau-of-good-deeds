package ftc.shift.sample.repositories;

import ftc.shift.sample.VariableClass;
import ftc.shift.sample.exception.NotFoundException;
import ftc.shift.sample.models.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@ConditionalOnProperty(name = "use.database", havingValue = "false")
public class InMemoryUserRepository implements UserRepository {

    private User[] userCache = new User[100];

    public InMemoryUserRepository() {

        String tempStringId, tempLogin, tempPassword, tempRegistrationDate, tempName, tempAvatar;

        for (int i = 0; i < 100; i++) {
            tempStringId = String.valueOf(i);
            tempLogin = "login" + i;
            tempPassword = "password" + i;
            tempRegistrationDate = "01-01-" + i;
            tempName = "name" + i;
            tempAvatar = "someBase64CodeNumber" + i;
            userCache[i] = new User(tempStringId, tempLogin, tempPassword, tempRegistrationDate, tempName, i, tempAvatar);
        }
    }

    @Override
    public User fetchUser(String id) {
        boolean isFound = false;
        User answer = new User();

        for (int i = 0; i < 100; i++) {
            if (userCache[i].getId().equals(id)) {
                answer = userCache[i];
                isFound = true;
                break;
            }
        }

        if (isFound) {
            return answer;
        } else {
            throw new NotFoundException();
        }
    }
/*
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

        user.setId(personId);
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
        user.setId(VariableClass.getAvailableId());
        userUsers.put(user.getId(), user);
        return user;
    }
*/
}

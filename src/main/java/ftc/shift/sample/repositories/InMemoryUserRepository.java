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
public class InMemoryUserRepository implements UserRepository{

    //private Map<String, Map<String, User>> userCache = new HashMap<>();

    private User []userCache = new User[100];

    public InMemoryUserRepository() {
        // Заполним репозиторий тестовыми данными
        // В тестовых данных существует всего 3 пользователя: UserA / UserB / UserC

      //  userCache.put("UserA", new HashMap<>());
        userCache[0] = new User("1", "login1", "password1", "registrationDate1", "name1", 50, "avatar1");
/*
        userCache.put("UserB", new HashMap<>());
        userCache.get("UserB").put("3", new User("2", "login2", "password2", "registrationDate2", "name2", 510, "avatar2"));

        userCache.put("UserC", new HashMap<>());
        userCache.get("UserC").put("2", new User("3", "login3", "password3", "registrationDate3", "name3", 5550, "avatar3"));
*/
    }

    @Override
    public User fetchUser(String id) {

        boolean isFound = true;
        User answer = new User();
        for(int i = 0; i < 100; i++) {
            if(userCache[i].getId().equals(id)) {
                answer = userCache[i];
                isFound = true;
            }
        }

        if(isFound) {
            return answer;
        } else {
            throw new NotFoundException();
        }

        /*Map<String, User> userUsers = userCache.get(id);

        if (!userUsers.containsKey(id)) {
            throw new NotFoundException();
        }

        return userUsers.get(id);*/
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

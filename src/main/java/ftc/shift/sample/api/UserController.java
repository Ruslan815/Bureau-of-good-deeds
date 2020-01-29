package ftc.shift.sample.api;


import ftc.shift.sample.models.User;
import ftc.shift.sample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class UserController {
    private static final String USERS_PATH = "/api/v001/books";
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * Добавление новой книги
     *
     * @param userId - Идентификатор пользователя
     * @param user   - Данные для новой книги (Название, автор, количество страниц, жанры)
     * @return Сохранённая книга с установленным {@link User#getPersonId()}
     */
    @PostMapping(USERS_PATH)
    public ResponseEntity<User> createUser(
            @RequestHeader("userId") String userId,
            @RequestBody User user) {
        User result = service.createUser(userId, user);
        return ResponseEntity.ok(result);
    }

    /**
     * Получение книги с указанным идентификатором
     *
     * @param userId - Идентификатор пользователя
     * @param personId - Идентификатор книги
     */
    @GetMapping(USERS_PATH + "/{personId}")
    public ResponseEntity<User> readUser(
            @RequestHeader("userId") String userId,
            @PathVariable String personId) {
        User user = service.provideUser(userId, personId);
        return ResponseEntity.ok(user);
    }

    /**
     * Обновление существующей книги
     *
     * @param userId - Идентификатор пользователя
     * @param personId - Идентификатор книги, которую необходимо обновить
     * @param user   - Новые данные для книги (Название, автор, количество страниц, жанры)
     */
   @PatchMapping(USERS_PATH + "/{personId}")
    public ResponseEntity<User> updateUser(
            @RequestHeader("userId") String userId,
            @PathVariable String personId,
            @RequestBody User user) {
        User updatedUser = service.updateUser(userId, personId, user);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Удаление существующей книги
     *
     * @param userId - Идентификатор пользователя
     * @param personId - Идентификатор книги, которую необходимо удалить
     */
   @DeleteMapping(USERS_PATH + "/{personId}")
    public ResponseEntity<?> deleteUser(
            @RequestHeader("userId") String userId,
            @PathVariable String personId) {
        service.deleteUser(userId, personId);
        return ResponseEntity.ok().build();
    }

    /**
     * Получение всех книг пользователя
     *
     * @param userId - Идентификатор пользователя
     */
   @GetMapping(USERS_PATH)
    public ResponseEntity<Collection<User>> listUsers(
            @RequestHeader("userId") String userId) {
        Collection<User> users = service.provideUsers(userId);
        return ResponseEntity.ok(users);
    }
}
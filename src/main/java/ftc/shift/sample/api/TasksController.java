package ftc.shift.sample.api;

import ftc.shift.sample.models.Task;
import ftc.shift.sample.services.TaskService;
import ftc.shift.sample.models.User;
import ftc.shift.sample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class TasksController {
  //  private static final String TASKS_PATH = "/api/v001/tasks";
    private TaskService taskService;

    @Autowired
    public TasksController(UserService service, TaskService service1) {
        this.userService = service;
        this.taskService = service1;
    }

    /**
     * Добавление новой книги
     *
     * @param userId - Идентификатор пользователя
     * @param task   - Данные для новой книги (Название, автор, количество страниц, жанры)
     * @return Сохранённая книга с установленным {@link Task#getTaskId()}
     */
    /*@PostMapping(TASKS_PATH)
    public ResponseEntity<Task> createTask(
            @RequestHeader("userId") String userId,
            @RequestBody Task task) {
        Task result = taskService.createTask(userId, task);
        return ResponseEntity.ok(result);
    }

    /**
     * Получение книги с указанным идентификатором
     *
     * @param userId - Идентификатор пользователя
     * @param taskId - Идентификатор книги
     */
    /*@GetMapping(TASKS_PATH + "/{taskId}")
    public ResponseEntity<Task> readTask(
            @RequestHeader("userId") String userId,
            @PathVariable String taskId) {
        Task task = taskService.provideTask(userId, taskId);
        return ResponseEntity.ok(task);
    }

    /**
     * Обновление существующей книги
     *
     * @param userId - Идентификатор пользователя
     * @param taskId - Идентификатор книги, которую необходимо обновить
     * @param task   - Новые данные для книги (Название, автор, количество страниц, жанры)
     */
    /*@PatchMapping(TASKS_PATH + "/{taskId}")
    public ResponseEntity<Task> updateTask(
            @RequestHeader("userId") String userId,
            @PathVariable String taskId,
            @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(userId, taskId, task);
        return ResponseEntity.ok(updatedTask);
    }

    /**
     * Удаление существующей книги
     *
     * @param userId - Идентификатор пользователя
     * @param taskId - Идентификатор книги, которую необходимо удалить
     */
    /*@DeleteMapping(TASKS_PATH + "/{taskId}")
    public ResponseEntity<?> deleteTask(
            @RequestHeader("userId") String userId,
            @PathVariable String taskId) {
        taskService.deleteTask(userId, taskId);
        return ResponseEntity.ok().build();
    }

    /**
     * Получение всех книг пользователя
     *
     * @param userId - Идентификатор пользователя
     */
    /*@GetMapping(TASKS_PATH)
    public ResponseEntity<Collection<Task>> listTasks(
            @RequestHeader("userId") String userId) {
        Collection<Task> tasks = taskService.provideTasks(userId);
        return ResponseEntity.ok(tasks);
    }

    //////////////////////////////////////////////////////////////////////////////
*/
    private static final String USERS_PATH = "/api/v001/users";
    private UserService userService;

    /**
     * Добавление новой книги
     *
     * @param id - Идентификатор пользователя
     * @return Сохранённая книга с установленным {@link User#getId()}
     */
    /*@PostMapping(USERS_PATH)
    public ResponseEntity<User> createUser(
            @RequestHeader("userId") String userId,
            @RequestBody User user) {
        User result = userService.createUser(userId, user);
        return ResponseEntity.ok(result);
    }

    /**
     * Получение книги с указанным идентификатором
     *
     * @param id - Идентификатор пользователя
     * @param id - Идентификатор книги
     */
    @GetMapping(USERS_PATH)
    public ResponseEntity<User> readUser(
            @PathVariable(required = true) String id) {
        User user = userService.provideUser(id);
        return ResponseEntity.ok(user);
    }

    /**
     * Обновление существующей книги
     *
     * @param userId - Идентификатор пользователя
     * @param personId - Идентификатор книги, которую необходимо обновить
     * @param user   - Новые данные для книги (Название, автор, количество страниц, жанры)
     */
    /*@PatchMapping(USERS_PATH + "/{personId}")
    public ResponseEntity<User> updateUser(
            @RequestHeader("userId") String userId,
            @PathVariable String personId,
            @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, personId, user);
        return ResponseEntity.ok(updatedUser);
    }
    */
}

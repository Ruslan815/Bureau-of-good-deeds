package ftc.shift.sample.api;

import ftc.shift.sample.models.Task;
import ftc.shift.sample.services.TaskService;
import ftc.shift.sample.models.User;
import ftc.shift.sample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Collection;

@RestController
public class TasksController {
    private static final String TASKS_PATH = "/api/v001/tasks";
    private TaskService taskService;

    @Autowired
    public TasksController(UserService service, TaskService service1) {
        this.userService = service;
        this.taskService = service1;
    }

    /**
     * Добавление нового объявления
     */
    @PostMapping(TASKS_PATH)
    public void createTask(
            @RequestBody Task task) {
        taskService.createTask(task);
        //   return ResponseEntity.ok();
    }

    /**
     * Получение задания с указанным id владельца или статусом задания
     * или с id выполнителя
     */
    @GetMapping(TASKS_PATH)
    public ResponseEntity<ArrayList<Task>> readTaskStatus(
            @RequestParam(required = false) String ownerId,
            @RequestParam(required = false) Integer taskStatus,
            @RequestParam(required = false) String performerId) {
        if (ownerId == null) {
            ArrayList<Task> task = new ArrayList<>();
            task = taskService.provideTaskStatusAndId(taskStatus, performerId);
            return ResponseEntity.ok(task);
        }
        else {
            ArrayList<Task> task = new ArrayList<>();
            task = taskService.provideTask(ownerId, taskStatus);
            return ResponseEntity.ok(task);
        }
    }

    /**
     * Обновление существующей книги
     */
    @PatchMapping(TASKS_PATH)
    public void updateTask(
            @RequestBody Task task) {
        taskService.updateTask(task);
    }

    //////////////////////////////////////////////////////////////////////////////

    private static final String USERS_PATH = "/api/v001/users";
    private UserService userService;
/*

    @PostMapping(USERS_PATH)
    public ResponseEntity<User> createUser(
            @RequestHeader("userId") String userId,
            @RequestBody User user) {
        User result = userService.createUser(userId, user);
        return ResponseEntity.ok(result);
    }

    /*
    @GetMapping(USERS_PATH)
    public ResponseEntity<User> readUser(
            @RequestParam(required = true) String id) {
        User user = userService.provideUser(id);
        return ResponseEntity.ok(user);
    }

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

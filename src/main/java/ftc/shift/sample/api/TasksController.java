package ftc.shift.sample.api;

import ftc.shift.sample.models.Task;
import ftc.shift.sample.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class TasksController {
    private static final String TASKS_PATH = "/api/v001/books";
    private TaskService service;

    @Autowired
    public TasksController(TaskService service) {
        this.service = service;
    }

    /**
     * Добавление новой книги
     *
     * @param userId - Идентификатор пользователя
     * @param task   - Данные для новой книги (Название, автор, количество страниц, жанры)
     * @return Сохранённая книга с установленным {@link Task#getTaskId()}
     */
    @PostMapping(TASKS_PATH)
    public ResponseEntity<Task> createTask(
            @RequestHeader("userId") String userId,
            @RequestBody Task task) {
        Task result = service.createTask(userId, task);
        return ResponseEntity.ok(result);
    }

    /**
     * Получение книги с указанным идентификатором
     *
     * @param userId - Идентификатор пользователя
     * @param taskId - Идентификатор книги
     */
    @GetMapping(TASKS_PATH + "/{taskId}")
    public ResponseEntity<Task> readTask(
            @RequestHeader("userId") String userId,
            @PathVariable String taskId) {
        Task task = service.provideTask(userId, taskId);
        return ResponseEntity.ok(task);
    }

    /**
     * Обновление существующей книги
     *
     * @param userId - Идентификатор пользователя
     * @param taskId - Идентификатор книги, которую необходимо обновить
     * @param task   - Новые данные для книги (Название, автор, количество страниц, жанры)
     */
    @PatchMapping(TASKS_PATH + "/{taskId}")
    public ResponseEntity<Task> updateTask(
            @RequestHeader("userId") String userId,
            @PathVariable String taskId,
            @RequestBody Task task) {
        Task updatedTask = service.updateTask(userId, taskId, task);
        return ResponseEntity.ok(updatedTask);
    }

    /**
     * Удаление существующей книги
     *
     * @param userId - Идентификатор пользователя
     * @param taskId - Идентификатор книги, которую необходимо удалить
     */
    @DeleteMapping(TASKS_PATH + "/{taskId}")
    public ResponseEntity<?> deleteTask(
            @RequestHeader("userId") String userId,
            @PathVariable String taskId) {
        service.deleteTask(userId, taskId);
        return ResponseEntity.ok().build();
    }

    /**
     * Получение всех книг пользователя
     *
     * @param userId - Идентификатор пользователя
     */
    @GetMapping(TASKS_PATH)
    public ResponseEntity<Collection<Task>> listTasks(
            @RequestHeader("userId") String userId) {
        Collection<Task> tasks = service.provideTasks(userId);
        return ResponseEntity.ok(tasks);
    }


}

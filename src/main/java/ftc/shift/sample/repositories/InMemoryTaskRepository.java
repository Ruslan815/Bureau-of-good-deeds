package ftc.shift.sample.repositories;

import ftc.shift.sample.exception.NotFoundException;
import ftc.shift.sample.models.Task;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Реализиция, хранящая все данные в памяти приложения
 */
@Repository
@ConditionalOnProperty(name = "use.database", havingValue = "false")
public class InMemoryTaskRepository implements TaskRepository {
    /**
     * Ключ - имя пользователя, значение - все книги, которые есть у пользователя
     */
    private Map<String, Map<String, Task>> bookCache = new HashMap<>();

    public InMemoryTaskRepository() {
        // Заполним репозиторий тестовыми данными
        // В тестовых данных существует всего 3 пользователя: UserA / UserB / UserC

        bookCache.put("UserA", new HashMap<>());
        bookCache.get("UserA").put("1", new Task("taskId", "ownerId", "performerId", "taskName",
                777, "taskDescription", 1337, "creationDate",
                "completionDate", "taskPicture"));
        /*
        bookCache.get("UserA").put("2", new Task("2", "Название 2", "Автор Писателевич", 48,
                Collections.singletonList("Детектив")));

        bookCache.put("UserB", new HashMap<>());
        bookCache.get("UserB").put("3", new Task("3", "Название 3", "Писатель Авторович", 24,
                Collections.singletonList("Киберпанк")));

        bookCache.put("UserC", new HashMap<>());

         */
    }

    @Override
    public Task fetchTask(String userId, String bookId) {
        if (!bookCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        Map<String, Task> userBooks = bookCache.get(userId);

        if (!userBooks.containsKey(bookId)) {
            // У пользователя не найдена книга
            throw new NotFoundException();
        }

        return userBooks.get(bookId);
    }

    @Override
    public Task updateTask(String userId, String bookId, Task book) {
        if (!bookCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        Map<String, Task> userBooks = bookCache.get(userId);

        if (!userBooks.containsKey(bookId)) {
            // У пользователя не найдена книга
            throw new NotFoundException();
        }

        book.setTaskId(bookId);
        userBooks.put(bookId, book);
        return book;
    }

    @Override
    public void deleteTask(String userId, String bookId) {
        if (!bookCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        Map<String, Task> userBooks = bookCache.get(userId);

        if (!userBooks.containsKey(bookId)) {
            // У пользователя не найдена книга
            throw new NotFoundException();
        }

        bookCache.remove(bookId);
    }

    @Override
    public Task createTask(String userId, Task book) {
        if (!bookCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        Map<String, Task> userBooks = bookCache.get(userId);

        // Плохой способ генерирования случайных идентификаторов, использовать только для примеров
        book.setTaskId(String.valueOf(System.currentTimeMillis()));
        userBooks.put(book.setTaskId(), book);
        return book;
    }

    @Override
    public Collection<Task> getAllTasks(String userId) {
        if (!bookCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        return bookCache.get(userId).values();
    }
}


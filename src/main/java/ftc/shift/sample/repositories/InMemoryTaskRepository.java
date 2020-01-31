package ftc.shift.sample.repositories;

import ftc.shift.sample.VariableClass;
import ftc.shift.sample.exception.NotFoundException;
import ftc.shift.sample.models.Task;
import ftc.shift.sample.models.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Null;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@ConditionalOnProperty(name = "use.database", havingValue = "false")
public class InMemoryTaskRepository implements TaskRepository {

    private Task[] userCache = new Task[100];

    public InMemoryTaskRepository() {
        String tempTaskId, tempOwnerId, tempPerformerId, tempTaskName,
                tempTaskDescription, tempCreationDate, tempCompletionDate, tempTaskPicture;
        Integer temp;

        for (int i = 0; i < 100; i++) {
            tempTaskId = String.valueOf(i + 1);
            tempOwnerId = String.valueOf(i);
            tempPerformerId = String.valueOf(i + 3);
            tempTaskName = "name" + i;
            tempTaskDescription = "taskDescription" + i;
            tempCreationDate = "01-01-" + i;
            tempCompletionDate = "01-01-" + i;
            tempTaskPicture = "taskPicture" + i;

            userCache[i] = new Task(tempTaskId, tempOwnerId, tempPerformerId, tempTaskName, i,
                    tempTaskDescription, i, tempCreationDate, tempCompletionDate, tempTaskPicture);
        }
    }

    @Override
    public Task fetchTask(String ownerId, Integer taskStatus) {
        boolean isFound = false;
        Task answer = new Task();

        if (taskStatus == null) {
            for (int i = 0; i < 100; i++) {
                if (userCache[i].getOwnerId().equals(ownerId)) {
                    answer = userCache[i];
                    isFound = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < 100; i++) {
                if (userCache[i].getOwnerId().equals(ownerId) && userCache[i].getTaskStatus().equals(taskStatus)) {
                    answer = userCache[i];
                    isFound = true;
                    break;
                }
            }
        }

        if (isFound) {
            return answer;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public Task fetchTaskStatusAndId(Integer taskStatus, String performerId) {
        boolean isFound = false;
        Task answer = new Task();

        if (performerId == null) {
            for (int i = 0; i < 100; i++) {
                if (userCache[i].getTaskStatus().equals(taskStatus)) {
                    answer = userCache[i];
                    isFound = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < 100; i++) {
                if (userCache[i].getTaskStatus().equals(taskStatus) && userCache[i].getPerformerId().equals(performerId)) {
                    answer = userCache[i];
                    isFound = true;
                    break;
                }
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
    public Task updateTask(String userId, String taskId, Task task) {
        if (!taskCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        Map<String, Task> userTasks = taskCache.get(userId);

        if (!userTasks.containsKey(taskId)) {
            // У пользователя не найдена книга
            throw new NotFoundException();
        }

        task.setTaskId(taskId);
        userTasks.put(taskId, task);
        return task;
    }

    @Override
    public Task createTask(String userId, Task task) {
        if (!taskCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        Map<String, Task> userTasks = taskCache.get(userId);

        // способ генерирования случайных идентификаторов, использовать только для примеров
        task.setTaskId(VariableClass.getAvailableId());
        userTasks.put(task.setTaskId(), task);
        return task;
    }

 */
}


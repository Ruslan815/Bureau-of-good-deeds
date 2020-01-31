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

    private Task[] userCache = new Task[150];

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
            for (int i = 0; i < Integer.parseInt(VariableClass.getAvailableIdNonIncrement()); i++) {
                if (userCache[i].getOwnerId().equals(ownerId)) {
                    answer = userCache[i];
                    isFound = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < Integer.parseInt(VariableClass.getAvailableIdNonIncrement()); i++) {
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
            for (int i = 0; i <= Integer.parseInt(VariableClass.getAvailableIdNonIncrement()); i++) {
                if (userCache[i].getTaskStatus().equals(taskStatus)) {
                    answer = userCache[i];
                    isFound = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i <= Integer.parseInt(VariableClass.getAvailableIdNonIncrement()); i++) {
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


    @Override
    public void updateTask(Task task) {
        String taskId = task.getTaskId();

        for (int i = 0; i <= Integer.parseInt(VariableClass.getAvailableIdNonIncrement()); i++) {
            if (userCache[i].getTaskId().equals(taskId)) {
                userCache[i] = task;
                break;
            }
        }
    }

    @Override
    public void createTask(Task task) {
        task.setTaskId(VariableClass.getAvailableId());
        int elementIndex = Integer.parseInt(task.getTaskId());
        userCache[elementIndex] = task;

    }
}


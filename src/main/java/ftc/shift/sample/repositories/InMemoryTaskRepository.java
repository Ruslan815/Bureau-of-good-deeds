package ftc.shift.sample.repositories;

import ftc.shift.sample.VariableClass;
import ftc.shift.sample.exception.NotFoundException;
import ftc.shift.sample.models.Task;
import ftc.shift.sample.models.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Null;
import java.util.ArrayList;

@Repository
@ConditionalOnProperty(name = "use.database", havingValue = "false")
public class InMemoryTaskRepository implements TaskRepository {

    private Task[] userCache = new Task[100];

    public InMemoryTaskRepository() {}

    @Override
    public ArrayList<Task> fetchTask(String ownerId, Integer taskStatus) {
        boolean isFound = false;
        Task answer = new Task();

        ArrayList<Task> array = new ArrayList();

        if (taskStatus == null) {
            for (int i = 0; i < Integer.parseInt(VariableClass.getAvailableIdNonIncrement()); i++) {
                if (userCache[i].getOwnerId().equals(ownerId)) {
                    answer = userCache[i];
                    array.add(answer);
                    isFound = true;
                }
            }
        } else {
            for (int i = 0; i < Integer.parseInt(VariableClass.getAvailableIdNonIncrement()); i++) {
                if (userCache[i].getOwnerId().equals(ownerId) && userCache[i].getTaskStatus().equals(taskStatus)) {
                    answer = userCache[i];
                    array.add(answer);
                    isFound = true;
                }
            }
        }

        if (isFound) {
            return array;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public ArrayList<Task> fetchTaskStatusAndId(Integer taskStatus, String performerId) {
        boolean isFound = false;
        Task answer = new Task();

        ArrayList<Task> array = new ArrayList();

        if (performerId == null) {
            for (int i = 0; i < Integer.parseInt(VariableClass.getAvailableIdNonIncrement()); i++) {
                if (userCache[i].getTaskStatus().equals(taskStatus)) {
                    answer = userCache[i];
                    array.add(answer);
                    isFound = true;
                }
            }
        } else {
            for (int i = 0; i < Integer.parseInt(VariableClass.getAvailableIdNonIncrement()); i++) {
                if (userCache[i].getTaskStatus().equals(taskStatus) && userCache[i].getPerformerId().equals(performerId)) {
                    answer = userCache[i];
                    array.add(answer);
                    isFound = true;
                }
            }
        }

        if (isFound) {
            return array;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public void updateTask(Task task) {
        String taskId = task.getTaskId();
        boolean isFound = false;

        for (int i = 0; i <= Integer.parseInt(VariableClass.getAvailableIdNonIncrement()); i++) {
            if (userCache[i].getTaskId().equals(taskId)) {
                userCache[i] = task;
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            throw new NotFoundException();
        }
    }

    @Override
    public void createTask(Task task) {
        task.setTaskId(VariableClass.getAvailableId());
        int elementIndex = Integer.parseInt(task.getTaskId());
        userCache[elementIndex] = task;
    }
}


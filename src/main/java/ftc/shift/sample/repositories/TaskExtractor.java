package ftc.shift.sample.repositories;

import ftc.shift.sample.models.Task;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TaskExtractor implements ResultSetExtractor<List<Task>> {
    @Override
    public List<Task> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<String, Task> tasks = new HashMap<>();

        while (rs.next()) {
            String taskId = rs.getString("BOOK_ID");

            Task task;
            if (tasks.containsKey(taskId)) {
                task = tasks.get(taskId);
            } else {
                task = new Task();

                task.setTaskId(rs.getString("TASK_ID"));
                task.setOwnerId(rs.getString("OWNER_ID"));
                task.setPerformerId(rs.getString("PERFORMER_ID"));
                task.setTaskName(rs.getString("TASK_NAME"));
                task.setTaskStatus(rs.getInt("STATUS"));
                task.setTaskDescription(rs.getString("TASK_DESCRIPTION"));
                task.setTaskCost(rs.getInt("COST"));
                task.setCreationDate(rs.getString("CREATION_DATE"));
                task.setCompletionDate(rs.getString("COMPLETION_DATE"));
                task.setTaskPicture(rs.getString("TASK_PICTURE"));

                tasks.put(taskId, task);
            }
        }

        return new ArrayList<>(tasks.values());
    }
}

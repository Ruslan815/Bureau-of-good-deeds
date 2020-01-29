package ftc.shift.sample.models;

public class Task {

    private String taskId;

    private String ownerId;

    private String performerId;

    private String taskName;

    private Integer taskStatus;

    private String taskDescription;

    private Integer taskCost;

    private String creationDate;

    private String completionDate;

    private String taskPicture;

    private Boolean descriptionVisible = false;

    public Task() {
    }

    public Task(String taskId, String ownerId, String performerId, String taskName, Integer taskStatus, String taskDescription, Integer taskCost,
                String creationDate, String completionDate, String taskPicture) {
        this.taskId = taskId;
        this.ownerId = ownerId;
        this.performerId = performerId;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
        this.taskDescription = taskDescription;
        this.taskCost = taskCost;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
        this.taskPicture = taskPicture;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String setTaskId() {
        return "DefaultTaskId";
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getPerformerId() {
        return performerId;
    }

    public void setPerformerId(String performerId) {
        this.performerId = performerId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Integer getTaskCost() {
        return taskCost;
    }

    public void setTaskCost(Integer taskCost) {
        this.taskCost = taskCost;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getTaskPicture() {
        return taskPicture;
    }

    public void setTaskPicture(String taskPicture) {
        this.taskPicture = taskPicture;
    }


}


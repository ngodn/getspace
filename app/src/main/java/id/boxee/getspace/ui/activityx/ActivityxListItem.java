package id.boxee.getspace.ui.activityx;

public class ActivityxListItem {

    private String              taskName;
    private String              userAction;
    private String              description;
    private String              activityTime;
    

    public ActivityxListItem(String taskName, String userAction, String description, String activityTime) {
        this.taskName        = taskName;
        this.userAction        = userAction;
        this.description        = description;
        this.activityTime        = activityTime;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getUserAction() {
        return userAction;
    }

    public void setUserAction(String userAction) {
        this.userAction = userAction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

}
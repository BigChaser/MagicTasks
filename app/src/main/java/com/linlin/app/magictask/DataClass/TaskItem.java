package com.linlin.app.magictask.DataClass;

public class TaskItem {
    /**
     * Task ID
     */
    private  int id;
    /**
     * Task Name
     */
    private String taskName;

    /**
     * Time need to do the task
     */
    private Integer timeToDo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTimeToDo() {
        return timeToDo;
    }

    public void setTimeToDo(Integer timeToDo) {
        this.timeToDo = timeToDo;
    }

    public TaskItem(int id, String taskName, Integer timeToDo) {
        this.id = id;
        this.taskName = taskName;
        this.timeToDo = timeToDo;
    }
}

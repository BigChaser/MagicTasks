package com.linlin.app.magictask.DataClass;

import java.util.ArrayList;
import java.util.List;

public class TaskItemList {

    private static List<TaskItem> taskItemList;

    public static List<TaskItem> getTaskItemList() {
        return taskItemList;
    }

    public static void setTaskItemList(List<TaskItem> taskItemList) {
        TaskItemList.taskItemList = taskItemList;
    }


    public TaskItemList() {
        taskItemList = new ArrayList<TaskItem>();

        TaskItem task1= new TaskItem(1,"完成数学作业",30);
        TaskItem task2= new TaskItem(2,"练习钢琴",20);
        TaskItem task3= new TaskItem(3,"联系英语",10);

        taskItemList.add(task1);
        taskItemList.add(task2);
        taskItemList.add(task3);
    }

    public TaskItemList(List<TaskItem> paramTaskItemList) {
        taskItemList = paramTaskItemList;
    }

    public void addTaskItem(TaskItem paramTaskItem){
        if (paramTaskItem != null)
        {
            taskItemList.add(paramTaskItem);
        }
    }

    public void deleteTaskItem(int index){
        if (taskItemList != null && taskItemList.size() > index)
        {
            taskItemList.remove(index);
        }
    }

    public TaskItem getTaskItemByIndex(int index){
        if(taskItemList != null && index <taskItemList.size())
        {
            return taskItemList.get(index);
        }else
        {
            return null;
        }
    }

    public int size(){
        if (taskItemList == null)
        {
            return 0;
        }else{

            return taskItemList.size();
        }
    }

}

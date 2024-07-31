package edu.utsa.cs3443.project.model;

import java.util.ArrayList;

public class ToDoList {
    private String task;
    private ArrayList<ToDoList> taskList = new ArrayList<ToDoList>();
    public ToDoList(String task){
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
    public ArrayList<ToDoList> getList(){
        return taskList;
    }
    public void addTask(ToDoList task){
        taskList.add(task);
    }
    public void clearTaskList(){
        taskList.clear();
    }
    public void removeTask(int position){
        taskList.remove(position);
    }

}

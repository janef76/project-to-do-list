package com.example.janeflucker.todolist;

import java.io.Serializable;

/**
 * Created by janeflucker on 24/03/2018.
 */

public class Task implements Serializable {
    int id, completed;
    String taskName, taskDescription;

    public Task(int id, String taskName, String taskDescription, int completed) {
        this.id = id;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.completed = completed;
    }

    public int getId() {
        return this.id;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public int getCompleted() {
        return this.completed;
    }
}

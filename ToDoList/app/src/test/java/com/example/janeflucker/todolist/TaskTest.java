package com.example.janeflucker.todolist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by janeflucker on 29/03/2018.
 */

public class TaskTest {

    Task task;

    @Before
    public void before() {
        task = new Task("Shopping", "Go to shop");
    }

    @Test
    public void hasTaskName() {
        assertEquals("Shopping", task.getTaskName());
    }

    @Test
    public void hasTaskDescription() {
        assertEquals("Go to shop", task.getTaskDescription());
    }
}

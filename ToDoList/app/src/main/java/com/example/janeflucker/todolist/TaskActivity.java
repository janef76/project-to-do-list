package com.example.janeflucker.todolist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {
//
//    List<Task> taskList;
    SQLiteDatabase toDoList;
//    ListView listViewTasks;
//    TaskAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_item);

        TextView taskName = findViewById(R.id.taskName);
        TextView taskDescription = findViewById(R.id.taskDescription);

        Intent intent = getIntent();
        Task selectedTask = (Task) intent.getSerializableExtra("task");

        Log.d("taskActivity", selectedTask.getTaskName());

        taskName.setText(selectedTask.getTaskName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);

        return true;
    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.activity_task, menu);
//
//        return true;
//    }
//        taskDescription.setText(selectedTask.getTaskDescription());


//
//        listViewTasks = (ListView) findViewById(R.id.listTasks);
//        taskList = new ArrayList<>();
//
//        toDoList = openOrCreateDatabase("toDoList", MODE_PRIVATE, null);
//
//        showAllTasksFromDatabase();


//    public void getView(int position, View listViewItem, ViewGroup parent) {

//        Task currentTask = getItem(position);


//        adapter = new TaskAdapter(this, R.layout.activity_main, taskList, toDoList);
//
//        listViewTasks.setAdapter(adapter);
//    }
}

package com.example.janeflucker.todolist;

import android.app.Activity;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends BaseActivity {

    EditText taskName, taskDescription;

//    completed;

    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

         taskName = findViewById(R.id.taskName);
         taskDescription = findViewById(R.id.taskDescription);
         db = new DbHelper(this);

        //
//        Log.d("taskActivity", selectedTask.getTaskName());
//        Log.d("taskActivity", selectedTask.getTaskDescription());
//
//        taskName.setText(selectedTask.getTaskName());
//        taskDescription.setText(selectedTask.getTaskDescription());

//        editTaskName = (EditText)findViewById(R.id.taskName);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);

        return true;
    }

    public void onAddButtonClick(View clickView) {
        boolean taskAdded = db.addTask(
                taskName.getText().toString(),
                taskDescription.getText().toString()
//                completed.getText().toString()
        );
        if (taskAdded == true)
            Toast.makeText(TaskActivity.this, "Task added", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(TaskActivity.this, "Task not added", Toast.LENGTH_SHORT).show();
    }


//    @Override
//    public void onAddButtonClick(View view) {
//        switch (view.getId()) {
//            case R.id.addTask:
//                dbHelper.addTask("", "", false);
//        }
//    }



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

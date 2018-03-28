package com.example.janeflucker.todolist;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class TaskActivity extends BaseActivity {

    EditText taskName, taskDescription;
    CheckBox completed;

    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

         taskName = findViewById(R.id.taskNameEdit);
         taskDescription = findViewById(R.id.taskDescription);
         completed = findViewById(R.id.completed);

         db = new DbHelper(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);

        return true;
    }

    public void onAddButtonClick(View clickView) {

        Task task = new Task(
                taskName.getText().toString(),
                taskDescription.getText().toString()
        );

        boolean taskAdded = db.addTask(task);

        if (taskAdded == true)
            Toast.makeText(TaskActivity.this, "Task added", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(TaskActivity.this, "Task not added", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_task);

    }

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

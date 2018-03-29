package com.example.janeflucker.todolist;

import android.content.Intent;
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
    String name;
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

        name = taskName.getText().toString();

        Task task = new Task(
                name,
                taskDescription.getText().toString()
        );

        if (name.isEmpty() || name.trim().isEmpty()) {
            Toast.makeText(TaskActivity.this, "Task name can't be blank", Toast.LENGTH_SHORT).show();
        }
        else {
            db.addTask(task);
            setContentView(R.layout.activity_task);
            taskName = findViewById(R.id.taskNameEdit);
        }
    }

}



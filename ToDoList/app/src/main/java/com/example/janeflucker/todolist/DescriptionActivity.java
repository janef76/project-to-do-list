package com.example.janeflucker.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        TextView taskName = findViewById(R.id.taskName);
        TextView taskDescription = findViewById(R.id.taskDescription);

        Intent intent = getIntent();
        Task selectedTask = (Task) intent.getSerializableExtra("task");

        Log.d("taskActivity", selectedTask.getTaskName());

        taskName.setText(selectedTask.getTaskName());
        taskDescription.setText(selectedTask.getTaskDescription());
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);

        return true;
    }
}

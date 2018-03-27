package com.example.janeflucker.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DescriptionActivity extends BaseActivity {

    int id;
    EditText taskName, taskDescription;
    CheckBox completed;
    Task selectedTask;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        db = new DbHelper(this);

        taskName = findViewById(R.id.taskNameEdit);
        taskDescription = findViewById(R.id.taskDescription);
        CheckBox chkBox = (CheckBox)findViewById(R.id.completed);

        Intent intent = getIntent();
        selectedTask = (Task) intent.getSerializableExtra("task");

        Log.d("taskActivity", selectedTask.getTaskName());

        taskName.setText(selectedTask.getTaskName());
        taskDescription.setText(selectedTask.getTaskDescription());
//        chkBox.setText(selectedTask.getCompleted());
    }

    public void onEditButtonClick(View clickView) {
        boolean taskEdited = db.update(
                selectedTask.getId(),
                taskName.getText().toString(),
                taskDescription.getText().toString(),
                selectedTask.getCompleted()
        );
        if (taskEdited == true)
            Toast.makeText(this, "Task edited", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Task not edited", Toast.LENGTH_SHORT).show();
    }



}

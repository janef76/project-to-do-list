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

    EditText taskName, taskDescription;
    CheckBox chkBox;
    Task selectedTask;
    DbHelper db;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        db = new DbHelper(this);

        taskName = findViewById(R.id.taskNameEdit);
        taskDescription = findViewById(R.id.taskDescription);
        chkBox = findViewById(R.id.completed);

        Intent intent = getIntent();
        selectedTask = (Task) intent.getSerializableExtra("task");

//        Log.d("taskActivity", selectedTask.getTaskName());

        taskName.setText(selectedTask.getTaskName());
        taskDescription.setText(selectedTask.getTaskDescription());
        chkBox.setChecked(selectedTask.getCompleted() == 1 );
    }

    public void onEditButtonClick(View clickView) {

        int checked = 0;

        if(chkBox.isChecked()) {
            checked = 1;
        }

        name = taskName.getText().toString();

        Task task = new Task(
                selectedTask.getId(),
                name,
                taskDescription.getText().toString(),
                checked
        );

        if (name.isEmpty() || name.trim().isEmpty()) {
            Toast.makeText(this, "Task name cannot be blank", Toast.LENGTH_SHORT).show();
        } else {
            db.update(task);
            Toast.makeText(this, "Task updated", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void onDeleteButtonClick(View clickView) {
        int checked = 0;

        if(chkBox.isChecked()) {
            checked = 1;
        }

        Task task = new Task(
                selectedTask.getId(),
                taskName.getText().toString(),
                taskDescription.getText().toString(),
                checked
        );

        db.delete(task);

        setContentView(R.layout.activity_description);

        Toast.makeText(this, "Task is deleted", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

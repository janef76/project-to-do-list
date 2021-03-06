package com.example.janeflucker.todolist;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends BaseActivity {

    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DbHelper(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        ArrayList<Task> allTasks = db.allTasks();

        ListView listView = findViewById(R.id.listTasks);
        TaskAdapter taskAdapter = new TaskAdapter(this, allTasks);
        listView.setAdapter(taskAdapter);
    }

    public void onListItemClick(View listItem) {
        Task selectedTask = (Task) listItem.getTag();

        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("task", selectedTask);

        startActivity(intent);
    }

    public void onCheckboxTick(View checkBox) {
        Task selectedTask = (Task) checkBox.getTag();

        if(selectedTask.completed == 1) {
            selectedTask.completed = 0;
        } else {
            selectedTask.completed = 1;
        }

        db.update(selectedTask);
    }

}


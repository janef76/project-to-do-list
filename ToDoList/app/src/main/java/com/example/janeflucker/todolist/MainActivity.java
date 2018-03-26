package com.example.janeflucker.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DbHelper(this);
//        dbHelper.addTask("Shopping", "list of shopping", false);
//        dbHelper.addTask("Golf", "play golf at west linton", false);

        //dbHelper.getAlltasks();
//        Task task = new Task(1, "Shopping", "Shop", 0);

        ArrayList<Task> allTasks = dbHelper.allTasks(); //new ArrayList<>();
//        allTasks.add(task);

//        Toast.makeText(this, "values saved", Toast.LENGTH_SHORT).show();

        ListView listView = findViewById(R.id.listTasks);
        TaskAdapter taskAdapter = new TaskAdapter(this, allTasks);
        listView.setAdapter(taskAdapter);

    }

    public void onListItemClick(View listItem) {
        Task selectedTask = (Task) listItem.getTag();

        Log.d("MainActivity", selectedTask.getTaskName());

        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("task", selectedTask);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);

        return true;
    }

//    private void addTask() {
//        String name = addTask().getText().toString().trim();
//        String description = addDescription().getText().toString().trim();
//
//
//        if (inputsAreCorrect(name, salary)) {
//
//            String insertSQL = "INSERT INTO tasks \n" +
//                    "(name, description)\n" +
//                    "VALUES \n" +
//                    "(?, ?);";
//
//            .execSQL(insertSQL, new String[]{name, description});
//
//            Toast.makeText(this, "Task Added", Toast.LENGTH_SHORT).show();
//        }
//    }
}


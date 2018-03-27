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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends BaseActivity {

    SQLiteDatabase mDatabase;

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



    }

    @Override
    public void onResume() {
        super.onResume();

        ArrayList<Task> allTasks = dbHelper.allTasks(); //new ArrayList<>();
//        allTasks.add(task);

        Toast.makeText(this, "values saved", Toast.LENGTH_SHORT).show();

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

}

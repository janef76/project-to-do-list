package com.example.janeflucker.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.*;

/**
 * Created by janeflucker on 27/03/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);

        return true;
    }

    public void onAddMenuClick(MenuItem item) {
        Intent intent = new Intent(this, TaskActivity.class);
        startActivity(intent);
    }
}

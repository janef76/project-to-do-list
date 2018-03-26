package com.example.janeflucker.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by janeflucker on 26/03/2018.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "toDoList";
    private static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlTasks = "CREATE TABLE tasks(id INTEGER PRIMARY KEY AUTOINCREMENT, taskName TEXT, taskDescription TEXT, completed BOOLEAN);";

        sqLiteDatabase.execSQL(sqlTasks);
    }

    public boolean addTask(String taskName, String taskDescription, Boolean completed) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("taskName", taskName );
        contentValues.put("taskDescription", taskDescription);
        contentValues.put("completed", completed);
        db.insert("tasks", null, contentValues);
        db.close();
        return true;
    }

    public ArrayList<Task> allTasks() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Task> taskList = new ArrayList<>();

        Cursor cursorTasks = db.rawQuery("SELECT * FROM tasks", null);

        if (cursorTasks.moveToFirst()) {
            do {
                taskList.add(new Task(
                        cursorTasks.getInt(0),
                        cursorTasks.getString(1),
                        cursorTasks.getString(2),
                        cursorTasks.getInt(3)
                ));
            } while (cursorTasks.moveToNext());
        }
        cursorTasks.close();

        return taskList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sqlTasks = "DROP TABLE IF EXISTS tasks";

        sqLiteDatabase.execSQL(sqlTasks);

        onCreate(sqLiteDatabase);
    }
}

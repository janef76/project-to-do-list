package com.example.janeflucker.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.janeflucker.todolist.TaskContract.FeedEntry.COL_COMPLETED;
import static com.example.janeflucker.todolist.TaskContract.FeedEntry.COL_DESCRIPTION;
import static com.example.janeflucker.todolist.TaskContract.FeedEntry.COL_NAME;
import static com.example.janeflucker.todolist.TaskContract.FeedEntry.TABLE_NAME;

/**
 * Created by janeflucker on 26/03/2018.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "toDoList.db";
    private static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TaskContract.SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TaskContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public boolean addTask(Task task) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, task.getTaskName() );
        contentValues.put(COL_DESCRIPTION, task.getTaskDescription());
        contentValues.put(COL_COMPLETED, task.getCompleted());
        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if(result == -1)
            return false;
        else
            return true;
    }

    public ArrayList<Task> allTasks() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorTasks = db.rawQuery("SELECT * FROM " + TaskContract.FeedEntry.TABLE_NAME, null);

        ArrayList<Task> taskList = new ArrayList<>();

        if (cursorTasks.moveToFirst()) {
            do {

                Integer idIndex = cursorTasks.getColumnIndex(TaskContract.FeedEntry._ID);
                Integer id = cursorTasks.getInt(idIndex);

                Integer nameIndex = cursorTasks.getColumnIndex(TaskContract.FeedEntry.COL_NAME);
                String name = cursorTasks.getString(nameIndex);

                Integer descriptionIndex = cursorTasks.getColumnIndex(TaskContract.FeedEntry.COL_DESCRIPTION);
                String description = cursorTasks.getString(descriptionIndex);

                Integer completedIndex = cursorTasks.getColumnIndex(TaskContract.FeedEntry.COL_COMPLETED);
                Integer completed = cursorTasks.getInt(completedIndex);

            Task task = new Task(id, name, description, completed);

            taskList.add(task);

            } while (cursorTasks.moveToNext());
        }
        cursorTasks.close();

        return taskList;

    }

    public Boolean update(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_NAME, task.getTaskName() );
        contentValues.put(COL_DESCRIPTION, task.getTaskDescription());
        contentValues.put(COL_COMPLETED, task.getCompleted());
        return db.update(TABLE_NAME, contentValues, "_id = ?", new String[]{String.valueOf(task.getId())})>0;
    }

    public void delete(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();

        String selection = TaskContract.FeedEntry._ID + " id = ?";
        String[] selectionArgs = {String.valueOf(task.getId())};
        db.delete(TaskContract.FeedEntry.TABLE_NAME, selection, selectionArgs);
    }

}

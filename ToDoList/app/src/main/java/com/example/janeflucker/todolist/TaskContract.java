package com.example.janeflucker.todolist;

import android.provider.BaseColumns;

/**
 * Created by janeflucker on 28/03/2018.
 */


public final class TaskContract {

    private TaskContract() {}

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "tasks";
        public static final String COL_NAME = "taskName";
        public static final String COL_DESCRIPTION = "taskDescription";
        public static final String COL_COMPLETED = "completed";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TaskContract.FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FeedEntry.COL_NAME + " TEXT," +
                    FeedEntry.COL_DESCRIPTION + " TEXT," +
                    FeedEntry.COL_COMPLETED + " BOOLEAN)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

}



package com.example.janeflucker.todolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by janeflucker on 26/03/2018.
 */

public class TaskAdapter extends ArrayAdapter<Task> {



    public TaskAdapter(Context context, List<Task> taskList) {
        super(context, 0, taskList);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {

        Task currentTask = getItem(position);
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.task_item, parent,false);
        }

        TextView task = listItemView.findViewById(R.id.taskName);
        task.setText(currentTask.getTaskName());


        listItemView.setTag(currentTask);

        return listItemView;

//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(listLayoutRes, null);
//
//        TextView taskName = view.findViewById(R.id.taskName);
//        TextView taskDescription = view.findViewById(R.id.taskDescription);
//
//
//        return view;

    }
}

//        TextView description = listItemView.findViewById(R.id.description);
//        description.setText(currentTask.getTaskDescription());

package com.example.janeflucker.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
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

        final TextView task = listItemView.findViewById(R.id.taskNameEdit);
        task.setText(currentTask.getTaskName());

        CheckBox checkBox = listItemView.findViewById(R.id.checkBoxCompleted);
        boolean isChecked = currentTask.getCompleted() == 1;

        checkBox.setChecked( isChecked );

        checkBox.setTag(currentTask);
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

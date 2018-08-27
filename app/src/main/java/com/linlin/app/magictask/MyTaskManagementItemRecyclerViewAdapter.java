package com.linlin.app.magictask;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linlin.app.magictask.DataClass.TaskItem;
import com.linlin.app.magictask.DataClass.TaskItemList;
import com.linlin.app.magictask.TaskManagementItemFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyTaskManagementItemRecyclerViewAdapter extends RecyclerView.Adapter<MyTaskManagementItemRecyclerViewAdapter.ViewHolder> {

    private final TaskItemList taskItemList;
    private final OnListFragmentInteractionListener mListener;

    public MyTaskManagementItemRecyclerViewAdapter(TaskItemList paramTaskItemList, OnListFragmentInteractionListener listener) {
        taskItemList = paramTaskItemList;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_taskmanagementitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.taskItem = taskItemList.getTaskItemByIndex(position);
        holder.mTaskNameView.setText(taskItemList.getTaskItemByIndex(position).getTaskName());
        holder.mTimeTodoView.setText(taskItemList.getTaskItemByIndex(position).getTimeToDo().toString());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.taskItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTaskNameView;
        public final TextView mTimeTodoView;
        public TaskItem taskItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTaskNameView =  view.findViewById(R.id.task_name);
            mTimeTodoView =  view.findViewById(R.id.time_to_do);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTaskNameView.getText() + "'";
        }
    }
}

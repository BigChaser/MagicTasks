package com.linlin.app.magictask;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.FragmentManager;

import com.linlin.app.magictask.DataClass.TaskItem;
import com.linlin.app.magictask.TaskManagementItemFragment.OnListFragmentInteractionListener;

public class MainActivity extends AppCompatActivity implements OnListFragmentInteractionListener {

    private TextView mTextMessage;

    private FragmentManager fragManager;

    private TaskManagementItemFragment taskManagementFragment;

    private AddTaskFragment addTaskFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.today_tasks:
                    if (taskManagementFragment == null)
                        taskManagementFragment = new TaskManagementItemFragment();
                    fragManager.beginTransaction()
                            .replace(R.id.contentArea,taskManagementFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .addToBackStack(null)
                            .commit();
                    return true;
                case R.id.week_tasks:
                    if (addTaskFragment == null)
                        addTaskFragment = new AddTaskFragment();
                    fragManager.beginTransaction()
                            .replace(R.id.contentArea,addTaskFragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .addToBackStack(null)
                            .commit();
                    return true;
                case R.id.task_management:
                    mTextMessage.setText(R.string.title_task_management);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragManager = getSupportFragmentManager();

    }

    @Override
    public void onListFragmentInteraction(TaskItem item) {

    }
}

package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;
import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;
import java.util.List;

// to cache our list of task entry objects wrap in a live data object
public class MainViewModel extends AndroidViewModel {

    private LiveData<List<TaskEntry>> tasks;
    public MainViewModel(@NonNull final Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d("testtt", "Activiely retrieving the tasks from teh DataBase");
        tasks = database.taskDao().loadAllTasks();
    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }
}

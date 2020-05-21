package com.fashi.udacity_capstone;

import android.app.Application;
import android.util.Log;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.fashi.udacity_capstone.database.AppDatabase;
import com.fashi.udacity_capstone.database.ProfileEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<ProfileEntry>> tasks;
    private LiveData<List<ProfileEntry>> tasksFull;

    public MainViewModel(Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        tasks = database.profileDao().loadAllProfile();
    }

    public LiveData<List<ProfileEntry>> getProfile() {
        return tasks;
    }

    //
    public void search(String query) {

    }



}

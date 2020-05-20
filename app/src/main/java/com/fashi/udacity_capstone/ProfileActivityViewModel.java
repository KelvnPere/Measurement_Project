package com.fashi.udacity_capstone;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.fashi.udacity_capstone.database.AppDatabase;
import com.fashi.udacity_capstone.database.ProfileEntry;

public class ProfileActivityViewModel extends ViewModel {

    private LiveData<ProfileEntry> task;


    public ProfileActivityViewModel(AppDatabase database, int taskId) {
        task = database.profileDao().loadProfileById(taskId);
    }


    public LiveData<ProfileEntry> getTask() {
        return task;
    }
}
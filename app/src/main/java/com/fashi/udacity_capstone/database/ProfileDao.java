package com.fashi.udacity_capstone.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProfileDao {

    @Query("SELECT * FROM measurement")
    LiveData<List<ProfileEntry>> loadAllProfile();

    @Insert
    void insertTask(ProfileEntry profileEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(ProfileEntry profileEntry);

    @Delete
    void deleteTask(ProfileEntry profileEntry);

    @Query("SELECT * FROM measurement WHERE id = :id")
    LiveData<ProfileEntry> loadProfileById(int id);

}

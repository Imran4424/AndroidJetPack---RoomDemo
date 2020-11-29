package com.imran.android.roomdemo.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

/**
 * Created by Shah Md Imran Hossain on 30, November, 2020
 */

@Dao
public interface MainDao {
    // insert query
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

    // delete all query
    @Delete
    void reset(List<MainData> mainData);

    // update query
    @Query("UPDATE TextList SET text = :sText WHERE ID = :sID")
    void update(int sID, String sText);

    // get all data query
    @Query("SELECT * FROM TextList")
    List<MainData> getAll();
}

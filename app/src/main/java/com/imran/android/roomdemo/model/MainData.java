package com.imran.android.roomdemo.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by Shah Md Imran Hossain on 29, November, 2020
 */

@Entity(tableName = "TextList")
public class MainData implements Serializable {
    // create id column
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "text")
    private String text;


}

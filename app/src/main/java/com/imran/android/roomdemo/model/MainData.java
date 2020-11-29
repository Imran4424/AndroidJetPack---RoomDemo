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

    // create text column
    @ColumnInfo(name = "text")
    private String text;

    // Generate getter and setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

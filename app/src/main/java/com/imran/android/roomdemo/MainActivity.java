package com.imran.android.roomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.imran.android.roomdemo.model.MainData;
import com.imran.android.roomdemo.model.RoomDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editTextInput;
    Button addButton;
    Button resetButton;
    RecyclerView recyclerView;

    List<MainData> dataList = new ArrayList<>();
    RoomDB database;
    MainRecyclerAdapter mainRecyclerAdapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        addButton = findViewById(R.id.addButton);
        resetButton = findViewById(R.id.resetButton);
        recyclerView = findViewById(R.id.recyclerView);

        // initialize database
        database = RoomDB.getInstance(this);
        // store database value in data list
        dataList = database.mainDao().getAll();

        // initialize linear layout manager
        linearLayoutManager = new LinearLayoutManager(this);
        // set layout manager
        recyclerView.setLayoutManager(linearLayoutManager);

        // initialize adapter
        mainRecyclerAdapter = new MainRecyclerAdapter(this, dataList);
        // set adapter
        recyclerView.setAdapter(mainRecyclerAdapter);
    }
}
package com.imran.android.roomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.imran.android.roomdemo.model.MainData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editTextInput;
    Button addButton;
    Button resetButton;

    List<MainData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        addButton = findViewById(R.id.addButton);
        resetButton = findViewById(R.id.resetButton);
    }
}
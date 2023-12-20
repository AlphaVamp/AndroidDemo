package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.myapplication.adapter.UserAdapter;
import com.example.myapplication.database.DBHelper;
import com.example.myapplication.database.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn1;

    RecyclerView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button);
        btn1.setOnClickListener(view -> {
            startActivity(new Intent(this, Formactivity.class));
        });

        DBHelper dbHelper = new DBHelper(this);
        List<User> userList = dbHelper.read();

        UserAdapter userAdapter = new UserAdapter(userList,this);

        view = findViewById(R.id.recyclerView);
        view.setAdapter(userAdapter);
    }
}
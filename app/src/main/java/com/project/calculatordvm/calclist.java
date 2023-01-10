package com.project.calculatordvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class calclist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> resultsTV, workingsTV;
    DBHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calclist);
        DB = new DBHelper(this);
        resultsTV= new ArrayList<>();
        workingsTV= new ArrayList<>();
        recyclerView= findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this,resultsTV,workingsTV);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata()
    {
        Cursor cursor = DB.getdata();
        if (cursor.getCount()==0)
        {
            Toast.makeText(calclist.this,"No History Exists",Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext()) {
                resultsTV.add(cursor.getString(0));
                workingsTV.add(cursor.getString(1));
            }
        }
    }
}
package com.project.calculatordvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class calclist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> results, workings;
    DBHelper DB;
    MyAdapter adapter;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calclist);
        delete = findViewById(R.id.delete);
        DB = new DBHelper(this);
        results= new ArrayList<>();
        workings= new ArrayList<>();
        recyclerView= findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this,results,workings);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB.deletecalchistory();
                Toast.makeText(calclist.this,"History Deleted",Toast.LENGTH_SHORT).show();
            }
        });

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
                results.add(cursor.getString(0));
                workings.add(cursor.getString(1));
            }
        }
    }
}
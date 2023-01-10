package com.project.calculatordvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Scanner;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import org.mozilla.javascript.tools.jsc.Main;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import android.os.Bundle;

public class Array extends AppCompatActivity{
    EditText list1, list2;
    Button enter1,enter2,clear1,clear2,resultsfinal;
    ListView show1,show2;
    TextView arrayresult;
    ArrayList<Integer> addArray1 = new ArrayList<Integer>();
    ArrayList<Integer> addArray2 = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);

        list1 = (EditText)findViewById(R.id.editText1);
        list2 = (EditText)findViewById(R.id.editTextl2);
        enter1= (Button) findViewById(R.id.enterl1);
        enter2= (Button) findViewById(R.id.enterl2);
        clear1= (Button) findViewById(R.id.clearl1);
        clear2= (Button) findViewById(R.id.clearl2);
        show1= (ListView) findViewById(R.id.listview1);
        show2= (ListView) findViewById(R.id.listview2);
        resultsfinal= (Button) findViewById(R.id.resultfinal);
        arrayresult= (TextView) findViewById(R.id.arrayresult);

        enter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getInput1= list1.getText().toString();
                addArray1.add(Integer.valueOf(getInput1));
                ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(Array.this, android.R.layout.simple_list_item_1, addArray1);
                show1.setAdapter(adapter);
                ((EditText)findViewById(R.id.editText1)).setText("");

            }
        });
        enter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getInput2= list2.getText().toString();
                addArray2.add(Integer.valueOf(getInput2));
                ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(Array.this, android.R.layout.simple_list_item_1, addArray2);
                show2.setAdapter(adapter);
                ((EditText)findViewById(R.id.editTextl2)).setText("");

            }

        });
        resultsfinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultfinal = " ";
                int size1 = addArray1.size();
                int size2 = addArray2.size();
                if ( size1 != size2 ){
                    Toast.makeText(Array.this,"Error",Toast.LENGTH_SHORT).show();
                    return;

                }
                else (int i=0; i<size1; i++){
                    int num1= addArray1.get(i);
                    int num2= addArray2.get(i);
                    resultfinal += Integer.toString(num1 * num2)+" ";
                    resultsfinal.setText(resultfinal);

                }
            }
        });

    }

}
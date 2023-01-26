package com.project.calculatordvm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;


public class Array extends AppCompatActivity{
    EditText list1, list2;
    Button enter1,enter2,clear1,clear2,resultsfinal;
    ListView show1,show2;
    TextView arrayresult;
    ArrayList<Double> addArray1 = new ArrayList<>();
    ArrayList<Double> addArray2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);

        list1 = findViewById(R.id.editText1);
        list2 = findViewById(R.id.editTextl2);
        enter1= findViewById(R.id.enterl1);
        enter2= findViewById(R.id.enterl2);
        clear1= findViewById(R.id.clearl1);
        clear2= findViewById(R.id.clearl2);
        show1 = findViewById(R.id.listview1);
        show2 = findViewById(R.id.listview2);
        resultsfinal = findViewById(R.id.resultfinal);
        arrayresult =  findViewById(R.id.arrayresult);

        enter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getInput1= list1.getText().toString();
                addArray1.add(Double.valueOf(getInput1));
                ArrayAdapter<Double> adapter = new ArrayAdapter<Double>(Array.this, android.R.layout.simple_list_item_1, addArray1);
                show1.setAdapter(adapter);
                ((EditText)findViewById(R.id.editText1)).setText("");

            }
        });
        clear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean empty1 = addArray1.isEmpty();
                if (!empty1) {
                    int index = addArray1.size() - 1;
                    addArray1.remove(index);
                    ArrayAdapter<Double> adapter = new ArrayAdapter<Double>(Array.this, android.R.layout.simple_list_item_1, addArray1);
                    show1.setAdapter(adapter);
                    ((EditText) findViewById(R.id.editText1)).setText("");
                }
            }
        });
        clear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean empty2 = addArray2.isEmpty();
                if (!empty2) {
                    int index = addArray2.size() - 1;
                    addArray2.remove(index);
                    ArrayAdapter<Double> adapter = new ArrayAdapter<Double>(Array.this, android.R.layout.simple_list_item_1, addArray2);
                    show2.setAdapter(adapter);
                    ((EditText) findViewById(R.id.editTextl2)).setText("");
                }
            }
        });
        enter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getInput2= list2.getText().toString();
                addArray2.add(Double.valueOf(getInput2));
                ArrayAdapter<Double> adapter = new ArrayAdapter<Double>(Array.this, android.R.layout.simple_list_item_1, addArray2);
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
                else
                    for (int i=0; i<size1; i++){
                    double num1= addArray1.get(i);
                    double num2= addArray2.get(i);
                    resultfinal += Double.toString(num1 * num2)+" , ";
                    arrayresult.setText(resultfinal);

                }
            }
        });

    }

}
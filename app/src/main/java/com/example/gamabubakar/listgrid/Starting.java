package com.example.gamabubakar.listgrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Starting extends AppCompatActivity {
Spinner sp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        sp1=findViewById(R.id.spinner);
        final ArrayList<String>arr=new ArrayList<String>();
        arr.add("ListView");
        arr.add("GridView");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,arr);
        sp1.setAdapter(adapter);
        sp1.setSelection(1);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(arr.get(position).equals("GridView")){
                    Intent i=new Intent(Starting.this,MainActivity.class);
                    startActivity(i);
                }
                else{
                    Intent i=new Intent(Starting.this,List.class);
                    startActivity(i);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

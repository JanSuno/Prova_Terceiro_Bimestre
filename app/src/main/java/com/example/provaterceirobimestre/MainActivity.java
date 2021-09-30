package com.example.provaterceirobimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button insertStudent;
    private ListView studentsList;
    private ArrayList<Student> students = new ArrayList<Student>();
    private AdapterStudents adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentsList = findViewById(R.id.studentsList);

        insertStudent.setOnClickListener(new ButtonListener());

        adapter = new AdapterStudents(this, students);

        studentsList.setAdapter(adapter);
    }

        private class ButtonListener implements View.OnClickListener {

            @Override
            public void onClick(View view){

        }
    }
}
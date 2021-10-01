package com.example.provaterceirobimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class fillStudentList extends AppCompatActivity {

    private EditText insertName;
    private EditText insertGrade1;
    private EditText insertGrade2;
    private Button goBack;
    private Button cancelAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_student_list);
        goBack = (Button) findViewById( R.id.goBack);
        cancelAction = (Button) findViewById(R.id.cancelStudent);

        goBack.setOnClickListener( new ListenerButtonReturn() );
        cancelAction.setOnClickListener(new ListenerButtonCancel());
    }
    private class ListenerButtonReturn implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String name, gr1, gr2;
            double grade1, grade2, average;

            insertName = (EditText) findViewById(R.id.insertName);
            insertGrade1 = (EditText) findViewById(R.id.insertGrade1);
            insertGrade2 = (EditText) findViewById(R.id.insertGrade2);

            name = insertName.getText().toString();
            gr1 = insertGrade1.getText().toString();
            gr2 = insertGrade2.getText().toString();

            grade1 = Double.parseDouble(gr1);
            grade2 = Double.parseDouble(gr2);
            average = (grade1 + grade2)/2;

            Student student = new Student(name, grade1, grade2, average);

            Intent i = new Intent(getApplicationContext(), MainActivity.class);

            i.putExtra("Student", student);

            setResult(RESULT_OK, i);

            finish();
        }
    }
    private class ListenerButtonCancel implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            setResult(RESULT_CANCELED, i);
            finish();
        }
    }

}
//Integrantes: Lucas Aguiar Cera e Renan Wenzel

package com.example.provaterceirobimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button insertStudent;
    private ListView studentsList;
    private ArrayList<Student> students = new ArrayList<>();
    private AdapterStudents adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertStudent = findViewById(R.id.insertStudent);
        studentsList = findViewById(R.id.studentsList);

        insertStudent.setOnClickListener(new ButtonListener());

        adapter = new AdapterStudents(this, students);

        studentsList.setAdapter(adapter);

        studentsList.setLongClickable(true);
        studentsList.setOnItemClickListener(new LongListener());
        studentsList.setOnItemLongClickListener(new LongListener());
    }
    private class LongListener implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {String msg = "";
            msg += "Nome: " + students.get(i).getName() + "\n";
            msg += "Nota 1: " + students.get(i).getGrade1() + "\n";
            msg += "Nota 2: " + students.get(i).getGrade2() + "\n";
            try {
                msg += "\nMédia: " + students.get(i).getAverage();
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }catch (NumberFormatException ex) {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

            students.remove(i);

            adapter.notifyDataSetChanged();

            Toast.makeText(MainActivity.this, "Estudando removido!", Toast.LENGTH_SHORT).show();

            return true;
        }
    }

    private class ButtonListener implements View.OnClickListener {

            @Override
            public void onClick(View view) {
                Intent i = new Intent( getApplicationContext(), fillStudentList.class );
                startActivityForResult(i, 1);
            }
        }

    public void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Student student = (Student) i.getSerializableExtra("Student");
                students.add(student);
            }
        }
    }
}

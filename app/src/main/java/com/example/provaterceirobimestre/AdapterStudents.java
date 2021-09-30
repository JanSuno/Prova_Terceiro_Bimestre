package com.example.provaterceirobimestre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.android.material.internal.ViewOverlayImpl;

import java.util.ArrayList;

public class AdapterStudents extends ArrayAdapter<Student> {

    private Context context;

    private ArrayList<Student> students;

    public AdapterStudents(Context context, ArrayList<Student> students){
        super(context, R.layout.list, students);
        this.context = context;
        this.students = students;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater li = LayoutInflater.from(parent.getContext());

        View itemView = li.inflate(R.layout.list, parent, false);

        TextView lblName = itemView.findViewById(R.id.lblNome);
        TextView lblGrade1 = itemView.findViewById(R.id.lblNota1);
        TextView lblGrade2 = itemView.findViewById(R.id.lblNota2);
        TextView lblAverage = itemView.findViewById(R.id.lblMedia);

        lblName.setText(students.get(position).getName());
        lblAverage.setText(Double.toString(students.get(position).getAverage()));
        lblGrade1.setText(Double.toString(students.get(position).getGrade1()));
        lblGrade2.setText(Double.toString(students.get(position).getGrade2()));

        return itemView;
    }
}

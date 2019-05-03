package com.exemple.mysecondapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class ListeActivity extends AppCompatActivity {

    RecyclerView list_view;
    Button button1;
    ArrayList<Student> students = new ArrayList();
    StudentAdapter adapter;
    int order = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        list_view = (RecyclerView)findViewById(R.id.list_view);
        button1 = (Button)findViewById(R.id.button1);

        students.add(new Student("TEMGOUA Myriam"));
        students.add(new Student("MAGATCHUEN Danielle"));
        students.add(new Student("TCHOULE Vadaise"));
        students.add(new Student("BEAL Laureline"));
        students.add(new Student("DIDERO Mathieu"));
        students.add(new Student("MAKEMBE Paul"));
        students.add(new Student("SIELINOU Junior"));
        students.add(new Student("ARSENDEAU Quentin"));
        students.add(new Student("MOM"));
        students.add(new Student("MOCTAR"));
        students.add(new Student("BEAL "));
        students.add(new Student("DIDERO "));
        students.add(new Student("MAKEMBE "));
        students.add(new Student("SIELINOU "));
        students.add(new Student("ARSENDEAU "));
        students.add(new Student("MOMO"));
        students.add(new Student("MOCTAROP"));

        Collections.sort(students);
        adapter = new StudentAdapter(students);
        list_view.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        list_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {;
                for(int i=0;i<students.size();i++){
                    students.get(i).status = Student.Status.PRESENT;
                }
                adapter.notifyDataSetChanged();
            }

        });



    }

}

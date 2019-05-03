package com.exemple.mysecondapplication;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.style.UpdateLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by arsene on 25/02/2019.
 */


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {


    private ArrayList<Student> students;
    public StudentAdapter(ArrayList<Student> p_students)
    {
        students = p_students;
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Student student = students.get(position);
        holder.SetModel(student);
        holder.name.setText(student.name);
        holder.UpdateBackground(false);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private Student student;
        private RelativeLayout layout;


        public MyViewHolder(final View itemView) {
            super(itemView);

            name = ((TextView) itemView.findViewById(R.id.text_view));
            layout = (RelativeLayout)itemView.findViewById(R.id.list_item);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UpdateBackground(true);
                }
            });
        }
        public void SetModel(Student st)
        {
            student = st;
        }

        public void UpdateBackground(boolean fromclick)
        {
            if(fromclick)
            {
                switch (student.status)
                {
                    case UNSET:
                        student.status = Student.Status.PRESENT;
                        break;
                    case PRESENT:
                        student.status = Student.Status.ABSENT;
                        break;
                    case ABSENT:
                        student.status = Student.Status.LATE;
                        break;
                    case LATE:
                        student.status = Student.Status.PRESENT;
                        break;
                }
                layout.setBackgroundColor(student.getColor());
            }
            else if(student.status != Student.Status.UNSET)
                layout.setBackgroundColor(student.getColor());
        }


    }

}

package com.exemple.mysecondapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CalendarActivity  extends AppCompatActivity {

    private EditText Course;
    private EditText StartTime;
    private EditText EndTime;
    private EditText Class;
    private Button Send;
    private Button Logout;
    //private Spinner Spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        Course = (EditText)findViewById(R.id.idCourse);
        StartTime = (EditText)findViewById(R.id.idStartTime);
        EndTime = (EditText)findViewById(R.id.idEndTime);
        Class = (EditText)findViewById(R.id.idClass);
        Send = (Button)findViewById(R.id.idButtonSend);
        Logout = (Button)findViewById(R.id.idButtonLogout);
        //Spinner = (Spinner)findViewById(R.id.spinner);


        /*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.logout, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner.setAdapter(adapter);
        Spinner.setOnItemSelectedListener(this);*/

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Course.getText().toString(), StartTime.getText().toString(), EndTime.getText().toString(), Class.getText().toString());
            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity.sp.edit().putBoolean("logged",false).apply();
                Intent intent = new Intent(CalendarActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


    private void validate(String userCourse, String userStartTime, String userEndTime, String userClass){
        if((userCourse.equals("Info")) && (userStartTime.equals("00:00")) && (userEndTime.equals("00:00")) && (userClass.equals("I2"))){
            Intent intent = new Intent(CalendarActivity.this, ListeActivity.class);
            startActivity(intent);
        }else{
            Send.setEnabled(false);
        }
    }

    /*@Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //String text = adapterView.getItemAtPosition(i).toString();
        //Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(CalendarActivity.this, LoginActivity.class);
        startActivity(intent);
    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }*/
}

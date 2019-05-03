package com.exemple.mysecondapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.exemple.mysecondapplication.network.MyIntentService;

public class LoginActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    static SharedPreferences sp;

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            String data = intent.getStringExtra(MyIntentService.SERVICE_MESSAGE);

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Name = (EditText)findViewById(R.id.idName);
        Password = (EditText)findViewById(R.id.idPassword);
        Login = (Button)findViewById(R.id.idButton);
        sp = getSharedPreferences("login", MODE_PRIVATE);

        if(sp.getBoolean("logged",false))
        {
            validate(Name.getText().toString(), Password.getText().toString());
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
                sp.edit().putBoolean("logged",true).apply();
            }
        });
    }


    private void validate(String userName, String userPassword){
        if((userName.equals("myriam")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
            startActivity(intent);
        }else{
            Login.setEnabled(false);
        }
    }
}

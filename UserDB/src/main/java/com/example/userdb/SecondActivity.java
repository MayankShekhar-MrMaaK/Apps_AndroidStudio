package com.example.userdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class SecondActivity extends AppCompatActivity{
    TextView txtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secactivity);
        txtName = (TextView) findViewById(R.id.tV);
        Intent intename = getIntent();
        String n = (String) intename.getSerializableExtra("NAME");
        String p = (String) intename.getSerializableExtra("PHONE");
        String ad = (String) intename.getSerializableExtra("ADDRESS");
        String zi = (String) intename.getSerializableExtra("ZIP");
        String m = (String) intename.getSerializableExtra("EMAIL");
        String dob = (String) intename.getSerializableExtra("DOB");
        String sta = (String) intename.getSerializableExtra("STATE");
        n=n.toUpperCase();
        txtName.setText("Welcome " + n +", \nPhoneNo. :- "+p+", \nADDRESS :- "+ad
                + ", \nZIP code. :- "+zi+", \nSTATE. :- "+sta+", \nE-MAIL. is :- "+m+", \nYou were born on :  "+dob
        );
    }
}
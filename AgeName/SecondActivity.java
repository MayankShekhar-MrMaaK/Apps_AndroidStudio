package com.example.agename;
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
        txtName = (TextView) findViewById(R.id.textView3);
        Intent intename = getIntent();
        String g = (String) intename.getSerializableExtra("GENDER");
        String n = (String) intename.getSerializableExtra("NAME");
        String a = (String) intename.getSerializableExtra("AGE");
        n=n.toUpperCase();
        txtName.setText("Welcome " + n +", \nYou are :"+g+" \nYour AGE is:- "+a);
    }
}

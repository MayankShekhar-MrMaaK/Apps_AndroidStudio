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
        String out="",outp="";
        String g = (String) intename.getSerializableExtra("GENDER");
        String n = (String) intename.getSerializableExtra("NAME");
        String a = (String) intename.getSerializableExtra("AGE");
        String[] name=n.split(" ");
        for(int i=0;i<name.length-1;i++)
            out=out+name[i].charAt(0)+" ";
        if(g.equals("MALE")) outp="Mr. "+out.trim().toUpperCase()+" "+name[name.length-1].toUpperCase();
        else outp="Mrs. "+out.trim().toUpperCase()+" "+name[name.length-1].toUpperCase();
        txtName.setText("Welcome " + outp +", \nYou are :"+g+" \nYour AGE is:- "+a);
    }
}

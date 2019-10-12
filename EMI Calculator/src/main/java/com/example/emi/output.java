package com.example.emi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class output  extends AppCompatActivity {
TextView to;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);
        to=(TextView) findViewById(R.id.textView);
        String emi="",tp="";
        Intent intent=getIntent();
        int i=(int) intent.getSerializableExtra("ID");
        if(i==1){
                emi=(String) intent.getSerializableExtra("FEMI");
                tp=(String)  intent.getSerializableExtra("FTP");
                to.setText(" REDUCING RATE EMI= ₹ "+emi+"\n\nTotal Payable Amount= ₹ "+tp);}
        if(i==2)
        {
            emi=(String) intent.getSerializableExtra("REMI");
            tp=(String)  intent.getSerializableExtra("RTP");
            to.setText(" FLAT RATE EMI= ₹ "+emi+"\n\nTotal Payable Amount= ₹ "+tp);
        }



    }
}


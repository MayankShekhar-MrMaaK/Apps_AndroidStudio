package com.example.emi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class flatrate  extends AppCompatActivity {
Button fb;
String d1="",d2="",d3="";
double p=0,r=0,t=0;
 double em=0;
 int id=1;
String emi="",tp="";
EditText fe1,fe2,fe3 ;
TextView  ft1,ft2,ft3,ft4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flatrate);
        fb=(Button) findViewById(R.id.fb);
        fe1=(EditText) findViewById(R.id.fe1);
        fe2=(EditText)findViewById(R.id.fe2);
        fe3=(EditText)findViewById(R.id.fe3);
        ft1=(TextView) findViewById(R.id.ft1);
        ft2=(TextView) findViewById(R.id.ft2);
        ft3=(TextView) findViewById(R.id.ft3);
        ft4=(TextView) findViewById(R.id.ft4);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d1= (fe1.getText().toString());
                d2= (fe2.getText().toString());
                d3= fe3.getText().toString();

                if(d1.isEmpty()||d2.isEmpty()||d3.isEmpty()){
                    Toast.makeText(flatrate.this,":Please fill the VALUES:", Toast.LENGTH_SHORT).show();
                }
                else{

                p=Double.parseDouble(d1);
                r=Double.parseDouble(d2);
                t=Double.parseDouble(d3);
                r=r/(r*100);
                Intent fout=new Intent(flatrate.this,output.class);
                em=(p*r*(Math.pow((1+r),t)))/(Math.pow((1+r),t)-1);

                emi=Double.toString(em);
                tp=Double.toString(em+p);
                fout.putExtra("FEMI", emi);
                fout.putExtra("FTP", tp);
                fout.putExtra("ID", id);
                startActivity(fout);}
            }
        });

    }
}


package com.example.emi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class redrate  extends AppCompatActivity {
Button b;
EditText re1,re2,re3 ;
TextView  rt1,rt2,rt3,rt4;
    String d1,d2,d3;
    double p,r,t;
    double em=0;
    int id=2;
    String emi="",tp="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redrate);
        b=(Button) findViewById(R.id.b);
        re1=(EditText) findViewById(R.id.re1);
        re2=(EditText)findViewById(R.id.re2);
        re3=(EditText)findViewById(R.id.re3);
        rt1=(TextView) findViewById(R.id.rt1);
        rt2=(TextView) findViewById(R.id.rt2);
        rt3=(TextView) findViewById(R.id.rt3);
        rt4=(TextView) findViewById(R.id.rt4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d1= (re1.getText().toString());
                d2= (re2.getText().toString());
                d3= (re3.getText().toString());

                if(d1.isEmpty()||d2.isEmpty()||d3.isEmpty()){
                    Toast.makeText(redrate.this,":Please fill the VALUES:", Toast.LENGTH_SHORT).show();
                }
                else{

                    p=Double.parseDouble(d1);
                    r=Double.parseDouble(d2);
                    t=Double.parseDouble(d3);
                Intent fout=new Intent(redrate.this,output.class);

                em=(p*r*t)/100;
                emi=Double.toString(em);
                tp=Double.toString(em+p);
                fout.putExtra("REMI", emi);
                fout.putExtra("RTP", tp);
                fout.putExtra("ID", id);
                startActivity(fout);}
            }
        });
    }
}


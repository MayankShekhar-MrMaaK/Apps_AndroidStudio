package com.example.incometaxcalculator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class MainActivity extends AppCompatActivity {
TextView t1;
EditText ed1,ed2;
Button b1;
double tax=1;
    BigDecimal b=new BigDecimal(1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView) findViewById(R.id.t1);
        ed1=(EditText) findViewById(R.id.ed1);
        ed2=(EditText) findViewById(R.id.ed2);
        t1.setText("INCOME TAX \n 2020-2021");
        b1=(Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age=ed1.getText().toString();
                String income=ed2.getText().toString();
                int a=Integer.parseInt(age);
                double inc=Double.parseDouble(income);
                BigDecimal t=new BigDecimal(inc, MathContext.DECIMAL64);

                if(a>60){
                    if(inc<250000) b=t.multiply(BigDecimal.valueOf(0));
                    if(inc>=250000&&inc<750000) b=t.multiply(BigDecimal.valueOf(5/100));
                    if(inc>=750000&&inc<1450000) b=t.multiply(BigDecimal.valueOf(10/100));
                    if(inc>=1450000&&inc<3050000) b=t.multiply(BigDecimal.valueOf(15/100));
                    if(inc>=3050000&&inc<5050000) b=t.multiply(BigDecimal.valueOf(20/100));
                    if(inc>=5050000) b=t.multiply(BigDecimal.valueOf(25/100));
                }
                 if(a>=25&&a<60)
                    {if(inc<250000) b=t.multiply(BigDecimal.valueOf(0));;
                         if(inc>=250000&&inc<750000) b=t.multiply(BigDecimal.valueOf(10/100));
                          if(inc>=750000&&inc<1450000) b=t.multiply(BigDecimal.valueOf(20/100));
                             if(inc>=1450000&&inc<3050000) b=t.multiply(BigDecimal.valueOf(250/100));
                         if(inc>=3050000&&inc<5050000) b=t.multiply(BigDecimal.valueOf(30/100));
                         if(inc>=5050000) b=t.multiply(BigDecimal.valueOf(35/100));
                }
                if(a<25) b=t.multiply(BigDecimal.valueOf(0));
                Intent intent =new Intent(MainActivity.this,output.class);
                intent.putExtra("Tax",b);
                startActivity(intent);
            }
        });

    }
}



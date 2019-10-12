package com.example.incometaxcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.BigInteger;

public class output extends AppCompatActivity {
TextView to;
    BigDecimal tout=new BigDecimal(1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        to=(TextView) findViewById(R.id.textView2);
        Intent iout=getIntent();
        tout= (BigDecimal) iout.getSerializableExtra("Tax");
        to.setText("Income Tax Payable = "+tout);
    }
}

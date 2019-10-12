package com.example.incometaxcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class secact extends AppCompatActivity {
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secact);
        t1=(TextView)findViewById(R.id.textView);
        t1.setText("WELCOME TO \n INCOME TAX CALCULATOR \n [2020-2021]");
        Thread t= new Thread()
        {
            @Override
            public void run() {
                try
                {
                    sleep(1000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent i=new Intent(secact.this,MainActivity.class);
                    startActivity(i);
                }
            }

        };
        t.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

package com.example.emi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button b1,b2;
TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        t1=(TextView) findViewById(R.id.ft1);
        t2=(TextView) findViewById(R.id.textView5);
        t2.setText("Flat Interest\n" +
                "\n" +
                "Flat interest refers to charging interest on the full original loan amount, rather than on the declining balance.\n\n\n" +
                "Reducing Balance - Equal installments\n" +
                "\n" +
                "Interest is computed at periodic intervals on the amount of the original principal that has not yet been repaid. Since the borrower only pays interest on that amount of original principal that has not yet been repaid, interest paid is smaller every period.");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fz=new Intent(MainActivity.this,flatrate.class);
                startActivity(fz);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rz=new Intent(MainActivity.this,redrate.class);
                startActivity(rz);
            }
        });





    }
}

package com.example.g1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Thread t1=new Thread()
        {
            @Override
            public void run() {
                try{
                    sleep(500);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                 finally
                {
                    Intent intent= new Intent(intro.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        t1.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

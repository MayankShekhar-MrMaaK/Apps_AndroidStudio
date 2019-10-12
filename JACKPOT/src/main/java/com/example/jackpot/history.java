package com.example.jackpot;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class history extends MainActivity {
    public Button b, button2;
    private ValueEventListener vl, vd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        b = (Button) findViewById(R.id.hbutton);
        button2 = (Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.setValue("0");
                myRef1.setValue("0");
                ja = 0;
                u = 0;

            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vl = new ValueEventListener() {

                    TextView oop = (TextView) findViewById(R.id.textView10);

                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String jack = dataSnapshot.getValue().toString();
                        //String oops=dataSnapshot.child("UNFORTUNATE").getValue().toString();
                        oop.setText(jack + " times");
                        Log.d(TAG, "onCancelled: TIMES"+jack);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                };
                myRef.addValueEventListener(vl);

                vd = new ValueEventListener() {

                    TextView oop2 = (TextView) findViewById(R.id.textView4);

                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String jack = dataSnapshot.getValue().toString();
                        //String oops=dataSnapshot.child("UNFORTUNATE").getValue().toString();
                        oop2.setText(jack + " times");
                        Log.d(TAG, "onCancelled: TIMES"+jack);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                };
                myRef1.addValueEventListener(vd);
            }

        });

    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        myRef.removeEventListener(vl);
        myRef1.removeEventListener(vd);
    }
}


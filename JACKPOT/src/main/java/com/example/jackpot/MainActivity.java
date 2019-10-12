package com.example.jackpot;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    public Button button0;
    public static final String TAG = "MainActivity";
    String i="",j="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.history){
            history();
        }
        if(id==R.id.browse){
           // browse();
        }
        return super.onOptionsItemSelected(item);
    }

    public void history()
    {
        Intent intent= new Intent(this,history.class);
        startActivity(intent);
    }
   /* public void browse()
    {
        Intent intent =anothertab.intent;

        Intent intent= new Intent(this,browse.class);
        startActivity(intent);
        String url = "https://www.google.com";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }*/

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("JACKII");
    DatabaseReference myRef1 = database.getReference("UNFORTUNATE");
    static int ja=0,u=0;

    public void addListenerOnButton() {


        button0 = (Button) findViewById(R.id.button0);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                j1 m1 = new j1();
                 i = m1.jack1(1);
                TextView t1 = (TextView) findViewById(R.id.textView2);
                t1.setText(i);
                j2 m2 = new j2();
                 j = m2.jack2(1);
                TextView t2 = (TextView) findViewById(R.id.textView3);
                t2.setText(j);
                boolean retval = i.equals(j);

                if (retval) {
                    Toast.makeText(getApplicationContext(),"JACKPOT",Toast.LENGTH_SHORT).show();
                    ja++;
                    myRef.setValue(ja);
                }
                else {
                    Toast.makeText(getApplicationContext(),"GOOD LUCK NEXT TIME",Toast.LENGTH_SHORT).show();
                    u++;
                    myRef1.setValue(u);
                }


            }
        });

    }

    class j1 {
        public String jack1(int len) {
            String numbers = "123456789";
            Random ran = new Random();
            char[] otp = new char[len];
            for (int i = 0; i < len; i++) {
                otp[i] =
                        numbers.charAt(ran.nextInt(numbers.length()));
            }
            String msg = new String(otp);

            return msg;
        }
    }

    class j2{
        public String jack2(int len) {
            String numbers = "123456789";
            Random ran = new Random();
            char[] otp = new char[len];
            for (int i = 0; i < len; i++) {
                otp[i] =
                        numbers.charAt(ran.nextInt(numbers.length()));
            }
            String msg = new String(otp);
            return msg;
        }
    }
}

package com.example.jackpot;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
    public Button button0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j1 m1 = new j1();
                String i = m1.jack1(1);
                TextView t1 = (TextView) findViewById(R.id.textView2);
                t1.setText(i);
                j2 m2 = new j2();
                String j = m2.jack2(1);
                TextView t2 = (TextView) findViewById(R.id.textView3);
                t2.setText(j);
                boolean retval = i.equals(j);
                if (retval) {
                    Toast.makeText(getApplicationContext(),"JACKPOT",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"GOOD LUCK NEXT TIME",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    class j1 extends Thread {
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

    class j2 extends Thread {
        public String jack2(int len) {
            String numbers = "123456789";
            Random ran = new Random();
            char[] otp = new char[len];
            for (int i = 0; i < len; i++) {
                otp[i] =
                        numbers.charAt(ran.nextInt(numbers.length()));
            }
            String msg = new String(otp);
            return msg;//returns message
        }
    }
}

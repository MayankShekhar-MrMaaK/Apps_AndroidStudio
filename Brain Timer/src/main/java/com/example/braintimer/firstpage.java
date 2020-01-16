package com.example.braintimer;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
public class firstpage extends AppCompatActivity {
    GridLayout grid;
    ImageView useit;
    TextView qn,answer,score,timer,finalplay;
    int a=0,b=0,incorrect,options,location,myscore=0,noquestion=0;
    ArrayList<Integer> op=new ArrayList<Integer>();
    Button b1,b2,b3,b4,play;
    String pr;
    public void generateqn()
    {   op.clear();
        Random r=new Random();
        a=r.nextInt(50);
        b=r.nextInt(50);
        a+=11;
        b+=13;
        qn.setText(a+" + "+b);
        options=r.nextInt(4);
        for(int i=0;i<4;i++){
            if(i==options) {op.add(a+b);
                location=i;}
            else {
                incorrect=r.nextInt(126);
                while(incorrect==(a+b))
                    incorrect=r.nextInt(126);
                op.add(incorrect);
            }
        }
        b1.setText(op.get(0).toString());
        b2.setText(op.get(1).toString());
        b3.setText(op.get(2).toString());
        b4.setText(op.get(3).toString());
    }
    public void onanswer(View view)
    {
        answer.setVisibility(View.VISIBLE);

        pr=view.getTag().toString();
        if(pr.equals(Integer.toString(location)))
        {   myscore++;
            answer.setBackgroundColor(Color.parseColor("#ff99cc00"));
            answer.setText("CORRECT");
        }
        else {
            answer.setBackgroundColor(Color.parseColor("#ffff4444"));
            answer.setText("WRONG");
        }
        noquestion++;
        score.setText(Integer.toString(myscore)+"/"+Integer.toString(noquestion));
        generateqn();
    }
    public void playagain(View view)
    {   myscore=0;
        noquestion=0;
        timer.setText("30s");
        score.setText("SCORE");
        grid.setVisibility(View.VISIBLE);

        generateqn();
        play.setVisibility(View.INVISIBLE);
        useit.setVisibility(View.INVISIBLE);
        finalplay.setVisibility(View.INVISIBLE);

        new CountDownTimer(15100,1000)
        {
            public void onTick(long millisUntilFinished){
                timer.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }
            @Override
            public void onFinish() {
                finalplay.setVisibility(View.VISIBLE);
                useit.setVisibility(View.VISIBLE);
                grid.setVisibility(View.INVISIBLE);
                timer.setText("0s");

                answer.setVisibility(View.INVISIBLE);
                finalplay.setText("SCORE IS "+Integer.toString(myscore)+"/"+Integer.toString(noquestion));
                play.setVisibility(View.VISIBLE);
            }
        }.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpage);
        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);
        b3=(Button) findViewById(R.id.b3);
        b4=(Button) findViewById(R.id.b4);
        score=(TextView) findViewById(R.id.score);
        useit=(ImageView) findViewById(R.id.useit);
        qn=(TextView) findViewById(R.id.qn);
        timer=(TextView) findViewById(R.id.timer);
         grid=(GridLayout) findViewById(R.id.grid);
        answer=(TextView) findViewById(R.id.answer);
        finalplay=(TextView) findViewById(R.id.finalplay);
        play=(Button) findViewById(R.id.play);
        playagain(findViewById(R.id.play));
    }
}

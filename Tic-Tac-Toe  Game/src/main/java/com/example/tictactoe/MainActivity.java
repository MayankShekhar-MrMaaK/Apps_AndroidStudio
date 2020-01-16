package com.example.tictactoe;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    int im=0;//activestate 0-cross 1-circle
    int[] gamestate={2,2,2,2,2,2,2,2,2};// no doible tap allowed
    int[][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameon=true;
    public void drop(View view) {
        ImageView counter = (ImageView) view;
        int tag=Integer.parseInt(counter.getTag().toString());
        if (gamestate[tag]==2&&gameon) {
            gamestate[tag]=im;
            counter.setTranslationZ(-1000f);
            if (im == 0) {
                counter.setImageResource(R.drawable.del);
                im = 1;
            } else {
                counter.setImageResource(R.drawable.cir);
                im = 0;
            }
            counter.animate().translationZBy(1000f).setDuration(1000);
            for (int[] position:win){
                if((gamestate[position[0]]==gamestate[position[1]])&&(gamestate[position[1]]==gamestate[position[2]])
                  &&(gamestate[position[0]]!=2))
                {   gameon=false;
                    TextView d=(TextView) findViewById(R.id.textView2);

                    if(gamestate[position[0]]==1)
                        d.setText("CIRCLE WINS");
                    else
                        d.setText("CROSS WINS");
                    LinearLayout l=(LinearLayout) findViewById(R.id.msg);
                    l.setVisibility(View.VISIBLE);
                }
                else{
                    boolean gameover=true;
                    for(int i:gamestate) {
                        if (i == 2)
                            gameover = false;
                    }
                     if(gameover)
                     {          TextView d=(TextView) findViewById(R.id.textView2);
                         d.setText("MATCH DRAWN");
                         LinearLayout l=(LinearLayout) findViewById(R.id.msg);
                         l.setVisibility(View.VISIBLE);
                     }
                }
            }
        }
    }
    public void playagain(View view)
    {   gameon=true;
        LinearLayout l=(LinearLayout) findViewById(R.id.msg);
        l.setVisibility(View.INVISIBLE);
        im=0;
        for(int i=0;i<gamestate.length;i++)
            gamestate[i]=2;
        GridLayout g=(GridLayout) findViewById(R.id.grid);
        for(int i=0;i<g.getChildCount();i++)
            ((ImageView)g.getChildAt(i)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
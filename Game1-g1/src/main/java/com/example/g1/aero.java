package com.example.g1;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
public class aero extends View {
    private Bitmap fish[]=new Bitmap[2];
    private int fishx=10,fishy,fishspeed,canvaswidth,canvasheight;
    private boolean touch=false;
    private  Bitmap background12;
    private  Bitmap life[]= new Bitmap[2];
    private Paint scorePaint=new Paint();
    public aero(Context context) {
        super(context);
        fish[0]= BitmapFactory.decodeResource(getResources(),R.drawable.f1);
        fish[1]= BitmapFactory.decodeResource(getResources(),R.drawable.f2);
        background12=BitmapFactory.decodeResource(getResources(),R.drawable.background12);
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(70);
        scorePaint.setTypeface(Typeface.DEFAULT);
        scorePaint.setAntiAlias(true);
        life[0]=BitmapFactory.decodeResource(getResources(),R.drawable.hearts);
        life[1]=BitmapFactory.decodeResource(getResources(),R.drawable.heart_grey);
        fishy=550;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvaswidth=canvas.getWidth();
        canvasheight=canvas.getHeight();
        canvas.drawBitmap(background12,0,0,null);
        int minfishy=fish[0].getHeight();
        int maxfishy=canvasheight-fish[0].getHeight()*3;
        fishy+=fishspeed;
        if(fishy<minfishy)
        {
            fishy=minfishy;
        }
        if(fishy>maxfishy)
        {
            fishy=maxfishy;
        }
        fishspeed+=2;
        if(touch)
        {
            canvas.drawBitmap(fish[1],fishx,fishy,null);
            touch=false;
        }
        else
        {
            canvas.drawBitmap(fish[0],fishx,fishy,null);
        }
        canvas.drawText("SCORE",40,60,scorePaint);
        canvas.drawBitmap(life[0],580,10,null);
        canvas.drawBitmap(life[0],680,10,null);
        canvas.drawBitmap(life[0],780,10,null);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            touch=true;
            fishspeed=-40;
        }return true;
    }
}
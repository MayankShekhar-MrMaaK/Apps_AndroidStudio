package com.example.agename;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup sex;
    RadioButton mf;
    Button b;
    EditText te;
    DatePicker p1,p2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sex=(RadioGroup)findViewById(R.id.radioGroup);
        p2=(DatePicker)findViewById(R.id.datePicker1);
        p1=(DatePicker)findViewById(R.id.datePicker2);
        te=(EditText) findViewById(R.id.ed1);
        b=(Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,gender;
                name=te.getText().toString();
                int selectedId = sex.getCheckedRadioButtonId();
                mf = (RadioButton) findViewById(selectedId);
                if(selectedId==-1||name==null){
                    Toast.makeText(MainActivity.this,":Please fill the DETAILS:", Toast.LENGTH_SHORT).show();
                }
                else{
                    gender=mf.getText().toString();
                    String agef=age(p1,p2);
                    Intent intent =new Intent(MainActivity.this,SecondActivity.class);
                    intent.putExtra("GENDER", gender);
                    intent.putExtra("NAME", name);
                    intent.putExtra("AGE", agef);
                    startActivity(intent);
                }
            }
        });

    }
    public String age(DatePicker p1,DatePicker p2)
    {   int d,m,y;
        int d1=p1.getDayOfMonth();
        int d2=p2.getDayOfMonth();
        int m1=p1.getMonth()+1;
        int m2=p2.getMonth()+1;
        int y1=p1.getYear();
        int y2=p2.getYear();
        if(m2>m1){ y1-=1; m1+=12;}
        if(d2>d1){ m1-=1; d1+=30;}
        d=d1-d2;
        m=m1-m2;
        y=y1-y2;
        return (y+" YEAR "+m+" MONTH "+d+" DAY");
    }
}

package com.example.userdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText na,pho,ad,zip,em;
Button b;
String name,phone,addre,zi,e,date,st;
DatePicker d;
Boolean bo,v,pc;
Spinner sp;
String[] state={"Uttrakhand","Uttar Pradesh","Bihar","Delhi","Punjab","Rajasthan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        na=(EditText) findViewById(R.id.name);
        pho=(EditText) findViewById(R.id.phone);
        ad=(EditText) findViewById(R.id.add);
        zip=(EditText) findViewById(R.id.editText3);
        em=(EditText) findViewById(R.id.editText4);
        d=(DatePicker) findViewById(R.id.datePicker2);
        sp=(Spinner) findViewById(R.id.spinner);
        sp.getDropDownVerticalOffset();
        ArrayAdapter arr=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,state);
        sp.setAdapter(arr);

        b=(Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDetails();
            }
        });



    }
    public  void getDetails()
    {
        name = na.getText().toString();
        phone = pho.getText().toString();
        addre=ad.getText().toString();
        zi=zip.getText().toString();
        e=em.getText().toString();
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        v= e.matches(regex);
        pc=phone.length()==10;
        st=sp.getSelectedItem().toString();
        date=d.getDayOfMonth()+"-"+(d.getMonth()+1)+"-"+d.getYear();

        bo=(name.isEmpty()||phone.isEmpty()||addre.isEmpty()||zi.isEmpty()||e.isEmpty()||st.isEmpty());
        if (bo||(!v||!pc)) {
            if (bo) Toast.makeText(MainActivity.this, ":Please fill the DETAILS:", Toast.LENGTH_SHORT).show();
            else {
                if(!pc)Toast.makeText(MainActivity.this, ":Please Enter Valid 10 digit PhoneNo.:", Toast.LENGTH_SHORT).show();
                else Toast.makeText(MainActivity.this, ":Please Enter Valid E-MAIL:", Toast.LENGTH_SHORT).show();
            }}else {
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("NAME",name);
            intent.putExtra("PHONE",phone);
            intent.putExtra("ADDRESS",addre);
            intent.putExtra("ZIP",zi);
            intent.putExtra("EMAIL",e);
            intent.putExtra("DOB",date);
            intent.putExtra("STATE",st);
            startActivity(intent);


        }
    }
}

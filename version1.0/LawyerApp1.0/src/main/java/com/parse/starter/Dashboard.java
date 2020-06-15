#Author: Shraddha Kantal
package com.parse.starter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class Dashboard extends AppCompatActivity {
    Button lawregbutton;Button ngoregbutton,updatelawyerbutton, updatengobutton,viewlawyerbutton,viewngobutton;
    TextView tv;
    int x,y=0;
    public void click1()
    {
        Intent intent = new Intent(this,LawyerReg.class);
        startActivity(intent);
    }
    public void click2()
    {
        Intent intent1= new Intent(this,NGOReg.class);
        startActivity(intent1);
    }
    public void click3()
    {
        Intent intent2= new Intent(this,Updatelawyer.class);
        startActivity(intent2);
    }
    public void click4()
    {
        Intent intent = new Intent(this,Updatengo.class);
        startActivity(intent);
    }
    public void click5()
    {
        Intent intent = new Intent(this,viewLawyer.class);
        startActivity(intent);
    }

    public void click6()
    {
        Intent intentx = new Intent(this,resultpage.class);
        startActivity(intentx);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setTitle("Dashboard");
        Intent intent=getIntent();

        lawregbutton  = (Button)findViewById(R.id.newLawReg);
        ngoregbutton  = (Button)findViewById(R.id.newNgoReg);
        updatelawyerbutton = (Button)findViewById(R.id.updatelawyer);
        updatengobutton = (Button)findViewById(R.id.updatengo);
        viewlawyerbutton = (Button)findViewById(R.id.viewlawyer);
        viewngobutton = (Button)findViewById(R.id.viewngo);
        tv=findViewById(R.id.dashid);



        lawregbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click1();
            }
        });
    ngoregbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1){
                click2();
            }
        });
        updatelawyerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1){
                click3();
            }
        });
        updatengobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1){
                click4();
            }
        });
        viewlawyerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1){
                click5();
            }
        });
        viewngobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view9) {
                click6();
            }
        });

       ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Lawyer");
        query.whereEqualTo("Username", ParseUser.getCurrentUser().getUsername());

        query.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    tv.setText("My Registration ID: "+object.getString("RegistrationID"));
                    lawregbutton.setVisibility(View.INVISIBLE);
                    ngoregbutton.setVisibility(View.INVISIBLE);
                    updatengobutton.setVisibility(View.INVISIBLE);

                } else {
                   if(e.getCode()==ParseException.OBJECT_NOT_FOUND){
                    x=1;


                    }
                    else{
                        //error
                    }
                }
            }
        });
        ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>("Ngo");
        query1.whereEqualTo("Username", ParseUser.getCurrentUser().getUsername());

        query1.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    tv.setText("My Registration ID: "+object.getString("RegistrationID"));
                    ngoregbutton.setVisibility(View.INVISIBLE);
                    lawregbutton.setVisibility(View.INVISIBLE);
                    updatelawyerbutton.setVisibility(View.INVISIBLE);
                } else {
                    if(e.getCode()==ParseException.OBJECT_NOT_FOUND){
                        y=1;
                    }
                    else{
                        //error
                    }

                }

                if(x==1 && y==1) {
                    tv.setVisibility(View.INVISIBLE);
                    updatelawyerbutton.setVisibility(View.INVISIBLE);
                    updatengobutton.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

}


































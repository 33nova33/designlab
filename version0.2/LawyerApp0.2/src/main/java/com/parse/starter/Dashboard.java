#Author: Shraddha Kantal
package com.parse.starter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Dashboard extends AppCompatActivity {
    Button lawregbutton;Button ngoregbutton,updatelawyerbutton, updatengobutton,viewlawyerbutton,viewngobutton;
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
        String r1="ngo";
        //intentx.putExtra("viewngoclicked",r1);
        startActivity(intentx);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setTitle("Dashboard");
        lawregbutton  = (Button)findViewById(R.id.newLawReg);
        ngoregbutton  = (Button)findViewById(R.id.newNgoReg);
        updatelawyerbutton = (Button)findViewById(R.id.updatelawyer);
        updatengobutton = (Button)findViewById(R.id.updatengo);
        viewlawyerbutton = (Button)findViewById(R.id.viewlawyer);
        viewngobutton = (Button)findViewById(R.id.viewngo);
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



    }

}


































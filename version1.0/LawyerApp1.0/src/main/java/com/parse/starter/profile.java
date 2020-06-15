#Author: Shraddha Kantal
package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class profile extends AppCompatActivity {
    String h,s="";ScrollView r3;
    Intent intent = getIntent();
    TextView namez,locationz,almaz,numberz,emailz,specialz,expz;
    TextView namey,locationy,financey,emaily,yearsy,numbery,blank,idall;
     Button rev;String x2;
    TextView revlongx;

    public void clickp(View v)
    {

        Intent intent1 = new Intent(profile.this,review.class);
        intent1.putExtra("laworngoname",x2);
        startActivity(intent1);
    }
    public  void sendinguna(String una){
        ParseQuery<ParseObject> querynew = new ParseQuery<ParseObject>("ReviewTable");

        querynew.whereEqualTo("lawyerorngoUsername",una);
        querynew.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    if (objects.size() > 0) {
                        for (ParseObject objectn : objects) {
                            h="Client: "+objectn.getString("ClientName")
                                    +"\n"+"Date of visit: "+
                                    objectn.getString("DateofVisit")+
                                    "\n"+"Reason for consultation: "+ objectn.getString("ReasonofVisit")+
                                    "\n"+"Experience: "+objectn.getString("Experience")+"\n\n";


                            s=h+s;
                        }

                        revlongx.setText(s);
                    }

                } else {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        r3=findViewById(R.id.activity_profile);
        r3.getBackground().setAlpha(160);

        rev =findViewById(R.id.writereview);
        Intent intent = getIntent();
        String nx = intent.getStringExtra("categorywithname");
        char x1 = nx.charAt(0);
         x2 = nx.substring(1);
        rev =findViewById(R.id.writereview);
         revlongx=findViewById(R.id.revlong);

        if (x1 == 'l') {

            namez = findViewById(R.id.line1);
            almaz = findViewById(R.id.line4);
            expz = findViewById(R.id.line5);
            emailz = findViewById(R.id.line6);
            numberz = findViewById(R.id.line7);
            locationz = findViewById(R.id.line3);
            specialz = findViewById(R.id.line2);
            idall=findViewById(R.id.lineid);

            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Lawyer");
            query.whereEqualTo("Username", x2);

            query.getFirstInBackground(new GetCallback<ParseObject>() {
                public void done(ParseObject object, ParseException e) {
                    if (e == null) {
                        namez.setText("Name: "+object.getString("Name"));
                        idall.setText("Registration ID: "+object.getString("RegistrationID"));
                        setTitle(object.getString("Name") + "'s" + " profile");
                        specialz.setText("Specialization: "+object.getString("Specialization"));
                        locationz.setText("Location: "+object.getString("Location"));
                        expz.setText("Years Of Experience: "+object.getString("YearsofExperience"));
                        almaz.setText("Alma Mater: "+object.getString("AlmaMater"));
                        numberz.setText("Contact Number: "+object.getString("ContactNumber"));
                        emailz.setText("Email ID: "+object.getString("Email"));
                       sendinguna(x2);
                    } else {
                        // Something is wrong
                    }
                }
            });



        }
        else{
            namey = findViewById(R.id.line1);
            numbery = findViewById(R.id.line4);
            emaily = findViewById(R.id.line5);
            locationy = findViewById(R.id.line3);
            yearsy = findViewById(R.id.line2);
            financey = findViewById(R.id.line6);
            blank=findViewById(R.id.line7);
            idall=findViewById(R.id.lineid);
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Ngo");
           query.whereEqualTo("Username",x2);

            query.getFirstInBackground(new GetCallback<ParseObject>() {
                public void done(ParseObject object, ParseException e) {
                    if (e == null) {
                        namey.setText("Name: "+object.getString("Name"));
                        setTitle(object.getString("Name") + "'s" + " profile");
                        idall.setText("Registration ID: "+object.getString("RegistrationID"));
                        yearsy.setText("Years of operation: "+object.getString("YearsOfOperation"));
                        locationy.setText("Location: "+object.getString("Location"));
                        financey.setText("Financial Aid Provided: "+object.getString("FinancialAid"));
                        numbery.setText("Contact Number: "+object.getString("ContactNumber"));
                        emaily.setText("Email Id: "+object.getString("Email"));
                         blank.setText("");
                       sendinguna(x2);
                    } else {
                        // Something is wrong
                    }
                }
            });
        }






        rev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickp(view);
            }
        });

    }
}

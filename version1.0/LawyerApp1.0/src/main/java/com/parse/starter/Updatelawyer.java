package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.GetCallback;
import com.parse.SaveCallback;
import com.parse.DeleteCallback;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Updatelawyer extends AppCompatActivity {
    EditText Lname2,Lalma2,Lnumber2,Lemail2,Lexp2,Llocation2,Lspecial2; Button Lupdate2;
    TextView id;
    int found=0;View b;
    public  void showdashboard3()
    {
        Intent intent= new Intent(getApplicationContext(),Dashboard.class);
        startActivity(intent);
    }
    public void lupdateClicked(View view) {
        Lname2 = findViewById(R.id.Lnamex);
        Lalma2 = findViewById(R.id.Lalmax);
        Lnumber2 = findViewById(R.id.Lnumberx);
        Lemail2 = findViewById(R.id.Lemailx);
        Lexp2 = findViewById(R.id.Lexpx);
        Llocation2 = findViewById(R.id.Llocationx);
        Lspecial2 = findViewById(R.id.Lspecialx);


        ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>("Lawyer");
        query1.whereEqualTo("Username", ParseUser.getCurrentUser().getUsername());
       //delete extra
        query1.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
        object.deleteInBackground(new DeleteCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    // Success
                } else {
                    // Failed
                }
            }
        });
    } else {
        // Something is wrong
    }
     }
     });






        if (Lname2.getText().toString().matches("") || Lexp2.getText().toString().matches("") || Llocation2.getText().toString().matches("") || Lalma2.getText().toString().matches("") || Lnumber2.getText().toString().matches("") || Lemail2.getText().toString().matches("") || Lspecial2.getText().toString().matches("")) {
            Toast.makeText(this, "All fields mandatory.", Toast.LENGTH_SHORT).show();
        } else {
            ParseObject lawyer = new ParseObject("Lawyer");
            lawyer.put("Username", ParseUser.getCurrentUser().getUsername());
            lawyer.put("Name", Lname2.getText().toString());
            lawyer.put("Specialization", Lspecial2.getText().toString());
            lawyer.put("Location", Llocation2.getText().toString());
            lawyer.put("YearsofExperience",Lexp2.getText().toString());
            lawyer.put("AlmaMater", Lalma2.getText().toString());
            lawyer.put("ContactNumber", Lnumber2.getText().toString());
            lawyer.put("Email", Lemail2.getText().toString());

            lawyer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(Updatelawyer.this, "Update Successful!", Toast.LENGTH_SHORT).show();
                        showdashboard3();
                    } else {
                        Toast.makeText(Updatelawyer.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                }
            });
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatelawyer);
        Lname2 = findViewById(R.id.Lnamex);
        Lalma2 = findViewById(R.id.Lalmax);
        Lnumber2 = findViewById(R.id.Lnumberx);
        Lemail2 = findViewById(R.id.Lemailx);
        Lexp2 = findViewById(R.id.Lexpx);
        Llocation2 = findViewById(R.id.Llocationx);
        Lspecial2 = findViewById(R.id.Lspecialx);
         Lupdate2 =findViewById(R.id.Lupdatex);
        id=findViewById(R.id.idtextl);

        b=findViewById(R.id.backgroundLayout1);
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Lawyer");
        query.whereEqualTo("Username", ParseUser.getCurrentUser().getUsername());

        query.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    id.setText("My registration ID: "+object.getString("RegistrationID"));
                   Lname2.setText(object.getString("Name"));
                    Lspecial2.setText(object.getString("Specialization"));
                   Llocation2.setText(object.getString("Location"));
                    Lexp2.setText(object.getString("YearsofExperience"));
                    Lalma2.setText(object.getString("AlmaMater"));
                    Lnumber2.setText(object.getString("ContactNumber"));
                    Lemail2.setText(object.getString("Email"));


                } else {

                }
            }
        });


        Lupdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view3){
                lupdateClicked(view3);
            }
        });
    }
}

#Author: Shraddha Kantal
package com.parse.starter;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.DeleteCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class Updatengo extends AppCompatActivity {
    EditText Nname2,Nnumber2,Nemail2,Nyears2,Nlocation2,Nfinance2; Button Nupdate2;
    View b1;
    public  void showdashboard4()
    {
        Intent intent= new Intent(getApplicationContext(),Dashboard.class);
        startActivity(intent);
    }
    public void nupdateClicked(View view) {
        Nname2 = findViewById(R.id.Nnamex);
        Nnumber2 = findViewById(R.id.Nnumberx);
        Nemail2 = findViewById(R.id.Nemailx);
        Nyears2 = findViewById(R.id.Nyearsx);
        Nlocation2 = findViewById(R.id.Nlocationx);
        Nfinance2 = findViewById(R.id.Nfinancex);


        ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>("Ngo");
        query1.whereEqualTo("Username", ParseUser.getCurrentUser().getUsername());

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

        if (Nname2.getText().toString().matches("") || Nfinance2.getText().toString().matches("") || Nlocation2.getText().toString().matches("") || Nyears2.getText().toString().matches("") || Nnumber2.getText().toString().matches("") || Nemail2.getText().toString().matches("")) {
            Toast.makeText(this, "All fields mandatory.", Toast.LENGTH_SHORT).show();
        } else {
            ParseObject ngo = mapParser(ParseUser.getCurrentUser().getUsername(),
                    Nname2.getText().toString(),
                    Nlocation2.getText().toString(),
                    Nfinance2.getText().toString(),
                    Nyears2.getText().toString(),
                    Nnumber2.getText().toString(),
                    Nemail2.getText().toString()
            );

            ngo.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(Updatengo.this, "Update Successful!", Toast.LENGTH_SHORT).show();
                        showdashboard4();
                    } else {
                        Toast.makeText(Updatengo.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public ParseObject mapParser(String username, String name, String location, String financialAid, String years,
                                 String contact, String email) {
        ParseObject ngo = new ParseObject("Ngo");
        ngo.put("Username", username);
        ngo.put("Name", name);
        ngo.put("Location", location);
        ngo.put("FinancialAid", financialAid);
        ngo.put("YearsOfOperation", years);
        ngo.put("ContactNumber", contact);
        ngo.put("Email", email);
        return ngo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatengo);
        Nname2 = findViewById(R.id.Nnamex);
        Nnumber2 = findViewById(R.id.Nnumberx);
        Nemail2 = findViewById(R.id.Nemailx);
        Nyears2 = findViewById(R.id.Nyearsx);
        Nlocation2 = findViewById(R.id.Nlocationx);
        Nfinance2 = findViewById(R.id.Nfinancex);
        Nupdate2 =findViewById(R.id.Nupdatex);
        b1=findViewById(R.id.activity_ngoreg);
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Ngo");
        query.whereEqualTo("Username", ParseUser.getCurrentUser().getUsername());

        query.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (e == null) {
                    Nname2.setText(object.getString("Name"));
                    Nyears2.setText(object.getString("YearsOfOperation"));
                    Nlocation2.setText(object.getString("Location"));
                    Nfinance2.setText(object.getString("FinancialAid"));
                    Nnumber2.setText(object.getString("ContactNumber"));
                    Nemail2.setText(object.getString("Email"));


                } else {
                    
                    if(e.getCode()==ParseException.OBJECT_NOT_FOUND){

                        b1.setVisibility(View.INVISIBLE);
                        Toast.makeText(Updatengo.this, "No Registered NGO to Update!", Toast.LENGTH_SHORT).show();
                        showdashboard4();

                    }
                    else{
                        //error
                    }
                }
            }
        });

        Nupdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view4){
                nupdateClicked(view4);
            }
        });
    }
}

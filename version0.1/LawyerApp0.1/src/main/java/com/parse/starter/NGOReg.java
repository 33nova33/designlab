#Author: Shraddha Kantal
package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class NGOReg extends AppCompatActivity {
    EditText Nname1,Nfinance1,Nnumber1,Nemail1,Nyears1,Nlocation1;
    Button Nregister1;
    public  void showdashboard2()
    {
        Intent intent= new Intent(getApplicationContext(),Dashboard.class);
        startActivity(intent);
    }

    public void registerClicked1(View view) {
        Nname1 = findViewById(R.id.Nname);
        Nfinance1 = findViewById(R.id.Nfinance);
        Nnumber1 = findViewById(R.id.Nnumber);
        Nemail1 = findViewById(R.id.Nemail);
        Nyears1 = findViewById(R.id.Nyears);
        Nlocation1 = findViewById(R.id.Nlocation);
        if (Nname1.getText().toString().matches("") || Nfinance1.getText().toString().matches("") || Nlocation1.getText().toString().matches("") || Nyears1.getText().toString().matches("") || Nnumber1.getText().toString().matches("") || Nemail1.getText().toString().matches("")) {
            Toast.makeText(this, "All fields mandatory.", Toast.LENGTH_SHORT).show();
        } else {
            ParseObject ngo = mapParser(ParseUser.getCurrentUser().getUsername(),
                    Nname1.getText().toString(),
                    Nlocation1.getText().toString(),
                    Nfinance1.getText().toString(),
                    Nyears1.getText().toString(),
                    Nnumber1.getText().toString(),
                    Nemail1.getText().toString()
            );

            ngo.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(NGOReg.this, "Registration Successful!.", Toast.LENGTH_SHORT).show();
                        showdashboard2();
                    } else {
                        Toast.makeText(NGOReg.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.activity_ngoreg);
        Nname1 = findViewById(R.id.Nname);
        Nfinance1 = findViewById(R.id.Nfinance);
        Nnumber1 = findViewById(R.id.Nnumber);
        Nemail1 = findViewById(R.id.Nemail);
        Nyears1 = findViewById(R.id.Nyears);
        Nlocation1 = findViewById(R.id.Nlocation);

        Nregister1= findViewById(R.id.Nregister);
        Nregister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1){
                registerClicked1(view1);
            }
        });

    }
}

#Author: Shraddha Kantal
package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class review extends AppCompatActivity {
    EditText na,dat,rea,desc;
    Button sub;
String un;
  public  void showprofile()
   {
        Intent intentb= new Intent(review.this,profile.class);
        startActivity(intentb);
    }
    public  void submitClicked()
    {

        if (na.getText().toString().matches("") || dat.getText().toString().matches("") || rea.getText().toString().matches("") || desc.getText().toString().matches("")) {
            Toast.makeText(this, "All fields mandatory.", Toast.LENGTH_SHORT).show();
        } else {
            ParseObject revx = new ParseObject("ReviewTable");
            revx.put("clientUsername", ParseUser.getCurrentUser().getUsername());
            revx.put("lawyerorngoUsername", un);
            revx.put("ClientName", na.getText().toString());
            revx.put("DateofVisit", dat.getText().toString());
            revx.put("ReasonofVisit",rea.getText().toString());
            revx.put("Experience",desc.getText().toString());

            revx.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(review.this, "Feedback Saved!", Toast.LENGTH_SHORT).show();
                       showprofile();
                    } else {
                        Toast.makeText(review.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                }
            });
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        Intent intentp = getIntent();
         un = intentp.getStringExtra("laworngoname");
        setTitle("Give Review");

        na = findViewById(R.id.revname);
        dat = findViewById(R.id.date);
         desc= findViewById(R.id.description);

        rea = findViewById(R.id.reason);
        sub= findViewById(R.id.subbutton);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1){
                submitClicked();
            }
        });

    }
}

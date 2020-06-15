#Author: Shraddha Kantal
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

import com.parse.DeleteCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class LawyerReg extends AppCompatActivity
 {

   EditText Lname1,Lalma1,Lnumber1,Lemail1,Lexp1,Llocation1,Lspecial1,Lid1;
     Button Lregister1;View bg;

   public  void showdashboard1()
   {
       Intent intent= new Intent(getApplicationContext(),Dashboard.class);

       startActivity(intent);
   }

     public void registerClicked(View view) {
         Lname1 = findViewById(R.id.Lname);
         Lalma1 = findViewById(R.id.Lalma);
         Lnumber1 = findViewById(R.id.Lnumber);
         Lemail1 = findViewById(R.id.Lemail);
        Lexp1 = findViewById(R.id.Lexp);
         Llocation1 = findViewById(R.id.Llocation);
         Lspecial1 = findViewById(R.id.Lspecial);
         Lid1=findViewById(R.id.idlaw);
         if (Lid1.getText().toString().matches("") || Lname1.getText().toString().matches("") || Lexp1.getText().toString().matches("") || Llocation1.getText().toString().matches("") || Lalma1.getText().toString().matches("") || Lnumber1.getText().toString().matches("") || Lemail1.getText().toString().matches("") || Lspecial1.getText().toString().matches("")) {
             Toast.makeText(this, "All fields mandatory.", Toast.LENGTH_SHORT).show();
         } else {
             ParseObject lawyer = new ParseObject("Lawyer");
             lawyer.put("Username", ParseUser.getCurrentUser().getUsername());
             lawyer.put("RegistrationID", Lid1.getText().toString());
             lawyer.put("Name", Lname1.getText().toString());
             lawyer.put("Specialization", Lspecial1.getText().toString());
            lawyer.put("Location", Llocation1.getText().toString());
             lawyer.put("YearsofExperience",Lexp1.getText().toString());
            lawyer.put("AlmaMater", Lalma1.getText().toString());
             lawyer.put("ContactNumber", Lnumber1.getText().toString());
             lawyer.put("Email", Lemail1.getText().toString());

             lawyer.saveInBackground(new SaveCallback() {
                 @Override
                 public void done(ParseException e) {
                     if (e == null) {
                         Toast.makeText(LawyerReg.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                         showdashboard1();
                     } else {
                         Toast.makeText(LawyerReg.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                     }


                 }
             });
         }


     }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyerreg);
         Lid1=findViewById(R.id.idlaw);
        Lname1 = findViewById(R.id.Lname);
        Lalma1 = findViewById(R.id.Lalma);
         Lnumber1 = findViewById(R.id.Lnumber);
        Lemail1 = findViewById(R.id.Lemail);
         Lexp1 = findViewById(R.id.Lexp);
        Llocation1 = findViewById(R.id.Llocation);
        Lspecial1 = findViewById(R.id.Lspecial);
        Lregister1= findViewById(R.id.Lregister);
        bg=findViewById(R.id.backgroundLayout1x);


        Lregister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1){
                registerClicked(view1);
            }
        });




    }
}

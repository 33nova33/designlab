package com.parse.starter;
import android.util.Log;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;

public class viewLawyer extends AppCompatActivity {
public String res;RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_lawyer);

         rl=findViewById(R.id.view_lawyer);
        rl.getBackground().setAlpha(150);
       // ParseObject lawyer = new ParseObject("LawyerCategories");
        setTitle("Lawyer Categories");
        final ListView listView=(ListView)findViewById(R.id.list1);
        final ArrayList<String> lcat=new ArrayList<>();
        lcat.add("Criminal");
        lcat.add("Family");
        lcat.add("Corporate");
        lcat.add("Civil");
        lcat.add("Personal Injury");
        lcat.add("Business");
        lcat.add("Real Estate");
        lcat.add("Immigration");
        lcat.add("Divorce");
        lcat.add("Child Abuse");
        lcat.add("Women's Rights");

       ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,lcat);
        listView.setAdapter(arrayAdapter);
       // Log.i("testbtewm",lcat.toString());
        //Log.i("test","2");
       /* ParseObject lc = new ParseObject("LawyerCategories");
        lc.put("Category","Criminal" );
        lc.put("Category","Family" );
        lc.put("Category","Corporate");
        lc.put("Category","Civil" );
        lc.put("Category","Personal Injury");
        lc.put("Category","Business");
        lc.put("Category","Real Estate");
        lc.put("Category","Immigration");
        lc.saveInBackground();*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              //  Toast.makeText(viewLawyer.this,lcat.get(i).toString(),Toast.LENGTH_SHORT).show();
             res=lcat.get(i);
                Intent intent = new Intent(viewLawyer.this,resultpage.class);
                // String r1="lawyer"+res;
                intent.putExtra("Listviewclickvalue",res);
                startActivity(intent);
            }
        }

        );

    }
}

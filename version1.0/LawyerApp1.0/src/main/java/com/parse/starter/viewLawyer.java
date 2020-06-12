package com.parse.starter;
import android.util.Log;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class viewLawyer extends AppCompatActivity {
public String res;RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_lawyer);

        rl=findViewById(R.id.view_lawyer);
        rl.getBackground().setAlpha(150);
        setTitle("Lawyer Categories");
        final ListView listView=(ListView)findViewById(R.id.list1);

        final  ArrayList<String> catg=new ArrayList<String>();
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,catg);

        ParseQuery<ParseObject> query =ParseQuery.getQuery("Lawyer");
        query.selectKeys(Arrays.asList("Specialization"));
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){

                    for(ParseObject object : objects){
                        if(catg.contains(object.getString("Specialization"))){
                            //already exists
                        }
                        else {
                            catg.add(object.getString("Specialization"));
                        }
                    }
                    listView.setAdapter(arrayAdapter);
                }
                else{
                    Toast.makeText(viewLawyer.this, e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             res=catg.get(i);
                Intent intent = new Intent(viewLawyer.this,resultpage.class);
                intent.putExtra("Listviewclickvalue",res);
                startActivity(intent);
            }
        }

        );

    }
}

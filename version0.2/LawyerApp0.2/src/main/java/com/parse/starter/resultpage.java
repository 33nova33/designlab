package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ListView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import android.util.Log;

import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import java.util.List;

public class resultpage extends AppCompatActivity {
    public String res;RelativeLayout r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultpage);
        r2=findViewById(R.id.activity_resultpage);
        r2.getBackground().setAlpha(160);

        Intent intent = getIntent();

        final ListView listViewx = (ListView) findViewById(R.id.listView3);
        final ArrayList<String> law3 = new ArrayList<String>();
        final ArrayList<String> lawx = new ArrayList<String>();
        final ArrayAdapter arrayAdapterx = new ArrayAdapter(this, android.R.layout.simple_list_item_1, law3);

       if(intent.hasExtra("Listviewclickvalue")){
           String category1 = intent.getStringExtra("Listviewclickvalue");
            setTitle( category1 + " Lawyers Feed");
            ParseQuery<ParseObject> qu = ParseQuery.getQuery("Lawyer");
            qu.whereEqualTo("Specialization", category1);
            qu.addAscendingOrder("Name");
            qu.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, ParseException e) {
                    if (e == null) {
                        if (objects.size() > 0) {
                            for (ParseObject object1 : objects) {
                                String n = object1.getString("Name");
                                String s = object1.getString("Username");
                                law3.add(n);
                                lawx.add(s);

                            }
                            listViewx.setAdapter(arrayAdapterx);

                        }

                    } else {
                        e.printStackTrace();
                    }
                }
            });

           listViewx.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                            {

                                                @Override
                                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                                    res=lawx.get(i);
                                                    Intent intent = new Intent(resultpage.this,profile.class);
                                                    String r2="l"+res;
                                                    intent.putExtra("categorywithname",r2);
                                                    startActivity(intent);
                                                }
                                            }

           );

        }

        else {
            setTitle("NGO Feed");

            ParseQuery<ParseObject> qu1 = ParseQuery.getQuery("Ngo");

           qu1.addAscendingOrder("Name");
            qu1.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, ParseException e) {
                    if (e == null) {
                        if (objects.size() > 0) {
                            for (ParseObject object1 : objects) {

                                law3.add(object1.getString("Name"));
                                lawx.add(object1.getString("Username"));

                            }
                            listViewx.setAdapter(arrayAdapterx);

                        }

                    } else {
                        e.printStackTrace();
                    }
                }
            });
           listViewx.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                            {

                                                @Override
                                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                                    //  Toast.makeText(viewLawyer.this,lcat.get(i).toString(),Toast.LENGTH_SHORT).show();
                                                    res=lawx.get(i);
                                                    Intent intent = new Intent(resultpage.this,profile.class);
                                                    String r1="n"+res;
                                                    intent.putExtra("categorywithname",r1);
                                                    startActivity(intent);
                                                }
                                            }

           );


        }

    }
}

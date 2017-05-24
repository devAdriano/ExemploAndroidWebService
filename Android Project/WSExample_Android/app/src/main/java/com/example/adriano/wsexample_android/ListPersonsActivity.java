package com.example.adriano.wsexample_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Handler;
import android.widget.Toast;

import java.util.ArrayList;

public class ListPersonsActivity extends AppCompatActivity implements Runnable
{

    private ListView listPersons;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_persons);

        listPersons = (ListView) findViewById(R.id.list_allPersons);

    }//OnCreate


    @Override
    protected void onResume()
    {
        super.onResume();

        Thread t = new Thread(this);
        t.start();

    }//OnResume

    public void run()
    {

        PersonDAO listPerson = new PersonDAO();
        ArrayList<Person> returnList = listPerson.getAllPersons();

        ArrayAdapter<Person> adapPerson = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, returnList);
        listPersons.setAdapter(adapPerson);

        handler.post(new Runnable()
        {
            @Override
            public void run()
            {

                Toast.makeText(ListPersonsActivity.this, "Person List Received", Toast.LENGTH_SHORT).show();

            }//run

        });//handler

    }//PV run

}//PC

package com.example.adriano.wsexample_android;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchByIDActivity extends AppCompatActivity implements View.OnClickListener, Runnable
{

    EditText idPerson;
    EditText namePerson;
    EditText emailPerson;
    EditText birthPerson;

    Handler handler = new Handler();

    PersonDAO requestSBI = new PersonDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_id);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        idPerson = (EditText) findViewById(R.id.editSBI_ID);
        namePerson = (EditText) findViewById(R.id.editSBI_Name);
        emailPerson = (EditText) findViewById(R.id.editSBI_Email);
        birthPerson = (EditText) findViewById(R.id.editSBI_BirthDate);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabSBI_getPerson);
        fab.setOnClickListener(this);


    }//OnCreate

    public void onClick(View v)
    {

        namePerson.setVisibility(View.VISIBLE);
        emailPerson.setVisibility(View.VISIBLE);
        birthPerson.setVisibility(View.VISIBLE);

        Thread t = new Thread(this);
        t.start();

    }

    public void run()
    {

        requestSBI.getPersonsID(Integer.parseInt(idPerson.getText().toString()));

        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                namePerson.setText(requestSBI.getNameID);
                emailPerson.setText(requestSBI.getEmailID);
                birthPerson.setText(requestSBI.getBirthID);

                Toast.makeText(SearchByIDActivity.this, "Person Received", Toast.LENGTH_SHORT).show();

            }//run

        });//handler

    }//PV run

}//PC

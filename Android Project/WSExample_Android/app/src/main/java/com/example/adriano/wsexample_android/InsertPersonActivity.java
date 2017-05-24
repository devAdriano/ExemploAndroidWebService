package com.example.adriano.wsexample_android;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.EditText;
import android.widget.Toast;


import java.text.ParseException;

public class InsertPersonActivity extends AppCompatActivity implements Runnable, View.OnClickListener {

    private EditText edi_IP_Name;
    private EditText edi_IP_Email;
    private EditText edi_IP_BirhDate;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_person);

        edi_IP_Name = (EditText) findViewById(R.id.editIP_Name);
        edi_IP_Email = (EditText) findViewById(R.id.editIP_Email);
        edi_IP_BirhDate = (EditText) findViewById(R.id.editIP_BirthDate);

        FloatingActionButton IPsave = (FloatingActionButton) findViewById(R.id.fabIP_Save);
        IPsave.setOnClickListener(this);


    }//OnCreate

    public void onClick(View v)
    {

        Thread t = new Thread(this);
        t.start();

    }

    public void run()
    {

        PersonDAO savePerson = new PersonDAO();
        try
        {
            boolean result = savePerson.insertPerson(new Person(0, edi_IP_Name.getText().toString(), edi_IP_Email.getText().toString(), edi_IP_BirhDate.getText().toString()));
            finish();
        }//try
        catch (ParseException e)
        {
            e.printStackTrace();
        }//catch

        handler.post(new Runnable()
        {
            @Override
            public void run()
            {

                Toast.makeText(InsertPersonActivity.this, "Person Inserted Sucessufully", Toast.LENGTH_SHORT).show();

            }//run

        });//handler

    }//PV run

}//PC

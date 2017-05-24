package com.example.adriano.wsexample_android;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private Button SBI_Button;
    private Button LAP_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SBI_Button = (Button) findViewById(R.id.btn_searchID);
        LAP_Button = (Button) findViewById(R.id.btn_searchAll);

        //Button Functions
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                startActivity(new Intent(MainActivity.this, InsertPersonActivity.class));

            }//OnClick FAB

        });//OnClickListener FAB

        SBI_Button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(MainActivity.this, SearchByIDActivity.class));

            }//OnClick Button SBI

        });//OnClickListener SBI

        LAP_Button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                startActivity(new Intent(MainActivity.this, ListPersonsActivity.class));

            }//OnClick Button LAP

        });//OnClickListener LAP
        //Button Functions

        //METHOD TEST===========================================================================================================================================
        //The code below allow you use thread function without implement your method

        /*
        if(Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }//this code allow you use thread function without implement your method
        */

        //PersonDAO testMethod = new PersonDAO();

        //INSERT TEST
        //boolean result = testMethod.insertPerson(new Person(0, "Teste", "teste@teste.com.br", "01/01/2017"));
        //Log.d("WSExample ", result + "");

        //LIST ALL PERSONS TEST
        //ArrayList<Person> testReturnList = testMethod.getAllPersons();
        //Log.d("WSExample: ", testReturnList.toString());

        //LIST USING PERSON ID TEST
        //Person getPersonID = testMethod.getPersonsID(2);
        //Log.d("WSExample ", getPersonID.toString());

        //=======================================================================================================================================================

    }//OnCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }//OnCreate

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }//IF

        return super.onOptionsItemSelected(item);
    }//OnItemSelected

}//PC

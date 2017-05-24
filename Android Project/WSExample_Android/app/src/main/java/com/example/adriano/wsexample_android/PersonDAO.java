package com.example.adriano.wsexample_android;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by adriano on 4/25/17.
 */

public class PersonDAO
{

    //Constants WebService
    private static final String URL = "http://192.168.25.16:8080/WSExample/services/PersonDAO?wsdl";
    private static final String NAMESPACE = "http://ws.apache.org/axis2";

    //Constants Methods
    private static final String INSERT = "insertPerson";
    private static final String PERSON_ID = "getPersonsID";
    private static final String LIST_PERSONS = "getAllPersons";

    public String getNameID;
    public String getEmailID;
    public String getBirthID;

    public boolean insertPerson(Person person) throws ParseException
    {

        SoapObject insert = new SoapObject(NAMESPACE, INSERT);

        SoapObject personSO = new SoapObject(NAMESPACE, "person");

        personSO.addProperty("id", person.getId());
        personSO.addProperty("name", person.getName());
        personSO.addProperty("email", person.getEmail());
        personSO.addProperty("birthDate", person.getBirthDate());

        insert.addSoapObject(personSO);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(insert);
        envelope.implicitTypes = true;

        HttpTransportSE httpTrans = new HttpTransportSE(URL);
        try
        {
            httpTrans.call("urn: " + INSERT, envelope);
            SoapPrimitive answer = (SoapPrimitive) envelope.getResponse();

            return Boolean.parseBoolean(answer.toString());

        }//try
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }//catch
        catch (XmlPullParserException e)
        {
            e.printStackTrace();
            return false;
        }//catch

    }//insert


    public ArrayList<Person> getAllPersons()
    {
        ArrayList<Person> personList = new ArrayList<Person>();

        SoapObject listAll = new SoapObject(NAMESPACE, LIST_PERSONS);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(listAll);
        envelope.implicitTypes = true;

        HttpTransportSE httpTrans = new HttpTransportSE(URL);

        try
        {
            httpTrans.call("urn: " + LIST_PERSONS, envelope);

            Vector<SoapObject> retunList = (Vector<SoapObject>) envelope.getResponse();

            for(SoapObject SO : retunList)
            {

                Person per = new Person();

                per.setId(Integer.parseInt(SO.getProperty("id").toString()));
                per.setName(SO.getProperty("name").toString());
                per.setEmail(SO.getProperty("email").toString());
                per.setBirthDate(SO.getProperty("birthDate").toString());

                personList.add(per);

            }//for

        }//try
        catch (IOException e)
        {
            e.printStackTrace();

        }//catch
        catch (XmlPullParserException e)
        {
            e.printStackTrace();
        }//catch

        return personList;

    }//getAllPersons

    public Person getPersonsID(int id)
    {

        Person per = null;

        SoapObject listID = new SoapObject(NAMESPACE, PERSON_ID);
        listID.addProperty("id", id);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(listID);
        envelope.implicitTypes = true;

        HttpTransportSE httpTrans = new HttpTransportSE(URL);

        try {
            httpTrans.call("urn: " + PERSON_ID, envelope);

            SoapObject retunList = (SoapObject) envelope.getResponse();

            per = new Person();

            per.setId(Integer.parseInt(retunList.getProperty("id").toString()));
            per.setName(retunList.getProperty("name").toString());
            per.setEmail(retunList.getProperty("email").toString());
            per.setBirthDate(retunList.getProperty("birthDate").toString());

            getNameID = per.getName();
            getEmailID = per.getEmail();
            getBirthID = per.getBirthDate();

            return per;

        }//try
        catch (IOException e) {
            e.printStackTrace();
            return null;

        }//catch
        catch (XmlPullParserException e) {
            e.printStackTrace();
            return null;
        }//catch


    }//getPersonsID

}//PC

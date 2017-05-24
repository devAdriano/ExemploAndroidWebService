import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonDAO 
{

	public boolean insertPerson(Person person) throws ParseException
	{
		
		try 
		{
			Connection conn = BDConnection.getConnection();
			
			String queryInsert = "INSERT INTO PESSOA values (null, ?, ?, ?)";
		
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date date = sdf.parse(person.getBirthDate());
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
			PreparedStatement stm = conn.prepareStatement(queryInsert);
			
			stm.setString(1, person.getName());
			stm.setString(2, person.getEmail());
			stm.setDate(3, sqlDate);
			
			stm.executeUpdate();
			
			conn.close();
			
		}//try 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			return false;
		}//catch
		
		return true;
	}//insert
	
	public ArrayList<Person> getAllPersons()
	{
		ArrayList<Person> personList = new ArrayList<Person>();
		
		try 
		{
			Connection conn = BDConnection.getConnection();
			
			String querySelect = "SELECT * FROM PESSOA";
			
			PreparedStatement stm = conn.prepareStatement(querySelect);
			
			
			ResultSet rSet = stm.executeQuery();
			
			
			while(rSet.next())
			{
				
				Person per = new Person();
				
				per.setId(rSet.getInt(1));
				per.setName(rSet.getString(2));
				per.setEmail(rSet.getString(3));
				per.setBirthDate(rSet.getString(4).toString());
				
				personList.add(per);
				
			}//if ResultSet
			
			conn.close();
			
		}//try 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			
		}//catch
		
		return personList;
		
	}//getAllPersons
	
	public Person getPersonsID(int id)
	{
		
		Person per = null;
		
		try 
		{
			Connection conn = BDConnection.getConnection();
			
			String querySelect = "SELECT * FROM PESSOA WHERE idPESSOA = ?";
			
			PreparedStatement stm = conn.prepareStatement(querySelect);
			
			stm.setInt(1, id);
			
			ResultSet rSet = stm.executeQuery();
			
			if(rSet.next())
			{
				
				per = new Person();
				
				per.setId(rSet.getInt(1));
				per.setName(rSet.getString(2));
				per.setEmail(rSet.getString(3));
				per.setBirthDate(rSet.getString(4).toString());
				
				System.out.println("Nome: " + per.getName());
				
			}//if ResultSet
			else
			{
				
				return per;
				
			}//else
			
			conn.close();
			
		}//try 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
			
		}//catch
		
		return per;
		
	}//getPersonsID
	
}//PC

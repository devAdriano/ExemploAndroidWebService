import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection 
{

	private static final String URL = "jdbc:mysql://localhost:3306/dbTesteAndroid";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() throws SQLException
	{
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		}//try 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch
		
		return DriverManager.getConnection(URL, USER, PASSWORD);
		
	}//Connection getConnection
	
}//PC 


public class Person 
{

	private int id;
	private String name;
	private String email;
	private String birthDate;
	
	public Person()
	{
		
		
	}//Person

	public Person(int id, String name, String email, String birthDate) 
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}//public Person

	public int getId() 
	{
		return id;
	}//id

	public void setId(int id) 
	{
		this.id = id;
	}//id

	public String getName() 
	{
		return name;
	}//name

	public void setName(String name) 
	{
		this.name = name;
	}//name

	public String getEmail() 
	{
		return email;
	}//email

	public void setEmail(String email) 
	{
		this.email = email;
	}//email

	public String getBirthDate() 
	{
		return birthDate;
	}//birthDate

	public void setBirthDate(String birthDate) 
	{
		this.birthDate = birthDate;
	}//birthDate
	
	
	
}//PC 

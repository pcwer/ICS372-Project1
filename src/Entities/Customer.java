package Entities;
import Abstract.Person;

public class Customer extends Person
{
	public Customer(String name, String address, String phoneNumber)
	{
		super(name, address, phoneNumber);
	}
	
    public String toString()
    {
		return "id:" + uniqueID + ", name:" + name + ", address:" + address + 
				", phoneNumber:" + phoneNumber;
    }
}

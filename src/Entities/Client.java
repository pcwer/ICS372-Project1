package Entities;


import java.io.Serializable;

import Abstract.Person;
/**
* Client holds information about name, address, and phone number.
* A unique id is generated and balance is set to 0. 
* Current iteration states the balance will remain 0 for now.
* 
* @author Udo, Ricky
*/
public class Client extends Person implements Serializable
{
	private double balance;
	/**
	 * A client object is created with given inputs, unique ID, and balance set to 0.
	 * 
	 * @param name Name of client
	 * @param address Client's address
	 * @param phoneNumber Client's phone number
	 */
    public Client(String name, String address, String phoneNumber)
    {
        super(name, address, phoneNumber);
        balance = 0;
    }	
	/**
	 * Get client's balance
	 * @return balance
	 */
	public double getBalance()
	{
		return balance;
	}
	/**
	 * Set the client's balance
	 * @param balance Client's balance
	 */
	public void setBalance(double balance)
	{
		this.balance = balance;
	}

    public String toString()
    {
		return "id:" + uniqueID + ", name:" + name + ", address:" + address + 
				", phoneNumber:" + phoneNumber + ", balance:" + balance;
    }
}

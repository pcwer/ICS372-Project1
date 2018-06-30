/**
 * 
 * 
 * @author David, Udo, Ricky
 *
 */
public class TheaterController implements CommandsApi
{
	/**
	 * Retrieve all information related to the theater. This 
	 * may be done at the start of any session. If stored 
	 * data is found, the user has the option to use it. The 
	 * user may also invoke a command to load data, provided 
	 * he/she has not yet issued any data-related commands in 
	 * that session.
	 * 
	 */
	public void retrieveData()
	{
		
	}
	
	/**
	 * Store the data on disk and quit the application.
	 * 
	 */
	public void storeData()
	{
		
	}
	
	/**
	 * List the names and dates of all shows.
	 * 
	 */
	public void listAllShows()
	{
		
	}
	
	/**
	 * Add a new show for a client. The values accepted are the name 
	 * of the show, the client id, and the period for which the client 
	 * wants the theater for this play. The entire range of dates 
	 * should be available, or the process fails.
	 * 
	 */
	public void addShow()
	{
		
	}
	
	/**
	 * Print information about every client, including credit card information.
	 * 
	 */
	public void listAllCustomers()
	{
		
	}
	
	/**
	 * The system accepts the credit card number and removes the information related 
	 * to the credit card. If this is the only credit card for the customer, it refuses 
	 * to delete the credit card information.
	 * 
	 */
	public void removeCreditCard()
	{
		
	}
	
	/**
	 * The system accepts the customer id, credit card number, and expiry date and 
	 * remembers that the credit card belongs to this customer.
	 * 
	 */
	public void addCreditCard()
	{
		
	}
	
	/**
	 * Remove a customer with the given id. All credit cards related to the customer 
	 * are also deleted.
	 * 
	 */
	public void removeCustomer()
	{
		
	}
	
	/**
	 * The system accepts the name, address, phone number, and the number and expiry 
	 * date of exactly one credit card. The system generates a unique id for the customer.
	 * 
	 */
	public void addCustomer()
	{
		
	}
	
	/**
	 * Print information about every client.
	 * 
	 */
	public void listAllClients()
	{
		
	}
	
	/**
	 * Remove a client with the given id. If a show is scheduled for the current or a 
	 * future date for this client, the client cannot be removed.
	 * 
	 */
	public void removeClient()
	{
		
	}
	
	/**
	 * The system accepts the name, address, and phone number of the client. The system
	 * generates a unique id and sets the balance to 0. (The balance will remain 0 in this 
	 * iteration.)
	 * 
	 */
	public void addClient()
	{
		
	}
	
	/**
	 * Store the data on disk and quit the application.
	 * 
	 */
	public void exitApplication()
	{
		
	}

	/**
	 * Does nothing, ui already does this job. This is an artifact from the Command_API interface 
	 * that is implemented. 
	 * 
	 */
	public void help(){/*DOES NOTHING*/}
	
}
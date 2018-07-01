package Api;

public interface CommandsApi
{
	public void exitApplication();
	public void addClient();
	public void removeClient();
	public void listAllClients();
	public void addCustomer();
	public void removeCustomer();
	public void listAllCustomers();
	public void addCreditCard();
	public void removeCreditCard();
	public void addShow();
	public void listAllShows();
	public void storeData();
	public void retrieveData();
	public void help();
}
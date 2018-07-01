package Collections;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import Entities.Customer;

public class CustomersCollection implements Serializable
{
	Map<Long, Customer> customers;
	
	public CustomersCollection()
	{
		customers = new HashMap<Long, Customer>();
	}

	public void remove(Customer customer)
	{
		customers.remove(customer.getID());
	}
	
	public void add(Customer customer)
	{
		customers.put(customer.getID(), customer);
	}
	
	public Map<Long, Customer> getCustomersHashMap()
	{
		return customers;
	}

	public void remove(Long customerID)
	{
		customers.remove(customerID);
	}
}
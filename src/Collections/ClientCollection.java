package Collections;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import Entities.Client;

public class ClientCollection implements Serializable
{
	private Map<Long, Client> clients;

	public ClientCollection()
	{
		clients = new HashMap<Long, Client>();
	}
	
	public boolean add(Client client)
	{
		clients.put(client.getID(), client);
		return true;
	}
	
	public Client get(Long key)
	{
		return clients.get(key);
	}

	public Map<Long, Client> getClientsHashMap()
	{
		return clients;
	}
	
	public void remove(Client client)
	{
		clients.remove(client.getID());
	}
}
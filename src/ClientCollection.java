import java.util.HashMap;
import java.util.Map;

public class ClientCollection
{
	private Map<Long, Client> clients;

	ClientCollection()
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
}
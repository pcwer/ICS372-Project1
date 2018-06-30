
public class Theater
{
	private ClientCollection clients;
	private ShowsCollection shows;
	private CardsCollection cards;
	private CustomersCollection customers;
	
	Theater()
	{
		clients = new ClientCollection();
		shows = new ShowsCollection();
		cards = new CardsCollection();
		customers = new CustomersCollection();
	}
	
	public ClientCollection getClients()
	{
		return clients;
	}

	public ShowsCollection getShows()
	{
		return shows;
	}

	public CardsCollection getCards()
	{
		return cards;
	}

	public CustomersCollection getCustomers()
	{
		return customers;
	}

	public void setClients(ClientCollection clients)
	{
		this.clients = clients;
	}
	
	public void setShows(ShowsCollection shows)
	{
		this.shows = shows;
	}

	public void setCards(CardsCollection cards)
	{
		this.cards = cards;
	}
	
	public void setCustomers(CustomersCollection customers)
	{
		this.customers = customers;
	}

	public static void main(String[] args)
	{
		
	}
}
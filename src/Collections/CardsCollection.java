package Collections;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Entities.CreditCard;
import Entities.Customer;

public class CardsCollection implements Serializable
{
	Map<Long, ArrayList<CreditCard>> cards;
	
	public CardsCollection()
	{
		cards = new HashMap<Long, ArrayList<CreditCard>>();
	}
	
	public Map<Long, ArrayList<CreditCard>> getCardsHashMap()
	{
		return cards;
	}

	public boolean add(Long customerId, CreditCard newCard)
	{
		if(cards.get(customerId) == null)
		{
			cards.put(customerId, new ArrayList<CreditCard>());
			cards.get(customerId).add(newCard);
		}
		else
		{
			cards.get(customerId).add(newCard);
			return true;
		}
		return false;
	}
	
	public ArrayList<CreditCard> getCustomerArrayListOfCreditCards(Long key)
	{
		return cards.get(key);
	}
	
	public boolean add(Customer customer, CreditCard newCard)
	{
		if(cards.get(customer.getID()) == null)
		{
			cards.put(customer.getID(), new ArrayList<CreditCard>());
			cards.get(customer.getID()).add(newCard);
		}
		else
		{
			cards.get(customer.getID()).add(newCard);
			return true;
		}
		return false;
	}
}
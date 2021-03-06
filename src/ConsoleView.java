import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Map.Entry;
import Collections.ClientCollection;
import Collections.CustomersCollection;
import Entities.Client;
import Entities.CreditCard;
import Entities.Customer;
import Entities.Show;
import Enums.Command;
import Theater.Theater;
import Utils.InputUtils;
import Utils.Serializer;
import Utils.Strings;

/**
 * This class utilizes a Singleton pattern and is the entry point for program startup. Once instantiated, the class 
 * displays menu options to the user and allows the user to make a selection. The 
 * selection calls the appropriate functions on the controller and model.
 * 
 * @author Udo, Ricky
 * 
 */
public class ConsoleView implements Serializable
{
	private static ConsoleView console;
	private Theater controller;
	private InputUtils inputUtil;
	private Serializer serializer;

	/**
	 * Initializes the Singleton Class and prompts the user to use previous data 
	 * on startup.
	 * 
	 */
	private ConsoleView()
	{
		controller = new Theater();
		inputUtil = new InputUtils();
		serializer = new Serializer();
		
		if(inputUtil.promptYesOrNo(Strings.PROMPT_LOAD_DATA))
		{
			System.out.println(Strings.NOTIFY_RETRIEVING_DATA);
			controller = retrieveData();
		}
	}

	public static ConsoleView instance()
	{
		if(console == null)
		{
			console = new ConsoleView();
		}
		return console;
	}
	
	/**
	 * The main function of the program. Displays the menu, gets user input, and calls 
	 * the proper functions on the rest of the program.
	 * 
	 */
	private void guiHomePage()
	{
		Command cmd = Command.HELP; //Enumerated program commands
		help();
		
		//Main running loop for the program
		while((cmd = inputUtil.getCommand()) != Command.EXIT_APPLICATION)
		{
			help();
			switch(cmd)
			{
				case EXIT_APPLICATION:		exitApplication();
											break;
				case ADD_CLIENT:        	addClient();
											break;
				case REMOVE_CLIENT:			removeClient();
											break;				
				case LIST_ALL_CLIENTS:		listAllClients();
											break;
				case ADD_CUSTOMER:			addCustomer();
											break;
				case REMOVE_CUSTOMER:		removeCustomer();
											break;
				case LIST_ALL_CUSTOMERS:	addCreditCard();
											break;
				case ADD_CREDIT_CARD:		removeCreditCard();
											break;
				case REMOVE_CREDIT_CARD:	listAllCustomers();
											break;
				case ADD_SHOW:				addShow();
											break;
				case LIST_ALL_SHOWS:		listAllShows();
											break;
				case STORE_DATA:			storeData();
											break;
				case RETRIEVE_DATA:			retrieveData();
											break;
				case HELP:					help();
											break;
				default:					System.out.printf(Strings.PROMPT_SELECT_CORRECT_OPTION, cmd);
											break;
			}
		}
		System.out.printf(Strings.NOTIFY_CLOSING_APPLICATION, cmd);
	}

	/**
	 * Check if previous data is available. If not, display an error. If it is, attempt 
	 * to deserialize it. If the deserializing failed then display an error and return 
	 * a new Theater. 
	 * 
	 * @return Theater - Either a loaded or new Theater object must be returned from here
	 */
	private Theater retrieveData()
	{
		boolean previousDataAvailable = Serializer.isPreviousTheaterDataAvailable();
		
		if(previousDataAvailable)
		{
			//If a file exists then return it otherwise display an error - data not loaded
			System.out.printf(Strings.NOTIFY_DATA_LOADING);
			Theater theater = serializer.deserializeTheater();
			if(theater != null)
			{
				return theater;
			}	
		}
		else
		{
			System.out.printf(Strings.ERROR_NO_DATA_TO_RETRIEVE);
		}
		System.out.println(Strings.ERROR_DATA_NOT_ABLE_TO_LOAD);
		return new Theater();
	}
	
	/**
	 * Calls the Serializer to store this object's Theater to disk
	 * 
	 */
	private void storeData()
	{
		serializer.serializeTheater(controller);
	}
	
	/**
	 * 
	 */
	private void listAllShows()
	{
		Map<Long, ArrayList<Show>> map = controller.getShows().getShowsHashmap();
		ArrayList<Show> arrList;

		/*
		 * Get the value per the iterated key. Should be an array 
		 * list of Shows. Then iterate over these shows and print 
		 * them to screen.
		 */
		System.out.println(Strings.NOTIFY_LISTING_ALL_SHOWS);	
		for (Entry<Long, ArrayList<Show>> entry : map.entrySet())
		{
			//Gets the ArrayList of Shows
			arrList = entry.getValue();
			
			//Iterates over all of the Shows, printing name, beginDate, endDate.
			for(int i = 0; i < arrList.size(); ++i)
			{
				System.out.println(arrList.get(i).toString());
			}
		}
	}
	
	/**
	 * 
	 */
	private void addShow()
	{
		System.out.println("Please provide the client id, the show name, and the begin and end dates.");
		Long id = inputUtil.getLongInput(Strings.PROMPT_CLIENT_ID);
		String showName = inputUtil.getStringInput(Strings.PROMPT_SHOW_NAME);
		int[] beginDate = inputUtil.getDateInput(inputUtil.getStringInput(Strings.PROMPT_BEGIN_DATE));
		int[] endDate = inputUtil.getDateInput(inputUtil.getStringInput(Strings.PROMPT_END_DATE));
	
		Calendar begin = new GregorianCalendar(beginDate[0], beginDate[1], beginDate[2], 0, 0, 0);
		Calendar end = new GregorianCalendar(endDate[0], endDate[1], endDate[2], 23, 59, 59);
		
		if(controller.getShows().isShowOverlappingOtherShows(begin, end))
		{
			System.out.println("Show overlaps another. Cannot add to listing.");
		}
		else
		{
			Show show = new Show(showName, begin, end);
		
			controller.getShows().add(id, show);
			System.out.println(show.toString());
		}
	}
	
	/**
	 * 
	 */
	private void listAllCustomers()
	{
		CustomersCollection clients = controller.getCustomers();
		Map<Long, Customer> map = clients.getCustomersHashMap();
		
		for (Entry<Long, Customer> entry : map.entrySet())
		{
			System.out.println(/*"Key = " + entry.getKey() + ", Value = " + */entry.getValue().toString());
			System.out.println("Credit Cards: ");
			listAllCreditCards(entry.getValue().getID());
		}
	}
	
	private void listAllCreditCards(Long customerId)
	{
		Map<Long, ArrayList<CreditCard>> map = controller.getCards().getCardsHashMap();
		ArrayList<CreditCard> arrList = map.get(customerId);
		
		for(int i = 0; i < arrList.size(); ++i)
		{
			System.out.println(arrList.get(i));
		}
		System.out.println();
	}
	
	/**
	 * 
	 */
	private void removeCreditCard()
	{
		String cardNumber = inputUtil.getStringInput(Strings.PROMPT_CREDIT_CARD_NUMBER);
		
		Map<Long, ArrayList<CreditCard>> map = controller.getCards().getCardsHashMap();
		ArrayList<CreditCard> arrList;
		
		for(Entry<Long, ArrayList<CreditCard>> entry : map.entrySet())
		{
			arrList = entry.getValue();
			
			for(int i = 0; i < arrList.size(); ++i)
			{
				if(arrList.get(i).getCardNumber().equals(cardNumber))
				{
					if(arrList.size() > 1)
					{
						arrList.remove(i);
						System.out.println(cardNumber + " removed.");
					}
					else
					{
						System.out.println("Only one card, cannot remove.");
						return;
					}
				}
				//System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			}
		}	
		System.out.println("Card not found");
	}
	
	/**
	 * 
	 */
	private void addCreditCard()
	{
		Long customerId = inputUtil.getLongInput(Strings.PROMPT_CUSTOMER_ID);
		String cardNumber = inputUtil.getStringInput(Strings.PROMPT_CREDIT_CARD_NUMBER);
		int[] expirationDate = inputUtil.getDateInput(inputUtil.getStringInput(Strings.PROMPT_CREDIT_CARD_EXPIRATION_DATE));
		Calendar expDate = new GregorianCalendar(expirationDate[0], expirationDate[1], expirationDate[2]);
		
		CreditCard card = new CreditCard(cardNumber, expDate);
		controller.getCards().add(customerId, card);
		
		System.out.println("Card added successfully");	
	}
	
	/**
	 * 
	 */
	private void removeCustomer()
	{
		Long customerID = inputUtil.getLongInput(Strings.PROMPT_CUSTOMER_ID);
		
		controller.getCards().getCardsHashMap().remove(customerID);
		controller.getCustomers().remove(customerID);
	}
	
	/**
	 * 
	 */
	private void addCustomer()
	{
		System.out.println("Please enter a name, an address, a phone number, a credit card number, and it's expiration date");

		String name = inputUtil.getStringInput(Strings.PROMPT_CUSTOMER_NAME);
		String address = inputUtil.getStringInput(Strings.PROMPT_ADDRESS);
		String phoneNumber = inputUtil.getPhoneNumberInput(Strings.PROMPT_PHONE_NUMBER);
		String cardNumber = inputUtil.getStringInput(Strings.PROMPT_CREDIT_CARD_NUMBER);
		int[] expirationDate = inputUtil.getDateInput(inputUtil.getStringInput(Strings.PROMPT_CREDIT_CARD_EXPIRATION_DATE));
		
		//Move into inputUtils
		Calendar expDate = new GregorianCalendar(expirationDate[0], expirationDate[1], expirationDate[2]);
		
		Customer customer = new Customer(name, address, phoneNumber);
		CreditCard card = new CreditCard(cardNumber, expDate);
		
		controller.getCustomers().add(customer);
		controller.getCards().add(customer, card);
		
		System.out.println("Card and customer added successfully");
	}
	
	/**
	 * 
	 */
	private void listAllClients()
	{
		ClientCollection clients = controller.getClients();
		Map<Long, Client> map = clients.getClientsHashMap();
		
		for (Entry<Long, Client> entry : map.entrySet())
		{
			System.out.println(/*"Key = " + entry.getKey() + ", Value = " + */entry.getValue().toString());
		}
	}
	
	/**
	 * 
	 */
	private void removeClient()
	{
		Long clientID = inputUtil.getLongInput(Strings.PROMPT_CLIENT_ID);
		
		Client client = controller.getClients().get(clientID);
		
		boolean showsInPast = controller.getShows().isEveryShowListingInClientsPast(client.getID());
		
		//Clients are removed but all of their shows stay in the system.
		if(showsInPast)
		{
			controller.getClients().remove(client);
			System.out.println("Client removed from system.");
		}
		else
		{
			System.out.println("Client has future shows, client not deleted.");
		}
		//See if any upcoming shows in showlist
		//if no shows remove(client) else system.out error
	}
	
	/**
	 * 
	 */
	private void addClient()
	{
		System.out.println("Please enter the Client's name, address, and phone number.");
		
		String name = inputUtil.getStringInput(Strings.PROMPT_CLIENT_NAME);
		String address = inputUtil.getStringInput(Strings.PROMPT_ADDRESS);
		String phoneNumber = inputUtil.getPhoneNumberInput(Strings.PROMPT_PHONE_NUMBER);

		//Add a confirmation eventually.
		
		Client client = new Client(name, address, phoneNumber);
		controller.getClients().add(client);
		System.out.println("Successfully added client: " + controller.getClients().get(client.getID()).getName() + " With id of: " + client.getID());
	}
	
	/**
	 * 
	 */
	private void exitApplication()
	{
		serializer.serializeTheater(controller);
	}

	/**
	 * Displays the menu options available to the user.
	 * 
	 */
	private void help()
	{
		int i = 0;
		
		//Post-increment i each line in case of the options needing to have their order changed
		System.out.println();
		System.out.printf(Strings.MAKE_A_SELECTION);
		System.out.printf(Strings.EXIT, i++);
		System.out.printf(Strings.ADD_CLIENT, i++);
		System.out.printf(Strings.REMOVE_CLIENT, i++);
		System.out.printf(Strings.LIST_ALL_CLIENTS, i++);
		System.out.printf(Strings.ADD_CUSTOMER, i++);
		System.out.printf(Strings.REMOVE_CUSTOMER, i++);
		System.out.printf(Strings.ADD_CREDIT_CARD, i++);
		System.out.printf(Strings.REMOVE_CREDIT_CARD, i++);
		System.out.printf(Strings.LIST_ALL_CUSTOMERS, i++);
		System.out.printf(Strings.ADD_SHOW, i++);
		System.out.printf(Strings.LIST_ALL_SHOWS, i++);
		System.out.printf(Strings.STORE_DATA, i++);
		System.out.printf(Strings.RETRIEVE_DATA, i++);
		System.out.printf(Strings.HELP, i++);
	}
	
	/**
	 * Entry point of the program. Initializes the Singleton class and calls 
	 * its main function.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		ConsoleView.instance().guiHomePage();
	}
	
}
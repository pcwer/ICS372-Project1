/**
 * This class utilizes a Singleton pattern and is the entry point for program startup. Once instantiated, the class 
 * displays menu options to the user and allows the user to make a selection. The 
 * selection calls the appropriate functions on the controller and model.
 * 
 * @author David, Udo, and Ricky
 * 
 */
public class ConsoleView
{
	private static ConsoleView console;
	private static TheaterController controller = new TheaterController();
	private InputUtils inputUtil = new InputUtils();

	/**
	 * Initializes the Singleton Class and prompts the user to use previous data 
	 * on startup.
	 * 
	 */
	private ConsoleView()
	{
		controller = new TheaterController();
		
		if(inputUtil.promptYesOrNo(Strings.PROMPT_LOAD_DATA))
		{
			System.out.println(Strings.NOTIFY_RETRIEVING_DATA);
			controller.retrieveData();
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
		help(); //Displays menu options
		
		while((cmd = inputUtil.getCommand()) != Command.EXIT_APPLICATION)
		{
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
											help();
											break;
			}
		}
		System.out.printf(Strings.NOTIFY_CLOSING_APPLICATION, cmd);
	}

	/**
	 * 
	 */
	private void retrieveData()
	{
		
	}
	
	/**
	 * 
	 */
	private void storeData()
	{
		
	}
	
	/**
	 * 
	 */
	private void listAllShows()
	{
		
	}
	
	/**
	 * 
	 */
	private void addShow()
	{
		
	}
	
	/**
	 * 
	 */
	private void listAllCustomers()
	{
		
	}
	
	/**
	 * 
	 */
	private void removeCreditCard()
	{
		
	}
	
	/**
	 * 
	 */
	private void addCreditCard()
	{
		
	}
	
	/**
	 * 
	 */
	private void removeCustomer()
	{
		
	}
	
	/**
	 * 
	 */
	private void addCustomer()
	{
		
	}
	
	/**
	 * 
	 */
	private void listAllClients()
	{
		
	}
	
	/**
	 * 
	 */
	private void removeClient()
	{
		
	}
	
	/**
	 * 
	 */
	private void addClient()
	{
		
	}
	
	/**
	 * 
	 */
	private void exitApplication()
	{
		
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
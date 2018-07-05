package Utils;

public class Strings
{
	//Template String for copy paste
	public static final String VARNAME = "";
	
	//User Prompt Strings
	public static final String PROMPT_LOAD_DATA = "Do you want to load last session's data?";
	public static final String PROMPT_SELECT_CORRECT_OPTION = "%s, please choose another option.\n";
	public static final String PROMPT_CLIENT_ID = "Please enter the Client ID";
	public static final String PROMPT_SHOW_NAME = "Please enter the Show name";
	public static final String PROMPT_BEGIN_DATE = "Please enter the begin date as YYYY/MM/DD";
	public static final String PROMPT_END_DATE = "Please enter the end date as YYYY/MM/DD";
	public static final String PROMPT_CREDIT_CARD_NUMBER = "Please enter a credit card number";
	public static final String PROMPT_CUSTOMER_ID = "Please enter the Customer ID";
	public static final String PROMPT_CREDIT_CARD_EXPIRATION_DATE = "Please enter the credit card expiration date as YYYY/MM/DD";
	public static final String PROMPT_CUSTOMER_NAME = "Please enter the customer's name";
	public static final String PROMPT_ADDRESS = "Please enter an address";
	public static final String PROMPT_PHONE_NUMBER = "Please enter phone number as xxx-xxx-xxxx";
	public static final String PROMPT_CLIENT_NAME = "Please enter the Client's name";
	
	//User Notification Strings
	public static final String NOTIFY_CLOSING_APPLICATION = "%s selected, closing application.";
	public static final String NOTIFY_RETRIEVING_DATA = "Retrieving data.";
	public static final String NOTIFY_DATA_LOADING = "Data found and loading...\n";
	public static final String NOTIFY_LISTING_ALL_SHOWS = "Listing All Shows:\n";

	//Menu Strings
	public static final String MAKE_A_SELECTION = "Please make a selection from the following:\n";
	public static final String EXIT = "%d - Exit Application\n";
	public static final String ADD_CLIENT = "%d - Add Client\n";
	public static final String REMOVE_CLIENT = "%d - Remove Client\n";
	public static final String LIST_ALL_CLIENTS = "%d - List All Clients\n";
	public static final String ADD_CUSTOMER = "%d - Add Customer\n";
	public static final String REMOVE_CUSTOMER = "%d - Remove Customer\n";
	public static final String ADD_CREDIT_CARD = "%d - Add Credit Card\n";
	public static final String REMOVE_CREDIT_CARD = "%d - Remove Credit Card\n";
	public static final String LIST_ALL_CUSTOMERS = "%d - List All Customers\n";
	public static final String ADD_SHOW = "%d - Add Show\n";
	public static final String LIST_ALL_SHOWS = "%d - List All Shows\n";
	public static final String STORE_DATA = "%d - Store Data\n";
	public static final String RETRIEVE_DATA = "%d - Retrieve Data\n";
	public static final String HELP = "%d - Help\n";

	//Error Strings
	public static final String ERROR_NO_DATA_TO_RETRIEVE = "No data to retrieve. You must attempt to retrieve this information"
			+ "													beore any other commands or the data will be overwritten.\n";
	public static final String ERROR_DATA_NOT_ABLE_TO_LOAD = "Unable to load data.";
	public static final String ERROR_USER_ENTRY_CANNOT_BE_BLANK = "Cannot be blank input. Please enter a number.";
	public static final String ERROR_BAD_USER_INPUT_FOR_LOAD_DATA = "Input was not 'yes' or 'no', data not loaded. If you want to load "
			+ "data then enter 14 on the menu screen. This must be done first before any other commands or previous "
			+ "data will be overwritten.";
}
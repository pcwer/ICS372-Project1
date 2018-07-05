package Utils;


import java.io.IOException;
import java.util.Scanner;

import Enums.Command;


/**
 * This class is called for user input. It will do error checks on the data 
 * to make sure proper input is used. (EG - Asking for int and receiving a 
 * character instead)
 * 
 * @author Udo, Ricky
 *
 */
public class InputUtils
{
	private final Scanner scanner = new Scanner(System.in);
	
	/**
	 * Returns the user input as an int
	 * @return user int selection if no exceptions, -1 if there is bad input
	 */
	public int intInput()
	{
		try
		{
			String input = scanner.nextLine();
			return Integer.parseInt(input);
		}
		catch(NumberFormatException nfe)
		{
			return Integer.parseInt("-1");
		}

	}

	/**
	 * Returns user input as double
	 * @return user double selection if no exceptions, -1.0 if there is bad input
	 */
	public double getDoubleInput() throws NumberFormatException
	{
		String input = scanner.nextLine();
		return Double.parseDouble(input);
	}

	/**
	 * Return price in format $x.xx
	 * @param price double input
	 * @return price in format $x.xx
	 */
	public double getPriceInput(Double price)
	{
		return Math.round(price*100.0)/100.0;
	}

	/**
	 * Retrieves a String and converts to a Date if possible
	 * @param strDate String format of date
	 * @return the date as int[]
	 */
	public int[] getDateInput(String strDate)
	{
		int[] date = new int[3];
		String[] parsedDate = strDate.split("/");

		if(parsedDate.length == 3)
		{
			date[0] = Integer.parseInt(parsedDate[0]);
			date[1] = Integer.parseInt(parsedDate[1]) - 1; //-1 for month-1
			date[2] = Integer.parseInt(parsedDate[2]);
			return date;
		}
		else
		{
			return null;
		}		
	}

	/**
	 * Retrieves long input from user
	 * @param promptClientId 
	 * @return long input, or -1 if there is an exception
	 */
	/*
	public long getLongInput() throws NumberFormatException
	{
		String input = scanner.nextLine();
		return Long.parseLong(input);
	}
	*/
	public Long getLongInput(String promptClientId) throws NumberFormatException
	{
		System.out.println(promptClientId);
		String input = scanner.nextLine();
		return new Long(input);
	}

	/**
	 * Retrieves yes or no input
	 * @return YES if yes, NO if no, and null if invalid input
	 */
	public String getYesOrNo()
	{
		String input = scanner.nextLine();

		switch(input)
		{
		case "y":	return "YES";
		case "Y":	return "YES";
		case "yes":	return "YES";
		case "YES":	return "YES";
		case "n":	return "NO";
		case "N":	return "NO";
		case "no":	return "NO";
		case "NO":	return "NO";
		default:	return null;
		}
	}
	
	/**
	 * Retrieves yes or no input
	 * @return YES if yes, NO if no, and null if invalid input
	 * @throws IOException 
	 */
	public boolean promptYesOrNo(String prompt)
	{
		System.out.println(prompt);
		String input = scanner.nextLine();

		switch(input)
		{
			case "y":	return true;
			case "Y":	return true;
			case "yes":	return true;
			case "YES":	return true;
			case "n":	return false;
			case "N":	return false;
			case "no":	return false;
			case "NO":	return false;
			default:	System.out.println(Strings.ERROR_BAD_USER_INPUT_FOR_LOAD_DATA);	
						return false;
		}
	}

	/**
	 * Retrives string input and ensures there is a valid input
	 * @param promptShowName 
	 * @return the string input
	 * 
	 */
	public String getStringInput(String promptShowName)
	{
		System.out.println(promptShowName);
		
		String input = scanner.nextLine();
		if (input.length() == 0)
		{
			return null;
		}
		return input;
	}

	/**
	 * Ensures phone number input is 10 digits long and numbers only.
	 * Removes any dashes if added.
	 * @param promptPhoneNumber 
	 * @return input if valid or null if not
	 * 
	 */
	public String getPhoneNumberInput(String promptPhoneNumber)
	{
		System.out.println(promptPhoneNumber);
		String input = scanner.nextLine();
		
		input = input.replace("-", ""); //Remove -
		input = input.replaceAll("\\s+",""); //Remove whitespace
		//System.out.println("Input: " + input);
		
		if(input.length() == 10 && input.matches("[0-9]+"))
		{
			return input;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Prompts user to press enter to continue
	 * 
	 */
	public void enterToContinue()
	{
		scanner.nextLine();
	}

	/**
	 * Prompts user to press enter to continue, with passed in message
	 * @param message
	 * 
	 */
	public void enterToContinue(String message)
	{
		System.out.println(message);
		scanner.nextLine();
	}

	
	public Command getCommand() throws NumberFormatException
	{
		switch(intInput())
		{
			case 0:		return Command.EXIT_APPLICATION;
			case 1:		return Command.ADD_CLIENT;
			case 2:		return Command.REMOVE_CLIENT;
			case 3:		return Command.LIST_ALL_CLIENTS;
			case 4:		return Command.ADD_CUSTOMER;
			case 5:		return Command.REMOVE_CUSTOMER;
			case 6:		return Command.LIST_ALL_CUSTOMERS;
			case 7:		return Command.ADD_CREDIT_CARD;
			case 8:		return Command.REMOVE_CREDIT_CARD;
			case 9:		return Command.ADD_SHOW;
			case 10:	return Command.LIST_ALL_SHOWS;
			case 11:	return Command.STORE_DATA;
			case 12:	return Command.RETRIEVE_DATA;
			case 13:	return Command.HELP;
			default:	return Command.BAD_COMMAND; //Catch-all for bad command input such as String or double.
		}
	}
}


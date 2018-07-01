package Entities;
import java.io.Serializable;
import java.util.Calendar;

public class CreditCard implements Serializable
{
	private String cardNumber;
	private Calendar expirationDate;
	
	public CreditCard(String cardNumber, Calendar expirationDate)
	{
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
	}

	public String getCardNumber()
	{
		return cardNumber;
	}

	public Calendar getExpirationDate()
	{
		return expirationDate;
	}

	public void setCardNumber(String cardNumber)
	{
		this.cardNumber = cardNumber;
	}

	public void setExpirationDate(Calendar expirationDate)
	{
		this.expirationDate = expirationDate;
	}
	
	public String toString()
	{
		return "CreditCard[CardNumber: " + cardNumber + "ExpirationDate: " + expirationDate + "]";
	}
}

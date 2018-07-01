package Entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

public class Show implements Serializable
{
	private String name;
	private Calendar beginDate;
	private Calendar endDate;
	
	public Show(String name, Calendar beginDate, Calendar endDate)
	{
		this.name = name;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Calendar getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Calendar beginDate) {
		this.beginDate = beginDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Gets the date ranges for the show premiere
	 * @return The date range
	 */
	public String showingDatesToString()
	{
		StringBuilder strBuild = new StringBuilder();
		String startDate, endingDate;
		
		LocalDate localStartDate = beginDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		strBuild.append(localStartDate.getYear() + "/" + localStartDate.getMonthValue() + "/"+ localStartDate.getDayOfMonth());
		startDate = strBuild.toString();
		
		strBuild.delete(0, strBuild.length());
		
		LocalDate localEndDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		strBuild.append(localEndDate.getYear() + "/" + localEndDate.getMonthValue() + "/"+ localEndDate.getDayOfMonth());
		endingDate = strBuild.toString();

		return startDate + " to " + endingDate;
	}
	
	/**
	 * Returns the string form of the show's name, client ID, and date range
	 * of the show
	 */
	public String toString()
	{
		return "Show[showName:" + name + ", dates:" + showingDatesToString() + "]";
	}
	
}
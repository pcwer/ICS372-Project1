import java.util.Calendar;

public class Show
{
	private String name;
	private Calendar beginDate;
	private Calendar endDate;
	
	Show(String name, Calendar beginDate, Calendar endDate)
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
	
	
}
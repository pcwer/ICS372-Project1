package Utils;

/**
 * 
 * 
 * @author Udo, Ricky
 * 
 */
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class ID_Generator implements Serializable
{
	public static Long getUniqueGeneratedID()
	{
		return convertTimeStampToID();
	}
	
	private static Long convertTimeStampToID()
	{
		String uniqueID = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		StringBuilder strBuild = new StringBuilder();
		String[] str = uniqueID.split("\\.");
		
		for(int i = 0; i < str.length; ++i)
		{
			strBuild.append(str[i]);
		}
		return new Long(strBuild.substring(2, strBuild.length()));
	}
	/*
	private static long convertTimeStampToID()
	{
		String uniqueID = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		StringBuilder strBuild = new StringBuilder();
		String[] str = uniqueID.split("\\.");
		
		for(int i = 0; i < str.length; ++i)
		{
			strBuild.append(str[i]);
		}
		return Long.parseLong(strBuild.substring(2, strBuild.length()));
	}
	*/
}

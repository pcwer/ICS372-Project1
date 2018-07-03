package Collections;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import Entities.CreditCard;
import Entities.Show;
import Utils.DateUtils;

public class ShowsCollection implements Serializable
{
	private Map<Long, ArrayList<Show>> shows;
	
	public ShowsCollection()
	{
		shows = new HashMap<Long, ArrayList<Show>>();
	}
	
	public Map<Long, ArrayList<Show>> getShowsHashmap()
	{
		return shows;
	}

	public boolean add(Long key, Show newShow)
	{
		if(shows.get(key) == null)
		{
			shows.put(key, new ArrayList<Show>());
			shows.get(key).add(newShow);
		}
		else
		{
			shows.get(key).add(newShow);
			return true;
		}
		return false;
	}
	
	public ArrayList<Show> getClientArrayListOfShows(Long key)
	{
		return shows.get(key);
	}

	public Show getClientShow(Long key, String showName)
	{
		ArrayList<Show> temp = shows.get(key);
		Iterator<Show> iterator = temp.iterator();
		Show show = null;
		
		while (iterator.hasNext())
		{
			show = iterator.next();
	
			if(show.getName().equals(showName))
			{
				return show;
			}
		}
		return null;
	}
	
	public int getTotalShowsForClient(Long key)
	{
		return shows.get(key).size();
	}
	
	public boolean isEveryShowListingInClientsPast(Long key)
	{
		ArrayList<Show> temp = shows.get(key);

		if(temp != null)
		{
			for(int i = 0; i < temp.size(); ++i)
			{
				Calendar today = DateUtils.getGregorianCalendarStartingTodayAtBeginningOfDay();
			
				if(temp.get(i).getEndDate().getTimeInMillis() >= today.getTimeInMillis()) //if end date of the show is later in the future than right now, then client can't be removed
				{
					return false;
				}
			} 
		}
		return true;
	}
	
	/**
	 * Checks if the show overlaps other shows
	 * @param begDate start date
	 * @param endDate end date
	 * @return true if overlap, false if no overlap
	 */
	public boolean isShowOverlappingOtherShows(Calendar begDate, Calendar endDate) //returns true if show overlaps other shows
	{
		//ArrayList<Show> arrList = shows.get(key);
		
		ArrayList<Show> arrList;
		
		for(Entry<Long, ArrayList<Show>> entry : shows.entrySet())
		{
			arrList = entry.getValue();
			
			for(int i = 0; i < arrList.size(); ++i)
			{
				if(begDate.getTimeInMillis() > arrList.get(i).getBeginDate().getTimeInMillis())
				{
					if(begDate.getTimeInMillis() < arrList.get(i).getEndDate().getTimeInMillis())
					{
						return true;
					}
				}
				if(begDate.getTimeInMillis() < arrList.get(i).getBeginDate().getTimeInMillis())
				{
					if(endDate.getTimeInMillis() > arrList.get(i).getBeginDate().getTimeInMillis())
					{
						return true;
					}
				}
				if(begDate.getTimeInMillis() == arrList.get(i).getBeginDate().getTimeInMillis())
				{
					System.out.println("Loop3");
					return true;
				}
			}
		}
		return false;	
	}

	/*
	public static void main(String[] args)
	{
		ShowsCollection sc = new ShowsCollection();
		Long key = new Long("12345");
		
		Show show1 = new Show("Superbad");
		Show show2 = new Show("Zombieland");
		Show show3 = new Show("Blackhawk Down");
		
		sc.add(key, show1);
		sc.add(key, show2);
		sc.add(key, show3);
		
		//check for null to see i showName is null before getting name
		Show showName = sc.getClientShow(key, "Zombieland");
		if(showName != null)
		{
			System.out.println(showName.getName());
		}
		else
		{
			System.out.println("null");
		}
		
		
	}
	*/
}
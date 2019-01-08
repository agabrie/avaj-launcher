
/*************************** DONE? ***************************/

import java.util.List;
import java.util.ArrayList;

class Tower
{
	private List<Flyable> observers = new ArrayList<Flyable>();
	public void register(Flyable flyable)
	{
		if(!observers.contains(flyable))
			observers.add(flyable);
	}
	public void unregister(Flyable flyable)
	{
		observers.remove(flyable);
	}
	protected void conditionsChanged()
	{
		for(flyable x : observers)
		{
			x.updateConditions();
		}
	}
}

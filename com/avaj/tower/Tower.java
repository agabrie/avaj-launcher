
// package com.avaj.avaj.tower.tower;
package com.avaj.tower;
import com.avaj.air.Flyable;
/*************************** DONE? ***************************/
import java.util.List;
import java.util.ArrayList;

public class Tower
{
	// -	observers : Flyable*
	private List<Flyable> observers = new ArrayList<Flyable>();
	private List<Flyable> landed = new ArrayList<Flyable>();

	// +	register(flyable Flyable) : void
	public void register(Flyable flyable)
	{
		if(!observers.contains(flyable)){
			observers.add(flyable);
		}
	}
	// +	unregister(flyable Flyable) : void
	public void unregister(Flyable flyable)
	{
		landed.add(flyable);
	}
	// #	conditionsChanged() : void
	protected void conditionsChanged()
	{
		for(Flyable x : observers)
		{
			x.updateConditions();
		}
		observers.removeAll(landed);
	}
}























































/**************************************** AGABRIE ****************************************/

package avaj.tower.tower;
/*************************** DONE? ***************************/
import avaj.aircraft.flyable;
import java.util.List;
import java.util.ArrayList;

class Tower
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

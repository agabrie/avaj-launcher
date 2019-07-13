package avaj.aircraft.aircraft;
/*************************** AGABRIE ***************************/
import avaj.tower.tower;
import avaj.sim.coordinates;
import avaj.sim.printyclass;
class Aircraft
{
	// #	id : long
	protected long			id;
	// #	name : string
	protected String		name;
	// #	coordinates : Coordinates
	protected Coordinates	coordinates;
	// -	idCounter : long
	private static long		idCounter = 0;
	// #	Aircraft(name : string, coordinates : Coordinates) : constructor
	protected Aircraft(String name, Coordinates coordinates)
	{
		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
	}
	// -	nextId() : long
	private long nextId()
	{
		return (++idCounter);
	}

	public<A> void output(A aircraft,String weather){
		PrintyClass.writeToFile(String.format("%s# %s (%d): %s\n",aircraft.getClass().getSimpleName(),name,id, weather));
	}
	// public<A> void output(String className, String name, long id, String weather){
	// 	PrintyClass.writeToFile(String.format("%s# %s (%d): %s\n",className,name,id, weather));
	// }
	public <A> void unregisterOutput(A aircraft){
		if (coordinates.getHeight() <= 0)
        {
			PrintyClass.writeToFile(aircraft.getClass().getSimpleName()+"#" + name + "(" + id + "): landing.\n");
			PrintyClass.writeToFile("Tower says: "+aircraft.getClass().getSimpleName()+"#" + name + "(" + id + ")" + " unregistered from weather tower.\n");
			// System.out.println(this.getClass().getSimpleName()+"#" + this.name + "(" + this.id + "): landing.");
			// System.out.println("Tower says: "+this.getClass().getSimpleName()+"#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
		}
	}
	public <A> void registerOutput(A aircraft){
		PrintyClass.writeToFile(String.format("Tower says: %s# %s (%d) registered to weather tower.\n",aircraft.getClass().getSimpleName(),name, id));
		// System.out.printf("Tower says: %s# %s (%d) registered to weather tower.\n",this.getClass().getSimpleName(),this.name, this.id);
	}
	// public String getName(){
	// 	return name;
	// }
	// public long getID(){
	// 	return id;
	// }
} 
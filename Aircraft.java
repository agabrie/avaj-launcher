
/*************************** AGABRIE ***************************/

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
} 
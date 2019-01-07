class Aircraft
{
	protected long			id;
	protected Coordinates	coordinates;
	protected String		name;
	private static long		idCounter = 0;
	
	protected Aircraft(String name, Coordinates coordinates)
	{
		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
	}

	private long nextId()
	{
		return (++idCounter);
	}
} 
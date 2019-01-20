import java.util.*;
class Balloon extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;
	public Balloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}
	public void updateConditions()
	{
		HashMap<String, String> weatherMap = new HashMap<String, String>() {{
            put("SUN", "Aaaaaah, that's hot... that's hot.");
            put("RAIN", "Let's hope THIS 'water balloon' doesn't burst.");
            put("FOG", "This cloud is THICC");
            put("SNOW", "What'd happen if I threw a snowball from up here?");
        }};
		String weather = weatherTower.getWeather(this.coordinates);
		switch(weather)
		{
			case "SUN":
    			this.coordinates = new Coordinates(coordinates.getLongitude() + 2,coordinates.getLatitude() + 0,coordinates.getHeight() + 4);
    		case "RAIN":
            	this.coordinates = new Coordinates(coordinates.getLongitude() + 0,coordinates.getLatitude() + 0,coordinates.getHeight() - 5);
        	case "FOG":
            	this.coordinates = new Coordinates(coordinates.getLongitude() + 0,coordinates.getLatitude() + 0,coordinates.getHeight() - 3);
        	case "SNOW":
        	    this.coordinates = new Coordinates(coordinates.getLongitude() + 0,coordinates.getLatitude() + 0,coordinates.getHeight() - 15);
		}
		System.out.printf("%s# %s (%d): %s\n",this.getClass().getSimpleName(),this.name,this.id, weatherMap.get(weather));
		if (this.coordinates.getHeight() <= 0)
        {
            System.out.println(this.getClass().getSimpleName()+"#" + this.name + "(" + this.id + "): landing.");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: "+this.getClass().getSimpleName()+"#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
	}
	public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.printf("Tower says: %s# %s (%d) registered to weather tower.\n",this.getClass().getSimpleName(),this.name, this.id);
    }
}
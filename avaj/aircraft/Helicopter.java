package avaj.aircraft.helicopter;
import java.util.HashMap;
class Helicopter extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;
	public Helicopter(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}
	public void updateConditions()
	{
		HashMap<String, String> weatherMap = new HashMap<String, String>() {{
            put("SUN", "Sure wish the fan on this thing was on the inside...");
            put("RAIN", "Who thought it was a good idea to not put doors on this thing!?");
            put("FOG", "If only helicopters had fans...r/whoosh");
            put("SNOW", "Winter is coming...");
        }};
		String weather = weatherTower.getWeather(this.coordinates);
		switch(weather)
		{
			case "SUN":
    			this.coordinates = new Coordinates(coordinates.getLongitude() + 10,coordinates.getLatitude() + 0,coordinates.getHeight() + 2);
    		case "RAIN":
            	this.coordinates = new Coordinates(coordinates.getLongitude() + 5,coordinates.getLatitude() + 0,coordinates.getHeight() + 0);
        	case "FOG":
            	this.coordinates = new Coordinates(coordinates.getLongitude() + 1,coordinates.getLatitude() + 0,coordinates.getHeight() + 0);
        	case "SNOW":
        	    this.coordinates = new Coordinates(coordinates.getLongitude() + 0,coordinates.getLatitude() + 0,coordinates.getHeight() - 12);
		}
		output(this, weatherMap.get(weather));
		if (this.coordinates.getHeight() <= 0)
        {
			unregisterOutput(this);
		
            this.weatherTower.unregister(this);
		}
	}
	public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		registerOutput(this);
		
    }
}
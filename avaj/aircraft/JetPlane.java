package avaj.aircraft.jetplane;
import java.util.HashMap;
class JetPlane extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;
	public JetPlane(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}
	public void updateConditions()
	{
		HashMap<String, String> weatherMap = new HashMap<String, String>() {{
            put("SUN", "*starts sweating profusely*");
            put("RAIN", "We should start a company that sells sprinklers...");
            put("FOG", "I can't see anything -_-");
            put("SNOW", "You think i can make a snow angel in a building? ba-dum-tss...OwO");
        }};
		String weather = weatherTower.getWeather(this.coordinates);
		switch(weather)
		{
			case "SUN":
    			this.coordinates = new Coordinates(coordinates.getLongitude() + 0,coordinates.getLatitude() + 10,coordinates.getHeight() + 2);
    		case "RAIN":
            	this.coordinates = new Coordinates(coordinates.getLongitude() + 0,coordinates.getLatitude() + 5,coordinates.getHeight() + 0);
        	case "FOG":
            	this.coordinates = new Coordinates(coordinates.getLongitude() + 0,coordinates.getLatitude() + 1,coordinates.getHeight() + 0);
        	case "SNOW":
        	    this.coordinates = new Coordinates(coordinates.getLongitude() + 0,coordinates.getLatitude() + 0,coordinates.getHeight() - 7);
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
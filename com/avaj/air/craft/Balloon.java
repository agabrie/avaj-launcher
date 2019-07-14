package com.avaj.air.craft;

import com.avaj.air.*;
import com.avaj.misc.Coordinates;
import com.avaj.tower.WeatherTower;

import java.util.HashMap;

@SuppressWarnings("serial")
public class Balloon extends Aircraft implements Flyable
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
		if (this.coordinates.getHeight() <= 0)
        {
			unregisterOutput(this);
            this.weatherTower.unregister(this);
		}
		else
			output(this, weatherMap.get(weather));
	}
	public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		registerOutput(this);
		
    }
}







































/**************************************** AGABRIE ****************************************/
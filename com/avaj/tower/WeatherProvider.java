package com.avaj.tower;

import com.avaj.misc.Coordinates;

public class WeatherProvider
{
	/*
		Exosphere: 700 to 10,000 km (440 to 6,200 miles)
		Thermosphere: 75 to 100 km
		Mesosphere: 50 to 75 km
		Stratosphere: 25 to 50 km
		Troposphere: 0 to 25 km
	*/
	public final int Exosphere = 0;
	public final int Thermosphere = 1;
	public final int Mesosphere = 2;
	public final int Stratosphere = 3;
	public final int Troposphere = 4;
	
	private static WeatherProvider weatherProvider =  new WeatherProvider();
	private String [] weather = {"RAIN", "SUN", "SNOW", "FOG"};

	private WeatherProvider()
	{
	}
	public static WeatherProvider getProvider()
	{
		return (weatherProvider);
	}

	public String getCurrentWeather(Coordinates coords)
	{
		int index = 0;
		if(getHemisphere(coords.getLongitude())){				// Northern
			if(getMeridian(coords.getLatitude()))
				index = 0;										//	//	Eastern
			else
				index = 1;										//	//	Western
		}
		else{													// Southern
			if(getMeridian(coords.getLatitude()))
				index = 2;										//	//	Eatern
			else
				index = 3;										//	//	Western
		}
		return(cycleWeather(coords.getHeight(),index));
	}

	public String cycleWeather(int height, int index)
	{
		int atmosphere = getAtmosphere(height);
		int shift = Math.abs((3 - index) - atmosphere);
		if(shift == 4)
			shift = 0;
		return (weather[shift]);
	}
	public boolean getHemisphere(int longitude)
	{
		if(longitude % 2 == 0)
			return(true);
		else
			return(false);
	}
	public boolean getMeridian(int latitude)
	{
		if(latitude % 2 == 0)
			return(true);
		else
			return(false);
	}
	public int getAtmosphere(int height)
	{
		/*	returns which atmosphere the aircraft is currently in	*/

		if		(height >= 75	&& height <= 100	)	// Exosphere
			return (4);
		else if	(height >= 50	&& height < 75		)	// Thermosphere
			return (3);
		else if	(height >= 25	&& height < 50		)	// Mesosphere
			return (2);
		else if	(height >= 0	&& height < 25		)	// Stratosphere
			return (1);
		else											// Troposphere
			return (0);
	}

	public String toString(Coordinates coords)
	{
		String lon = (getHemisphere(coords.getLongitude()) ? "Northern Hemisphere" : "Southern Hemisphere");
		String lat = (getMeridian(coords.getLatitude()) ? "Eastern Hemisphere" : "Western Hemisphere");
		String y;
/**************************************** AGABRIE ****************************************/
		switch(getAtmosphere(coords.getHeight()))
		{	
			case 1:
				y = "Stratosphere";
				break;
			case 2:
				y = "Mesosphere";
				break;
			case 3:
				y = "Thermosphere";
				break;
			case 4:
				y = "Exosphere";
				break;
			default:
				y = "Troposphere";
				break;
		}
		return String.format("longitude : %s\nlatitude : %s\nheight : %s\n", lon + " : " + coords.getLongitude(), lat + " : " + coords.getLatitude(), y + " : " + getAtmosphere(coords.getHeight()));
	}
}
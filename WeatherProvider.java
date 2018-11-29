class WeatherProvider
{
	/*
		Exosphere: 700 to 10,000 km (440 to 6,200 miles)
		Thermosphere: 80 to 700 km (50 to 440 miles)[11]
		Mesosphere: 50 to 80 km (31 to 50 miles)
		Stratosphere: 12 to 50 km (7 to 31 miles)
		Troposphere: 0 to 12 km (0 to 7 miles)[12]
	*/
	public final int Exosphere = 0;
	public final int Thermosphere = 1;
	public final int Mesosphere = 2;
	public final int Stratosphere = 3;
	public final int Troposphere = 4;
	
	private WeatherProvider weatherProvider;
	private String [] weather = {"RAIN", "SUN", "FROST", "WIND"};

	public WeatherProvider()
	{
	}
	public WeatherProvider getProvider()
	{
		return (weatherProvider);
	}
	public String getCurrentWeather(Coordinates coords)
	{
		System.out.println(toString(coords));
		int index = 0;
		if(getHemisphere(coords.getLongitude())){			// Northern
			if(getMeridian(coords.getLatitude()))
				index = 0;											//	Eastern
			else
				index = 1;											//	Western
		}
		else{												// Southern
			if(getMeridian(coords.getLatitude()))
				index = 2;											//	Eatern
			else
				index = 3;											//	Western
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
		if(longitude >= 0)
			return(true);
		else
			return(false);
	}
	public boolean getMeridian(int latitude)
	{
		if(latitude >= 0)
			return(true);
		else
			return(false);
	}
	public int getAtmosphere(int height)
	{
		/*	returns which atmosphere the aircraft is currently in	*/

		if		(height >= 700	&& height < 10000	)	// Exosphere
			return (4);
		else if	(height >= 80	&& height < 700		)	// Thermosphere
			return (3);
		else if	(height >= 50	&& height < 80		)	// Mesosphere
			return (2);
		else if	(height >= 12	&& height < 50		)	// Stratosphere
			return (1);
		else											// Troposphere
			return (0);
	}

	public String toString(Coordinates coords)
	{
		String lon = (getHemisphere(coords.getLongitude()) ? "Northern Hemisphere" : "Southern Hemisphere");
		String lat = (getMeridian(coords.getLatitude()) ? "Eastern Hemisphere" : "Western Hemisphere");
		String y;
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
import java.lang.Math;
class FirstClass
{
	
	public static void main(String []args)
	{
		int rain = 0;
		int sun = 0;
		int frost = 0;
		int wind = 0;
		Coordinates coords;
		// WeatherProvider wp;
		for(int i = 0; i < 10; i++)
		{
			coords = new Coordinates((int)(Math.random()*360-180), (int)(Math.random()*360-180), (int)(Math.random()*10000));
			System.out.printf("Coordinate : (longitude : %d,latitude : %d,height : %d)\nCurrent Weather :%5s\n\n",coords.getLongitude(),coords.getLatitude() , coords.getHeight(), WeatherProvider.getProvider().getCurrentWeather(coords));
			switch(WeatherProvider.getProvider().getCurrentWeather(coords))
			{
				case "RAIN":
					rain++;
					break;
				case "SUN":
					sun++;
					break;
				case "FROST":
					frost++;
					break;
				case "WIND":
					wind++;
					break;
			}
		}
		System.out.printf("Rain : %d\n", rain);
		System.out.printf("Sun : %d\n", sun);
		System.out.printf("Frost : %d\n", frost);
		System.out.printf("Wind : %d\n", wind);
	}
}
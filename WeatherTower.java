class WeatherTower extends Tower
{
	public String getWeather(Coordinates coordinates)
	{
		String weather =  WeatherProvider.getProvider().getCurrentWeather(coordinates);
		
		// System.out.println(WeatherProvider.getProvider().toString(coordinates));
		// System.out.printf("Coordinate : (longitude : %d,latitude : %d,height : %d)\nCurrent Weather :%5s\n\n",coordinates.getLongitude(),coordinates.getLatitude() , coordinates.getHeight(), WeatherProvider.getProvider().getCurrentWeather(coordinates));
		// System.out.println(weather);
		return (weather); 
	}
	public void changeWeather()
	{
		this.conditionsChanged();
	}
}
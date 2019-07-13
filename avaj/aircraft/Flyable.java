package avaj.aircraft.flyable;
/*************************** DONE? ***************************/

interface Flyable
{
	public void updateConditions();
	public void registerTower(WeatherTower weathertower);
}
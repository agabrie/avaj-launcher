package com.avaj.misc;
/*************************** DONE? ***************************/

public class Coordinates
{
	private int longitude;
	private int latitude;
	private int height;
	

	public Coordinates(int longitude, int latitude, int height)
	{
		this.longitude	= (longitude > 0 ? longitude % 360 : 0);
		this.latitude	= (latitude > 0	? latitude % 360 : 0);
		this.height		= (height < 100 ? (height > 0 ? height : 0) : 100);
	}
	public int getLongitude()
	{
		return (longitude);
	}
	public int getLatitude()
	{
		return (latitude);
	}
	public int getHeight()
	{
		return (height);
	}
}






























































/**************************************** AGABRIE ****************************************/
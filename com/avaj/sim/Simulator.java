package com.avaj.sim;

import com.avaj.air.*;
import com.avaj.misc.Coordinates;
import com.avaj.misc.PrintyClass;
import com.avaj.tower.WeatherTower;
import com.avaj.tower.WeatherProvider;

import java.lang.Math;
import java.io.*;

public class Simulator
{
	public static int numCycles;
	public static int lineNum;
	public static WeatherTower weatherTower = new WeatherTower();

	private static void runSimulation(String [] args)
	{
		AircraftFactory aircraftFactory = new AircraftFactory();   
		PrintyClass.setFile("simulation.txt");
		if (args.length < 1)
            return;
		String file = args[0];
        try {
			BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
            String line;
            lineNum = 1;
            String[] splitLine;

            while ((line = bReader.readLine()) != null)
            {
                if (lineNum == 1)
				{
                    try {
                        numCycles = Integer.parseInt(line);
                        if (numCycles < 0)
							throw (new Exception("Error: Number of cycles must be greater than 0, not '"+line+"'"));
                    } catch (NumberFormatException e) {
                        throw (new Exception("Error: Number of cycles must be a value, not '"+line+"'"));
                    }
				}
                else
                {
                	// format : TYPE NAME LONG LAT HEIGHT
                    splitLine = line.split(" ");
                    if (splitLine.length == 1 && splitLine[0].isEmpty())
                        continue;
                    if (splitLine.length != 5)
						throw (new Exception("there must be 5 parameters"));
					int longitude,latitude, height;
					try{
					longitude = Integer.parseInt(splitLine[2]) % 360;
					latitude = Integer.parseInt(splitLine[3]) % 360;
					height = Integer.parseInt(splitLine[4]);			
					}catch (NumberFormatException nfe) {
                        throw new Exception("parameters 3 to 5 must be integers");
                        // return;
                    } 
					try {
                        aircraftFactory.newAircraft(splitLine[0],splitLine[1],longitude,latitude,height).registerTower(weatherTower);
                    } catch (Exception ex) {
                        throw new Exception("Incorrect Aircraft Type ["+splitLine[0]+"] found");
                        // return;
                    }
                }
               	// System.out.println(strLine);
                lineNum++;
            }
            bReader.close();
        } catch (Exception e) {
			// bReader.close();
            System.out.println("Error: " + e.getMessage()+" on line number : "+lineNum);

			return;
		}
		WeatherProvider.getProvider();    
	}
	public static void main(String []args)
	{
		debugWeather(false);
		runSimulation(args);
		while(numCycles > 0)
        {
            weatherTower.changeWeather();
            numCycles--;
		}
		PrintyClass.closePrintWriter();
	}



	private static void debugWeather(boolean run)
	{
/**************************************** AGABRIE ****************************************/	
		if (run)
		{
		int rain = 0;
		int sun = 0;
		int snow = 0;
		int fog = 0;
		Coordinates coordinates;
		for(int i = 0; i < 10; i++)
		{
			System.out.println("##########################");
			coordinates = new Coordinates((int)(Math.random()*360), (int)(Math.random()*360), (int)(Math.random()*100));
			System.out.println(WeatherProvider.getProvider().toString(coordinates));
			System.out.printf("Coordinate : (longitude : %d,latitude : %d,height : %d)\nCurrent Weather :%5s\n\n",coordinates.getLongitude(),coordinates.getLatitude() , coordinates.getHeight(), WeatherProvider.getProvider().getCurrentWeather(coordinates));
			switch(WeatherProvider.getProvider().getCurrentWeather(coordinates))
			{
				case "RAIN":
					rain++;
					break;
				case "SUN":
					sun++;
					break;
				case "SNOW":
					snow++;
					break;
				case "FOG":
					fog++;
					break;
			}
		}
		System.out.printf("Rain : %d\n", rain);
		System.out.printf("Sun : %d\n", sun);
		System.out.printf("SNOW : %d\n", snow);
		System.out.printf("FOG : %d\n", fog);
	}
	}
}
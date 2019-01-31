import java.lang.Math;
import java.io.*;
class Simulator
{
	private static void debugWeather()
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
	public static int numCycles;
	public static File simFile;
	public static WeatherTower weatherTower = new WeatherTower();
	private static void runSimulation(String [] args)
	{
		simFile = new File("simulation.txt");
		
		AircraftFactory aircraftFactory = new AircraftFactory();
        
		if (args.length < 1)
            return;
		String file = args[0];
        try {
            // FileInputStream fstream = new FileInputStream(filename);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            String line;
            int lineNum = 1;
            String[] splitLine;

            while ((line = bReader.readLine()) != null)
            {
                if (lineNum == 1)
				{
                    try {
                        numCycles = Integer.parseInt(line);
                        if (numCycles < 0)
                            return;
                    } catch (NumberFormatException e) {
                        return;
                    }
				}
                else
                {
                	// format : TYPE NAME LONG LAT HEIGHT
                    splitLine = line.split(" ");
                    // if (splitLine.length == 1 && splitLine[0].isEmpty())
                    //     continue;
                    // if (splitLine.length != 5)
                    //     throw new Exception("Error: line " + line + ": there must be 5 parameters.");
					int longitude = Integer.parseInt(splitLine[2]) % 360;
					int latitude = Integer.parseInt(splitLine[3]) % 360;
					int height = Integer.parseInt(splitLine[4]);
					
                    try {
                        aircraftFactory.newAircraft(splitLine[0],splitLine[1],longitude,latitude,height).registerTower(weatherTower);
                    } catch (NumberFormatException nfe) {
                        // System.out.println("Error: line " + line + ": parameter 3 to 5 must be integers.");
                        return;
                    } catch (Exception ex) {
                        // System.out.println("Error: " + ex.getMessage());
                        return;
                    }
                }
               	// System.out.println(strLine);
                lineNum++;
            }
            bReader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
		WeatherProvider weatherProvider = WeatherProvider.getProvider();    
	}

	public static void main(String []args)
	{
		// debugWeather();
		runSimulation(args);
		while(numCycles > 0)
        {
            weatherTower.changeWeather();
            numCycles--;
        }
	}
}
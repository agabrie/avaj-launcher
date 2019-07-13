package avaj.aircraft.aircraftfactory;
/*************************** AGABRIE ***************************/
import avaj.sim.coordinates;
import avaj.aircraft.balloon;
class AircraftFactory
{
    // +    newAircraft(type : string, name : string, longitude : int, latitude : int, height : int) : Flyable
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coords = new Coordinates(longitude, latitude, height);
        switch(type)
        {
            case "Balloon":
                return (new Balloon(name, coords));
            case "Helicopter":
                return (new Helicopter(name, coords));
            case "JetPlane":
                return (new JetPlane(name, coords));
            default:
                return null;
        }
        // return();
    }
}
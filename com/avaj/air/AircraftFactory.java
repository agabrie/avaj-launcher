package com.avaj.air;

import com.avaj.air.Flyable;
import com.avaj.air.craft.*;
import com.avaj.misc.Coordinates;

/*************************** AGABRIE ***************************/

public class AircraftFactory
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































































/**************************************** AGABRIE ****************************************/
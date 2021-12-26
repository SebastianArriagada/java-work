package exam20211222.travel.flying;

import java.util.ArrayList;
import java.util.List;

import exam20211222.travel.DateAndTime;
import exam20211222.travel.Destination;

public class FlightWithManyPlanes extends Flight {
    
    protected List<Plane> plane = new ArrayList<>();
    
    public FlightWithManyPlanes( String name, Destination destinationCity, 
        int numberOfTravellers, DateAndTime flightDateAndTime, Plane... planes){

        super(name, destinationCity, numberOfTravellers, flightDateAndTime);
        //new Flight(name, destinationCity, numberOfTravellers, flightDateAndTime);
        //this.name = name;
        for (Plane plane:planes){
            plane.add(plane);
        }
    }

    public List<Plane> getPlanes(){
        return plane;
    }
}

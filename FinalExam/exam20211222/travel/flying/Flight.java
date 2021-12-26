package exam20211222.travel.flying;

import exam20211222.travel.DateAndTime;
import exam20211222.travel.Destination;

public class Flight {
    protected String name;
    protected Destination destinationCity;
    protected int numberOfTravellers;
    protected DateAndTime flightDateAndTime;

    public String getName(){
        return this.name;
    }

    public String getDestinationCity(){
        return String.valueOf(this.destinationCity);
    }

    public int getNumberOfTravellers(){
        return this.numberOfTravellers;
    }

    public String getFlightDateAndTime(){
        return (this.flightDateAndTime).toString();
    }

    public Flight(String name, Destination destinationCity, int numberOfTravellers, DateAndTime flightDateAndTime){
        if ( numberOfTravellers < 15  || numberOfTravellers > 100){ 
            throw  new IllegalArgumentException();
        }
        this.name = name;
        this.destinationCity = destinationCity;
        this.numberOfTravellers = numberOfTravellers;
        this.flightDateAndTime = flightDateAndTime;
    }

    public Flight(){
        this("AirBus", Destination.ROME ,83 , new DateAndTime());

    }

    @Override
    public String toString(){
        String text = "Flying " + this.name + " with " + this.numberOfTravellers + " passengers to " + this.destinationCity + " on " + flightDateAndTime.toString();
        return text;
    }

    public String getFlightDuration(){

        return (this.destinationCity).getHour();
    }
    
}

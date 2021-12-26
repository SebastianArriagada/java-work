package exam20211222.travel.flying;

import java.util.Objects;

import exam20211222.travel.Destination;
import exam20211222.travel.DestinationUtils;

public class Plane extends Flight implements Flyable{

    String name;
    int id;
    int tickedPrice;

    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }
    public int getTicketPrice(){
        return tickedPrice;
    }

    private Plane(String name,int id, int tickedPrice ){
        if (name == null || tickedPrice < 10){
            throw  new IllegalArgumentException();
        }
        this.name = name;
        this.id = id;
        this.tickedPrice = tickedPrice;
    }

    static public Plane make( String data){
        var split = data.split(",");
        String name2 = split[0];
        int id2 = Integer.parseInt(split[1]);
        int tickedPrice2 = Integer.parseInt(split[2]);

        Plane plane = new Plane(name2, id2, tickedPrice2);

        return plane;
    }

    @Override
    public boolean equals(Object that){
        if (that == this){return true;}
        if ( that == null){ return false;}
        if ( that.getClass() != Plane.class){return false;}

        Plane other = (Plane)that;

        return Objects.equals(name, other.name) && 
                Objects.equals( id, other.id) && 
                Objects.equals( tickedPrice, other.tickedPrice);
        }

    @Override
    public int hashCode(){
        return Objects.hash(name, id, tickedPrice);
    }

    @Override
    public String toString(){
        String text = this.name + "," + this.id + "," + this.tickedPrice;
        return text;
    }

    @Override
    public int estimatedArrivalTime(int deartHour, Destination dest) {
        int arriveHour = deartHour + DestinationUtils.getRoundedHours(dest);
        return arriveHour;
    }

    @Override
    public Double getPrice(Double discountRate) {
        if (discountRate < 0){
            throw  new IllegalArgumentException();
        }
        double newPrice = ( 1 - discountRate) * this.tickedPrice;
        return newPrice;
    }
    
}

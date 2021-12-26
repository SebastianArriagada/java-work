package exam20211222.travel.flying;

import exam20211222.travel.Destination;

public interface Flyable {
    
    public int estimatedArrivalTime(int departHour, Destination dest);
    public Double getPrice(Double discountRate);
}

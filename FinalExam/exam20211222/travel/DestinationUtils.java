package exam20211222.travel;

public class DestinationUtils {
    
    public static Destination getDestination(String destine){
        Destination[] destinations = Destination.values();

        for (Destination destination : destinations){
            String dest = destination.getHour();
            if (dest == destine){
                return destination;
            }
        }
        return null;
    }

    public static String getDestinationDuration(Destination destine){
        Destination[] destinations = Destination.values();

        for (Destination destination : destinations){
            String dest = destination.getHour();
            if (destination == destine){
                return dest;
            }
        }
        return null;
    }

    public static int getRoundedHours(Destination dest){
        String time = dest.getHour();
        var split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);

        if (minutes >= 30){return (hour + 1);}
        return hour;
    }

}

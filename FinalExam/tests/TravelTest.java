
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


import exam20211222.travel.DateAndTime;
import exam20211222.travel.Destination;
import exam20211222.travel.DestinationUtils;
import exam20211222.travel.flying.Flight;
import exam20211222.travel.flying.FlightWithManyPlanes;
import exam20211222.travel.flying.Plane;
import exam20211222.travel.flying.Flyable;

public class TravelTest {
    private static final double EPSILON = 0.01;

    // Task 1: DateAndTime

    @Test
    public void testDateAndTimeConstructor1() {
        DateAndTime dateAndTime = new DateAndTime(2021, 8, 12, 12, 30);
        assertEquals(12, dateAndTime.getHour());
        assertEquals(30, dateAndTime.getMinute());
        assertEquals(2021, dateAndTime.getYear());
    }

    @Test
    public void testDateAndTimeConstructor2() {
        DateAndTime dateAndTime = new DateAndTime();
        assertEquals(4, dateAndTime.getHour());
        assertEquals(30, dateAndTime.getMinute());
        assertEquals(2021, dateAndTime.getYear());
    }

    @Test
    public void testDateAndTimeGetTime() {
        DateAndTime dateAndTime = new DateAndTime();
        assertEquals("4:30", dateAndTime.getTime());
    }

    @Test
    public void testDateAndTime() {
        DateAndTime dateAndTime = new DateAndTime(2020, 11, 13, 10, 12);
        assertEquals("2020.11.13 at 10:12", dateAndTime + "");
    }

    // Task 1: Destination
    
    @Test
    public void testDestination() {
        assertEquals(Destination.BERLIN, DestinationUtils.getDestination("01:34"));
        assertEquals(2, DestinationUtils.getRoundedHours(Destination.BERLIN));

        assertEquals(Destination.ROME, DestinationUtils.getDestination("01:45"));
        assertEquals(2, DestinationUtils.getRoundedHours(Destination.ROME));

        assertEquals(Destination.AMSTERDAM, DestinationUtils.getDestination("02:05"));
        assertEquals(2, DestinationUtils.getRoundedHours(Destination.AMSTERDAM));

        assertEquals(Destination.PARIS, DestinationUtils.getDestination("02:20"));
        assertEquals(2, DestinationUtils.getRoundedHours(Destination.PARIS));

        assertEquals(Destination.HELSINKI, DestinationUtils.getDestination("02:43"));
        assertEquals(3, DestinationUtils.getRoundedHours(Destination.HELSINKI));
    }

    // Task 1: Flight
 
    @Test
    public void testFlightConstructor1() {
        Flight flight = new Flight("AFlight", Destination.PARIS, 99, new DateAndTime());
        String name = "PARIS";
        assertEquals("AFlight", flight.getName());
        assertEquals(99, flight.getNumberOfTravellers());
        assertEquals(name, flight.getDestinationCity());
        assertEquals("2021.12.22 at 4:30", flight.getFlightDateAndTime());
     }

    @Test
    public void testFlightConstructor2() {
        Flight flight = new Flight();
        String name = "ROME";
        assertEquals("AirBus", flight.getName());
        assertEquals(83, flight.getNumberOfTravellers());
        assertEquals(name, flight.getDestinationCity());
        assertEquals("2021.12.22 at 4:30", flight.getFlightDateAndTime());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testContractConstructorException1() {
        new Flight("AFlight", Destination.PARIS, 11, new DateAndTime());
    }

    @Test
    public void testFlightGetFlightDuration() {
        Flight fli = new Flight("AFlight", Destination.PARIS, 17, new DateAndTime());
        assertEquals("02:20", fli.getFlightDuration());
    }

    @Test
    public void testDestinationDuration() {
        assertEquals("02:20", DestinationUtils.getDestinationDuration(Destination.PARIS));
        assertEquals("01:45", DestinationUtils.getDestinationDuration(Destination.ROME));
        assertEquals("01:34", DestinationUtils.getDestinationDuration(Destination.BERLIN));
    }

    @Test
    public void testGetApproxFlightDurationFromBuda() {
        assertEquals(2, DestinationUtils.getRoundedHours(Destination.PARIS));
        assertEquals(2, DestinationUtils.getRoundedHours(Destination.ROME));
        assertEquals(2, DestinationUtils.getRoundedHours(Destination.BERLIN));
    }

    // Task 2: Flyable, Airplane

    @Test
    public void testAirplaneDestinationReachTime() {
        Plane plane = Plane.make("airP,12,20");
        assertEquals(12, plane.getId() );

        Flyable flyable = plane;
        assertEquals(14, flyable.estimatedArrivalTime(12, Destination.PARIS));
    }

    // Task 3: Ticket

    @Test
    public void testAirplaneGetTicketDecrease() {
        Flyable plane = Plane.make("airP,12,20");
        assertEquals(16.0, plane.getPrice(0.2), EPSILON );
        assertEquals(10.0, plane.getPrice(0.5), EPSILON );
    }

     @Test(expected = IllegalArgumentException.class)
        public void testEmployeeGetSalaryIncrease2() {
        Flyable plane = Plane.make("airP,12,20");
        assertEquals(18.0, plane.getPrice(0.1), EPSILON );
        assertEquals(18.0, plane.getPrice(-5.0), EPSILON );
     }

    @Test
    public void airplaneEquals() {
        Object a1 = Plane.make("Avareda,14,120");
        Object a2 = Plane.make("Avareda,14,120");
        Object a3 = Plane.make("VanoH,12,130");
        assertTrue(a1.equals(a2));
        assertFalse(a2.equals(a3));
    }

    // // Task 3: FlightWithManyPlanes

	private FlightWithManyPlanes make8() {
		Plane[] planes = {
            Plane.make("Avanreda1,270,120"),
            Plane.make("Avanreda2,270,120"),
            Plane.make("Avanreda3,270,120"),
            Plane.make("Avanreda4,270,120"),
            Plane.make("Avanreda5,270,120"),
            Plane.make("Avanreda6,270,120"),
            Plane.make("Avanreda7,270,120"),
            Plane.make("Avanreda8,270,120")
        };

		return new FlightWithManyPlanes("QatarAirline", Destination.ROME, 90, new DateAndTime(), planes);
	}

    @Test
    public void testManyPlanesConstructor() {
        FlightWithManyPlanes manyPlanes = make8();
        assertEquals("QatarAirline", manyPlanes.getName());
        assertEquals("ROME", manyPlanes.getDestinationCity());
        assertEquals(90, manyPlanes.getNumberOfTravellers());
        assertEquals(8, manyPlanes.getPlanes().size());
    }

    @Test
    public void testManyPlanes() {
        FlightWithManyPlanes manyPlanes = make8();

        List<Plane> planes = manyPlanes.getPlanes();
        planes.add(Plane.make("one more,270,120"));

        assertEquals(8, manyPlanes.getPlanes().size()); 
    }

    // @Test
    // public void testSaveLoad() throws Exception {
    //     String filename = "testflight.txt";

    //     FlightWithManyPlanes origPlanes = make8();
    //     origPlanes.save(filename);

    //     FlightWithManyPlanes testPlanes = new FlightWithManyPlanes("QatarAirline", Destination.ROME, 90, new DateAndTime(), new Plane[0]);
    //     testPlanes.load(filename);

    //     assertEquals(origPlanes.getPlanes(), testPlanes.getPlanes());
    // }
}

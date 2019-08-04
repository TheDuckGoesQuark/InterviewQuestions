package test;

import main.flightitinerary.FlightItinerary;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class FlightItineraryTest {
    @Test
    public void produceItinerary() {
        String[][] input = new String[][]{{"HNL", "AKL"}, {"YUL", "ORD"}, {"ORD", "SFO"}, {"SFO", "HNL"}};
        String startingAirport = "YUL";
        String[] expected = new String[]{"YUL", "ORD", "SFO", "HNL", "AKL"};

        Optional<String[]> result = FlightItinerary.produceItinerary(input, startingAirport);
        assertTrue(result.isPresent());
        assertArrayEquals(expected, result.get());
    }

    @Test
    public void produceItineraryNoSolution() {
        String[][] input = new String[][]{{"HNL", "AKL"}, {"YUL", "ORD"}, {"SFO", "HNL"}};
        String startingAirport = "YUL";

        Optional<String[]> result = FlightItinerary.produceItinerary(input, startingAirport);
        assertFalse(result.isPresent());
    }
}
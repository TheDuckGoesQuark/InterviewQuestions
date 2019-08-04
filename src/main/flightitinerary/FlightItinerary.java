package main.flightitinerary;

import java.util.*;

/**
 * Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs,
 * and a starting airport, compute the person's itinerary.
 * If no such itinerary exists, return null. All flights must be used in the itinerary.
 * <p>
 * For example, given the following list of flights:
 * <p>
 * HNL ➔ AKL
 * YUL ➔ ORD
 * ORD ➔ SFO
 * SFO ➔ HNL
 * and starting airport YUL, you should return YUL ➔ ORD ➔ SFO ➔ HNL ➔ AKL.
 */
public class FlightItinerary {

    /**
     * Returns a itinerary string array of each airport to stop at in order,
     * or empty optional if no possible itinerary can be created
     *
     * @param flights     origin-destination pairs of airport names, i.e. {@code flights[i][0] -> flights[i][1]}
     * @param homeAirport the airport that the itinerary must start and end at
     * @return a itinerary string array of each airport to stop at in order,
     * or empty optional if no possible itinerary can be created
     */
    public static Optional<String[]> produceItinerary(String[][] flights, String homeAirport) {
        Optional<Stack<String[]>> result = recursivelyFindItinerary(new LinkedList<>(Arrays.asList(flights)), new Stack<>(), homeAirport);

        if (result.isEmpty()) return Optional.empty();

        Stack<String[]> flightStack = result.get();
        String[] itinerary = new String[flightStack.size() + 1];

        for (int i = flightStack.size(); i > 0; i--) {
            itinerary[i] = flightStack.pop()[1];
        }

        itinerary[0] = homeAirport;

        return Optional.of(itinerary);
    }

    /**
     * yul, ord, sfo, hnl, ask
     */

    /**
     * @param flights     origin-destination pairs of airport names that can still be used
     * @param usedFlights flights used so far in itinerary
     * @param origin      airport that we must start from
     * @return a itinerary string array of each airport to stop at in order,
     * or empty optional if no possible itinerary can be created
     */
    private static Optional<Stack<String[]>> recursivelyFindItinerary(LinkedList<String[]> flights, Stack<String[]> usedFlights, String origin) {
        // Base case: all flights consumed
        if (flights.isEmpty())
            return Optional.of(usedFlights);

        // Try each next possible flight
        for (int i = 0; i < flights.size(); i++) {
            String[] flight = flights.remove(i);
            usedFlights.push(flight);

            // If flight leaves from current airport
            if (flight[0].equals(origin)) {
                Optional<Stack<String[]>> result = recursivelyFindItinerary(flights, usedFlights, flight[1]);

                if (result.isPresent())
                    return result;
            }

            flights.add(i, usedFlights.pop());
        }

        return Optional.empty();
    }
}

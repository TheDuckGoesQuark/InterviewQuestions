package main.flightitinerary;

import javax.swing.text.html.Option;
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
        return recursivelyFindItinerary(Arrays.asList(flights), new Stack<>(), homeAirport, homeAirport)
                .map(strings -> (String[]) (strings.toArray()));
    }

    /**
     * @param flights     origin-destination pairs of airport names that can still be used
     * @param usedFlights flights used so far in itinerary
     * @param origin      airport that we must start from
     * @param end         airport that we must return to eventually
     * @return a itinerary string array of each airport to stop at in order,
     * or empty optional if no possible itinerary can be created
     */
    private static Optional<Stack<String[]>> recursivelyFindItinerary(List<String[]> flights, Stack<String[]> usedFlights, String origin, String end) {
        // Base case: all flights consumed and we're back home!
        if (flights.isEmpty() && origin.equals(end))
            return Optional.of(usedFlights);

        // Base case: no way home left, not worth proceeding
        if (flights.stream().noneMatch(originDestinationPair -> originDestinationPair[1].equals(end)))
            return Optional.empty();

        // Try each next possible flight
        for (int i = 0; i < flights.size(); i++) {
            String[] flight = flights.remove(i);

            // If flight leaves from current airport
            if (flight[0].equals(origin)) {
                usedFlights.push(flight);
                Optional<Stack<String[]>> result = recursivelyFindItinerary(flights, usedFlights, flight[0], end);

                if (result.isPresent())
                    return result;
                else
                    flights.add(usedFlights.pop());
            }
        }

        return Optional.empty();
    }
}

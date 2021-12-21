package interview.sort5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * racing horses - There are 25 horses. You can take 5 of the horses at a time and race them. Each horse always finishes the race in the same amount of time, and there are no ties. The only information you get from each race is the order that the 5 horses finished in.
 * What is the smallest number of races you need to find the 3 fastest horses, in order?
 */
public class HorseRacer {

    private int raceCounter = 0;

    public Horse[] getTopThreeHorses(Horse[] horses) {
        this.raceCounter=0;

        var horseWindow = new Horse[5];
        System.arraycopy(horses, 0, horseWindow, 0, 5);

        race(horseWindow);
        for (int i = 5; i < horses.length; i+=2) {
            // bring in next two horses
            horseWindow[3] = horses[i];
            if ((i +1) < horses.length) {
                horseWindow[4] = horses[i + 1];
            }

            race(horseWindow);
        }

        System.out.println(Arrays.toString(horseWindow));

        return new Horse[]{horseWindow[0], horseWindow[1], horseWindow[2]};
    }

    public int getRaceCounter() {
        return raceCounter;
    }

    private void race(Horse[] horseWindow) {
        this.raceCounter++;
        Arrays.sort(horseWindow, Comparator.comparingInt(Horse::getFinishTime));
    }
}

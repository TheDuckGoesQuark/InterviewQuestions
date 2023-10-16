package interview.teambuilder;

import java.util.*;

/**
 * A teacher must divide a class of students into two teams to play dodgeball. Unfortunately, not all the kids get along, and several refuse to be put on the same team as that of their enemies.
 * <p>
 * Given an adjacency list of students and their enemies, write an algorithm that finds a satisfactory pair of teams, or returns False if none exists.
 * <p>
 * For example, given the following enemy graph you should return the teams {0, 1, 4, 5} and {2, 3}.
 * <p>
 * students = {
 * 0: [3],
 * 1: [2],
 * 2: [1, 4],
 * 3: [0, 4, 5],
 * 4: [2, 3],
 * 5: [3]
 * }
 * On the other hand, given the input below, you should return False.
 * <p>
 * students = {
 * 0: [3],
 * 1: [2],
 * 2: [1, 3, 4],
 * 3: [0, 2, 4, 5],
 * 4: [2, 3],
 * 5: [3]
 * }
 */
public class TeamBuilder {

    private static final int TEAMS = 2;

    private static int[][] teamSetToArray(List<Set<Integer>> teams) {
        var arr = new int[teams.size()][];

        for (int i = 0; i < teams.size(); i++) {
            var team = teams.get(i);
            var memberArr = new int[team.size()];
            var memberIndex = 0;
            for (var member : team) {
                memberArr[memberIndex] = member;
                memberIndex++;
            }
            arr[i] = memberArr;
        }

        return arr;
    }

    public static int[][] findTeams(int[][] studentEnemies) {
        var initialTeams = new ArrayList<Set<Integer>>(TEAMS);
        for (int i = 0; i < TEAMS; i++) {
            initialTeams.add(new HashSet<>(studentEnemies.length));
        }
        var teamSets = recursivelyFindTeams(studentEnemies, initialTeams);
        return teamSets == null ? null : teamSetToArray(teamSets);
    }

    private static boolean alreadyInTeam(int studentIndex, ArrayList<Set<Integer>> currentTeams) {
        return currentTeams.stream().anyMatch(t -> t.contains(studentIndex));
    }

    private static boolean enemiesExistInTeam(Set<Integer> team, int[] enemies) {
        return Arrays.stream(enemies).anyMatch(team::contains);
    }

    private static boolean everyoneInTeam(int numStudents, List<Set<Integer>> teams) {
        return teams.stream().map(Set::size).reduce(0, Integer::sum) == numStudents;
    }

    private static List<Set<Integer>> recursivelyFindTeams(int[][] studentEnemies, ArrayList<Set<Integer>> currentTeams) {
        if (everyoneInTeam(studentEnemies.length, currentTeams)) {
            return currentTeams;
        }

        // for each student not already in team
        for (int i = 0; i < studentEnemies.length; i++) {
            if (alreadyInTeam(i, currentTeams)) continue;

            // try adding to each team
            for (int j = 0; j < currentTeams.size(); j++) {
                var team = currentTeams.get(j);

                if (!enemiesExistInTeam(team, studentEnemies[i])) {
                    team.add(i);
                    var validTeams = recursivelyFindTeams(studentEnemies, currentTeams);
                    // found a valid team!
                    if (validTeams != null) return validTeams;
                    else team.remove(i);
                }
            }
        }

        return null;
    }
}

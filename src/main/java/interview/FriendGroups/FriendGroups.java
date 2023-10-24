package interview.FriendGroups;

import java.util.Stack;

/**
 * A classroom consists of N students, whose friendships can be represented in an adjacency list.
 * For example, the following describes a situation where
 * 0 is friends with 1 and 2, 3 is friends with 6, and so on.
 * <p>
 * {0: [1, 2],
 * 1: [0, 5],
 * 2: [0],
 * 3: [6],
 * 4: [],
 * 5: [1],
 * 6: [3]}
 * Each student can be placed in a friend group,
 * which can be defined as the transitive closure of that student's friendship relations.
 * In other words, this is the smallest set such that no student in the group
 * has any friends outside this group.
 * For the example above,
 * the friend groups would be {0, 1, 2, 5}, {3, 6}, {4}.
 * <p>
 * Given a friendship list such as the one above,
 * determine the number of friend groups in the class.
 */
public class FriendGroups {
    public static int numberOfFriendGroups(int[][] friendships) {
        // friendships is a undirected graph
        // problem is find the number of isolated graphs

        // for each person
        // breadth first search to mark each friend as counted in group
        // when no more, +1 to friend group count
        // iterate to next person that isn't marked visited
        // repeat

        var visited = new boolean[friendships.length];
        var groupCount = 0;

        for (int i = 0; i < friendships.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;

            // initialise bfs stack
            var toVisit = new Stack<Integer>();
            var friends = friendships[i];
            for (int friend : friends) {
                toVisit.push(friend);
            }

            while (!toVisit.isEmpty()) {
                var friend = toVisit.pop();
                // ignore if already visited
                if (visited[friend]) continue;

                // mark visited
                visited[friend] = true;
                // add friends to explore stack
                friends = friendships[friend];
                for (int otherFriends: friends) {
                    toVisit.push(otherFriends);
                }
            }

            groupCount++;
        }

        return groupCount;
    }
}

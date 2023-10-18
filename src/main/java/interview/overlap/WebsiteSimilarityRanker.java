package interview.overlap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * You are given a list of (website, user) pairs that represent users visiting websites.
 * Come up with a program that identifies the top k pairs of websites with the greatest similarity.
 * <p>
 * For example, suppose k = 1, and the list of tuples is:
 * <p>
 * [('a', 1), ('a', 3), ('a', 5),
 * ('b', 2), ('b', 6),
 * ('c', 1), ('c', 2), ('c', 3), ('c', 4), ('c', 5)
 * ('d', 4), ('d', 5), ('d', 6), ('d', 7),
 * ('e', 1), ('e', 3), ('e': 5), ('e', 6)]
 * <p>
 * Then a reasonable similarity metric would most likely conclude that a and e are the most similar,
 * so your program should return [('a', 'e')].
 */
public class WebsiteSimilarityRanker {

    static class Website {
        final char id;
        final List<User> visitors = new ArrayList<>();

        Website(char id) {
            this.id = id;
        }
    }

    static class User {
        final int id;
        List<Website> websites = new ArrayList<>();

        User(int id) {
            this.id = id;
        }
    }

    public static char[][] rankKSimilarWebsitesByVisitors(int k, WebsiteVisit[] websiteVisits) {
        // Assumptions:
        // 1. A website is similar to another if the same user visits both
        // e.g. if user 1 visits both websites 'a' and 'b', we can assume those sites are similar

        // 2. A website is more similar to another if multiple users visit both
        // e.g. if user 1 visits websites 'a', 'b', and 'c',
        // and user 2 visits websites 'a', 'b', and 'd'
        // then websites 'a' and 'b' are more similar since two users visit both
        // The thinking here being that the same 'type' of user appreciates both 'a' and 'b', but not 'c' and 'd'.

        // going deeper, we can consider the implied distance between websites that don't share users
        // e.g.
        // User 1 visits websites 'a' and 'b'.
        // User 2 visits websites 'a' and 'c'.
        // We could take this to mean that that user 1 would also enjoy website 'c'
        // but this is a bit too deep for a interview problem

        //  Map<WebsiteId,Website>
        var websites = new HashMap<Character, Website>();
        var users = new HashMap<Integer, User>();

        // iterate over each website visit O(n)
        for (WebsiteVisit websiteVisit : websiteVisits) {
            var websiteId = websiteVisit.websiteId;

            var website = websites.get(websiteId);
            if (website == null) {
                website = new Website(websiteId);
                websites.put(websiteId, website);
            }

            var userId = websiteVisit.userId;
            var user = users.get(userId);
            if (user == null) {
                user = new User(userId);
                users.put(userId, user);
            }

            website.visitors.add(user);
            user.websites.add(website);
        }

        // Map<'a'+'b', SharedUserCount>
        var similarityRankings = new HashMap<String, Integer>(websites.size() * websites.size());

        // iterate over each user O(u)
        for (User value : users.values()) {
            var userWebsites = value.websites;

            // iterate over each of their visits
            for (int i = 0; i < userWebsites.size(); i++) {
                // add "similarity" between each website
                for (int j = 0; j < userWebsites.size(); j++) {
                    if (i == j) continue;
                    var websiteA = userWebsites.get(i);
                    var websiteB = userWebsites.get(j);
                    var similarityRankingKey = websiteA.id < websiteB.id
                            ? new String(new char[]{websiteA.id, websiteB.id})
                            : new String(new char[]{websiteB.id, websiteA.id});
                    similarityRankings.compute(similarityRankingKey, (key, val) -> val == null ? 1 : val + 1);
                }
            }
        }

        return similarityRankings.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .limit(k)
                .map(e -> {
                    var str = e.getKey();
                    return new char[]{str.charAt(0), str.charAt(1)};
                })
                .toArray(char[][]::new);
    }

}

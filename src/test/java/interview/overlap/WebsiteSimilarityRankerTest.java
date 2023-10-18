package interview.overlap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class WebsiteSimilarityRankerTest {

    private final WebsiteVisit[] websiteVisits;
    private final int k;
    private final char[][] expectedResult;

    public WebsiteSimilarityRankerTest(WebsiteVisit[] websiteVisits, int k, char[][] expectedResult) {
        this.websiteVisits = websiteVisits;
        this.k = k;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
                {
                        new WebsiteVisit[]{
                                new WebsiteVisit('a', 1),
                                new WebsiteVisit('a', 3),
                                new WebsiteVisit('a', 5),
                                new WebsiteVisit('b', 2),
                                new WebsiteVisit('b', 6),
                                new WebsiteVisit('c', 1),
                                new WebsiteVisit('c', 2),
                                new WebsiteVisit('c', 3),
                                new WebsiteVisit('c', 4),
                                new WebsiteVisit('c', 5),
                                new WebsiteVisit('d', 4),
                                new WebsiteVisit('d', 5),
                                new WebsiteVisit('d', 6),
                                new WebsiteVisit('d', 7),
                                new WebsiteVisit('e', 1),
                                new WebsiteVisit('e', 3),
                                new WebsiteVisit('e', 5),
                                new WebsiteVisit('e', 6),
                        },
                        1,
                        new char[][]{{'c', 'e'}}
                },
        };
        return Arrays.asList(inputs);
    }


    private static boolean resultsAreEqual(char[][] expected, char[][] actual) {
        if (expected.length != actual.length) return false;

        for (int i = 0; i < expected.length; i++) {
            var expectTuple = expected[i];
            var actualTuple = actual[i];

            // sort both tuples so entries appear in same order
            Arrays.sort(expectTuple);
            Arrays.sort(actualTuple);

            if (expectTuple.length != actualTuple.length) return false;

            for (int j = 0; j < expectTuple.length; j++) {
                if (expectTuple[j] != actualTuple[j]) return false;
            }
        }

        return true;
    }

    @Test
    public void rankKSimilarWebsitesByVisitors() {
        var similarWebsites = WebsiteSimilarityRanker.rankKSimilarWebsitesByVisitors(k, websiteVisits);
        assertTrue(Arrays.toString(websiteVisits), resultsAreEqual(expectedResult, similarWebsites));
    }
}
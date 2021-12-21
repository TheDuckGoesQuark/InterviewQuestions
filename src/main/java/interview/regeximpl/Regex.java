package interview.regeximpl;

/**
 * Implement regular expression matching with the following special characters:
 * <p>
 * . (period) which matches any single character
 * * (asterisk) which matches zero or more of the preceding element
 * <p>
 * That is, implement a function that takes in a string and a
 * valid regular expression and
 * returns whether or not the string matches the regular expression.
 * <p>
 * For example, given the regular expression "ra."
 * and the string "ray", your function should return true.
 * The same regular expression on the string "raymond" should return false.
 * <p>
 * Given the regular expression ".*at"
 * and the string "chat", your function should return true.
 * The same regular expression on the string "chats" should return false.
 */
public class Regex {

    public static final char DOT = '.';
    public static final char ASTERISK = '*';

    private final State initialState;

    public Regex(String pattern) {
        this.initialState = parsePattern(pattern);
    }

    private State parsePattern(String pattern) {
        State initialState = new State();

        State prevState = initialState;
        for (int i = 0; i < pattern.length(); i++) {
            char current = pattern.charAt(i);
            switch (current) {
                case ASTERISK:
                    // if asterisk we copy possible transitions of the initial state and become the initial state
                    prevState.copyTransitions(initialState);
                    initialState = prevState;
                    break;
                case DOT:
                default:
                    State nextState = new State();
                    prevState.addTransition(current, nextState);
                    prevState = nextState;
                    break;
            }
        }

        prevState.setAccepting(true);
        return initialState;
    }

    public boolean matches(String str) {
        return recursivelyMatch(str, this.initialState, 0);
    }

    private boolean recursivelyMatch(String str, State currentState, int currentIndex) {
        if (currentIndex == str.length()) {
            return currentState.isAccepting();
        }

        char current = str.charAt(currentIndex);

        for (State state : currentState.getNextStates(current)) {
            if (recursivelyMatch(str, state, currentIndex + 1)) return true;
        }

        return false;
    }
}

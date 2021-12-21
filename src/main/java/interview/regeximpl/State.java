package interview.regeximpl;

import java.util.*;

import static interview.regeximpl.Regex.DOT;

public class State {

    private final Map<Character, Set<State>> transitions = new HashMap<>();
    private boolean accepting = false;

    public State() {
    }

    public void addTransition(char character, State nextState) {
        transitions.computeIfAbsent(character, newCharacter -> new HashSet<>());
        transitions.get(character).add(nextState);
    }

    public Set<State> getNextStates(char input) {
        Set<State> nextStates = new HashSet<>();

        // return next states for specific character
        if (transitions.containsKey(input))
            nextStates.addAll(transitions.get(input));

        // any input is acceptable if dot is given
        if (transitions.containsKey(DOT))
            nextStates.addAll(transitions.get(DOT));

        return nextStates;
    }

    public void copyTransitions(State state) {
        transitions.putAll(state.transitions);
    }

    public boolean isAccepting() {
        return accepting;
    }

    public void setAccepting(boolean accepting) {
        this.accepting = accepting;
    }
}

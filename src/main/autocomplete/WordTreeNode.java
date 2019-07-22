package main.autocomplete;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class WordTreeNode {

    private static final Character WORD_END_CHARACTER = '_';

    private Character value;
    private Map<Character, WordTreeNode> possibleWords = new HashMap<>();

    public WordTreeNode(Character value) {
        this.value = Character.toLowerCase(value);
    }

    public Character getValue() {
        return value;
    }

    public Optional<WordTreeNode> getNextNodeForCharacter(Character nextCharacter) {
        return possibleWords.containsKey(nextCharacter) ? Optional.ofNullable(possibleWords.get(nextCharacter)) : Optional.empty();
    }

    private boolean isEndOfWord() {
        return value.compareTo(WORD_END_CHARACTER) == 0;
    }

    public void addWord(String suffix) throws Exception {
        if (this.isEndOfWord()) return;

        suffix = suffix.toLowerCase();

        // If reached end of word
        if (suffix.isEmpty() && !possibleWords.containsKey(WORD_END_CHARACTER)) {
            possibleWords.put(WORD_END_CHARACTER, new WordTreeNode(WORD_END_CHARACTER));
        } else {
            char nextChar = suffix.charAt(0);
            if (!possibleWords.containsKey(nextChar))
                possibleWords.put(nextChar, new WordTreeNode(nextChar));

            possibleWords.get(nextChar).addWord(suffix.substring(1));
        }
    }

    /**
     * Traverses the tree according to the suffix
     * until reaching the node that contains the last letter
     *
     * @param prefix string to guide tree traversal with
     * @return empty if no node exists, or the node for that suffix
     */
    public Optional<WordTreeNode> findNodeForWord(String prefix) {
        prefix = prefix.toLowerCase();

        if (prefix.isEmpty()) return Optional.of(this);

        char nextChar = prefix.charAt(0);
        if (!possibleWords.containsKey(nextChar)) return Optional.empty();
        else return possibleWords.get(nextChar).findNodeForWord(prefix.substring(1));
    }

    /**
     * Generated all words by prepending the given suffix to all possible combinations of words in the tree
     *
     * @param prefix     word typed so far
     * @param wordsSoFar words added so far
     * @return
     */
    public void populateSetOfSuggestions(String prefix, Set<String> wordsSoFar) {
        if (this.isEndOfWord()) {
            wordsSoFar.add(prefix.substring(0, prefix.length() - 1));
        }

        this.possibleWords.forEach((nextChar, treeNode) -> {
            treeNode.populateSetOfSuggestions((prefix + nextChar).toLowerCase(), wordsSoFar);
        });
    }

}

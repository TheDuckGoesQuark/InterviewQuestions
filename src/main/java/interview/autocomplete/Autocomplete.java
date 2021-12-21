package interview.autocomplete;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Autocomplete {

    private Map<Character, WordTreeNode> dictionary = new HashMap<>();

    public Autocomplete(Set<String> dictionary) throws Exception {
        for (String word : dictionary) {
            this.addWord(word);
        }
    }

    public void addWord(String word) throws Exception {
        char firstChar = word.charAt(0);

        if (!this.dictionary.containsKey(firstChar))
            this.dictionary.put(firstChar, new WordTreeNode(firstChar));

        this.dictionary.get(firstChar).addWord(word.substring(1));
    }

    public Set<String> getSuggestions(String prefix) {
        Set<String> suggestions = new HashSet<>();

        if (prefix.isEmpty()) {
            // If prefix is empty, we provide all words by prepending each possible first character
            for (WordTreeNode wordTreeNode : dictionary.values()) {
                wordTreeNode.populateSetOfSuggestions(wordTreeNode.getValue() + prefix, suggestions);
            }
        } else {
            char firstChar = prefix.charAt(0);

            if (dictionary.containsKey(firstChar)) {
                // Find node for the last letter of the string that has been given
                String suffix = prefix.substring(1);
                dictionary.get(firstChar).findNodeForWord(suffix)
                        // Provide all possible next words
                        .ifPresent(wordTreeNode -> wordTreeNode.populateSetOfSuggestions(prefix, suggestions));
            }
        }

        return suggestions;
    }
}

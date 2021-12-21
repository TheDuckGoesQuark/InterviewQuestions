package interview;

import interview.autocomplete.Autocomplete;
import interview.autocomplete.WordTreeNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

public class AutocompleteTests {

    @Test
    public void addWord() throws Exception {
        // Add first word
        WordTreeNode root = new WordTreeNode('C');
        root.addWord("at");

        assertEquals('c', root.getValue().charValue());

        Optional<WordTreeNode> optANode = root.getNextNodeForCharacter('a');
        assertTrue(optANode.isPresent());
        assertEquals('a', optANode.get().getValue().charValue());

        Optional<WordTreeNode> optTNode = optANode.get().getNextNodeForCharacter('t');
        assertTrue(optTNode.isPresent());
        assertEquals('t', optTNode.get().getValue().charValue());

        Optional<WordTreeNode> optEndNode = optTNode.get().getNextNodeForCharacter('_');
        assertTrue(optEndNode.isPresent());
        assertEquals('_', optEndNode.get().getValue().charValue());

        // Add another word that should extend previous branch
        root.addWord("atch");
        Optional<WordTreeNode> optChNode = optTNode.get().getNextNodeForCharacter('c');
        Optional<WordTreeNode> optHNode = optChNode.get().getNextNodeForCharacter('h');
        Optional<WordTreeNode> secondEndNode = optHNode.get().getNextNodeForCharacter('_');
        assertEquals('_', secondEndNode.get().getValue().charValue());

        // Add word that splits off
        root.addWord("abby");
        assertTrue(optANode.get().getNextNodeForCharacter('b')
                .get().getNextNodeForCharacter('b')
                .get().getNextNodeForCharacter('y')
                .get().getNextNodeForCharacter('_')
                .isPresent());
    }


    @Test
    public void findNodeForWord() throws Exception {
        WordTreeNode root = new WordTreeNode('C');
        root.addWord("at");
        root.addWord("abby");
        root.addWord("atch");

        WordTreeNode catNode = root.findNodeForWord("at").orElseGet(() -> {
            fail();
            return null;
        });
        assertEquals('t', catNode.getValue().charValue());

        WordTreeNode catchNode = root.findNodeForWord("atch").orElseGet(() -> {
            fail();
            return null;
        });
        assertEquals('h', catchNode.getValue().charValue());

        WordTreeNode cabbyNode = root.findNodeForWord("abby").orElseGet(() -> {
            fail();
            return null;
        });
        assertEquals('y', cabbyNode.getValue().charValue());
    }

    @Test
    public void populateSetOfSuggestions() throws Exception {
        WordTreeNode root = new WordTreeNode('C');
        root.addWord("at");
        root.addWord("abby");
        root.addWord("atch");
        root.addWord("apable");
        root.addWord("allout");
        root.addWord("apping");
        root.addWord("ap");

        HashSet<String> suggestions = new HashSet<>();
        root.populateSetOfSuggestions("c", suggestions);

        assertEquals(7, suggestions.size());
        assertTrue(suggestions.contains("cat"));
        assertTrue(suggestions.contains("cabby"));
        assertTrue(suggestions.contains("catch"));
        assertTrue(suggestions.contains("capable"));
        assertTrue(suggestions.contains("callout"));
        assertTrue(suggestions.contains("capping"));
        assertTrue(suggestions.contains("cap"));
    }

    @Test
    public void getSuggestions() throws Exception {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("deer");
        dictionary.add("dog");
        dictionary.add("deal");

        final Autocomplete autocomplete = new Autocomplete(dictionary);
        final Set<String> emptySuggestions = autocomplete.getSuggestions("");
        assertEquals(3, emptySuggestions.size());
        assertTrue(emptySuggestions.contains("deer"));
        assertTrue(emptySuggestions.contains("dog"));
        assertTrue(emptySuggestions.contains("deal"));

        final Set<String> deSuggestions = autocomplete.getSuggestions("de");
        assertEquals(2, deSuggestions.size());
        assertTrue(deSuggestions.contains("deer"));
        assertTrue(deSuggestions.contains("deal"));

        final Set<String> deeSuggestions = autocomplete.getSuggestions("dee");
        assertEquals(1, deeSuggestions.size());
        assertTrue(deeSuggestions.contains("deer"));

        final Set<String> deerSuggestions = autocomplete.getSuggestions("deer");
        assertEquals(1, deerSuggestions.size());
        assertTrue(deerSuggestions.contains("deer"));
    }
}
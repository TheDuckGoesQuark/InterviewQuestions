package test;

import main.secondlargestnode.BinarySearchNode;
import main.secondlargestnode.BinaryTreeSearcher;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;

public class BinaryTreeSearcherTest {

    @Test
    public void findSecondLargestNode() {
        final List<Integer> inputs = new ArrayList<>();

        final Random random = new Random(1);
        for (int i = 1; i < 100; i++) {
            inputs.add(i-1);
            Collections.shuffle(inputs, random);

            BinarySearchNode<Integer> root = new BinarySearchNode<>(i);
            root.addAll(inputs);

            BinarySearchNode result = BinaryTreeSearcher.findSecondLargestNode(root);
            assertNotNull(result);
            assertEquals(i - 1, result.getValue());
        }
    }
}
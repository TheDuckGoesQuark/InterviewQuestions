#!/bin/sh

PROBLEM_NAME=$1

if [ -z "${PROBLEM_NAME}" ]; then
  echo "ERROR: Missing problem name as first argument"
  exit
fi

main_path="./src/main/java/interview/${PROBLEM_NAME}"
test_path="./src/test/java/interview/${PROBLEM_NAME}"
mkdir "$main_path"
mkdir "$test_path"

main_class="${main_path}/${PROBLEM_NAME}.java"
test_class="${test_path}/${PROBLEM_NAME}Test.java"

cat >> "$test_class" <<EOF
package interview.$PROBLEM_NAME;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class ${PROBLEM_NAME}Test {

    public ${PROBLEM_NAME}Test() {
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        final var inputs = new Object[][]{
        };
        return Arrays.asList(inputs);
    }

    @Test
    public void test() {
    }
}
EOF

cat >> "$main_class" <<EOF
package interview.${PROBLEM_NAME};

/**
 *
 */
public class ${PROBLEM_NAME} {

}
EOF

#!/bin/sh

# name of main folder, class, and test file
PROBLEM_NAME=$1
# subpackage path, eg. ctci.arraysandstrings
SUBPACKAGE=$2

if [ -z "${PROBLEM_NAME}" ]; then
  echo "ERROR: Missing problem name as first argument"
  exit
fi


if [ -z "${SUBPACKAGE}" ]; then
  main_path="./src/main/java/interview/${PROBLEM_NAME}"
  test_path="./src/test/java/interview/${PROBLEM_NAME}"
else
  # shellcheck disable=SC2039
  subpackage_path="${SUBPACKAGE//.//}"
  main_path="./src/main/java/interview/${subpackage_path}/${PROBLEM_NAME}"
  test_path="./src/test/java/interview/${subpackage_path}/${PROBLEM_NAME}"
fi

mkdir -p "$main_path"
mkdir -p "$test_path"

main_class="${main_path}/${PROBLEM_NAME}.java"
test_class="${test_path}/${PROBLEM_NAME}Test.java"

if [ -z "${SUBPACKAGE}" ]; then
  package="interview.${PROBLEM_NAME}"
else
  package="interview.${SUBPACKAGE}.${PROBLEM_NAME}"
fi

cat >> "$test_class" <<EOF
package $package;

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
package $package;

/**
 *
 */
public class ${PROBLEM_NAME} {

}
EOF

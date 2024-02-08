package org.tfoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class SolutionTest {

    @Test
    void testSolutionExample1() {
        Solution s = new Solution();
        boolean result = s.isValid("()");

        assertTrue(result);
    }

    @Test
    void testSolutionExample2() {
        Solution s = new Solution();
        boolean result = s.isValid("()[]{}");

        assertTrue(result);
    }

    @Test
    void testSolutionExample3() {
        Solution s = new Solution();
        boolean result = s.isValid("(]");

        assertFalse(result);
    }

    @Test
    void testSolutionNonEvenSizeString() {
        Solution s = new Solution();
        boolean result = s.isValid("(])");

        assertFalse(result);
    }

    @Test
    void testSolutionFirstPairCorrectSecondIncorrect() {
        Solution s = new Solution();
        boolean result = s.isValid("(){]");

        assertFalse(result);
    }

}
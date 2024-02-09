package org.tfoc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class SolutionTestV2 {

    @Test
    void testSolutionExample1() {
        boolean result = Solution.isValidV2("()");

        assertTrue(result);
    }

    @Test
    void testSolutionExample2() {
        boolean result = Solution.isValidV2("()[]{}");

        assertTrue(result);
    }

    @Test
    void testSolutionExample3() {
        boolean result = Solution.isValidV2("(]");

        assertFalse(result);
    }

    @Test
    void testSolutionNonEvenSizeString() {
        boolean result = Solution.isValidV2("(])");

        assertFalse(result);
    }

    @Test
    void testSolutionFirstPairCorrectSecondIncorrect() {
        boolean result = Solution.isValidV2("(){]");

        assertFalse(result);
    }

    @Test
    void testSolutionComplexCorrect1() {
        boolean result = Solution.isValidV2("()(())");

        assertTrue(result);
    }

    @Test
    void testSolutionComplexCorrect2() {
        boolean result = Solution.isValidV2("()(([]))");

        assertTrue(result);
    }

    @Test
    void testSolutionComplexIncorrect1() {
        boolean result = Solution.isValidV2("()(([))]");

        assertFalse(result);
    }

    @Test
    void testSolutionComplexIncorrect2() {
        boolean result = Solution.isValidV2("()(([]]])]");

        assertFalse(result);
    }

}
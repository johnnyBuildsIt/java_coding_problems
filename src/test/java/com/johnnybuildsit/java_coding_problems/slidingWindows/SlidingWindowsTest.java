package com.johnnybuildsit.java_coding_problems.slidingWindows;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SlidingWindowsTest {
    @Test
    void maxSumSubArraySizeKBruteForceTest() {
        final int[] input = {2, 1, 5, 1, 3, 2};
        int windowSize = 3;
        final SlidingWindows slidingWindows = new SlidingWindows();

        final int result = slidingWindows.maxSumSubArraySizeKBruteForce(windowSize, input);

        assertThat(result).isEqualTo(9);
    }

    @Test
    void maxSumSubArraySizeKOptimizedTest() {
        final int[] input = {2, 1, 5, 1, 3, 2};
        int windowSize = 3;
        final SlidingWindows slidingWindows = new SlidingWindows();

        final int result = slidingWindows.maxSumSubArraySizeKOptimized(windowSize, input);

        assertThat(result).isEqualTo(9);
    }

    @Test
    void smallestSubArrayWithGivenSumTest() {
        final int[] input = {2, 1, 5, 2, 3, 2};
        int targetSum = 7;
        final SlidingWindows slidingWindows = new SlidingWindows();

        final int result = slidingWindows.smallestSubArrayWithGivenSum(targetSum, input);
    }
}
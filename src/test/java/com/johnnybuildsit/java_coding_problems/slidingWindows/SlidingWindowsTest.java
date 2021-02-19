package com.johnnybuildsit.java_coding_problems.slidingWindows;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SlidingWindowsTest {
    @Test
    void maxSumSubArraySizeKTest() {
        final int[] input = {2, 1, 5, 1, 3, 2};
        int windowSize = 3;
        final SlidingWindows slidingWindows = new SlidingWindows();

        final int result = slidingWindows.maxSumSubArraySizeKBruteForce(windowSize, input);

        assertThat(result).isEqualTo(9);
    }
}
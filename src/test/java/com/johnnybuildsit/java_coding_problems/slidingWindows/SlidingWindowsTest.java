package com.johnnybuildsit.java_coding_problems.slidingWindows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SlidingWindowsTest {

    @Nested
    class MaxSumSubArray{
        @Test
        void maxSumSubArraySizeKBruteForceTest() {
            final int[] input = {2, 1, 5, 1, 3, 2};
            final int windowSize = 3;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.maxSumSubArraySizeKBruteForce(windowSize, input);

            assertThat(result).isEqualTo(9);
        }

        @Test
        void maxSumSubArraySizeKOptimizedTest() {
            final int[] input = {2, 1, 5, 1, 3, 2};
            final int windowSize = 3;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.maxSumSubArraySizeKOptimized(windowSize, input);

            assertThat(result).isEqualTo(9);
        }
    }

    @Nested
    class SmallestSubArray{
        @Test
        void smallestSubArrayWithGivenSumBruteForceTest() {
            final int[] input = {2, 1, 5, 2, 3, 2};
            final int targetSum = 7;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.smallestSubArrayWithGivenSumBruteForce(targetSum, input);

            assertThat(result).isEqualTo(2);
        }

        @Test // added to deal with case of single qualifier at end of array
        void smallestSubArrayWithGivenSumBruteForceTest2() {
            final int[] input = {2, 1, 5, 2, 8};
            final int targetSum = 7;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.smallestSubArrayWithGivenSumBruteForce(targetSum, input);

            assertThat(result).isEqualTo(1);
        }

        @Test
        void smallestSubArrayWithGivenSumOptimizedTest() {
            final int[] input = {2, 1, 5, 2, 3, 2};
            final int targetSum = 7;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.smallestSubArrayWithGivenSumOptimized(targetSum, input);

            assertThat(result).isEqualTo(2);
        }

        @Test // added to deal with case of single qualifier at end of array
        void smallestSubArrayWithGivenSumOptimizedTest2() {
            final int[] input = {2, 1, 5, 2, 8};
            final int targetSum = 7;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.smallestSubArrayWithGivenSumOptimized(targetSum, input);

            assertThat(result).isEqualTo(1);
        }
    }

    @Nested
    class LongestSubstringWithKDistinctCharacters {
        @Test
        void longestSubstringWithKDistinctCharactersTest() {
            final String input = "araaci";
            final int lettersAllowed = 2;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.longestSubstringWithDistinctChars(input, lettersAllowed);

            assertThat(result).isEqualTo(4);
        }

        @Test
        void longestSubstringWithKDistinctCharactersTest2() {
            final String input = "araaci";
            final int lettersAllowed = 1;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.longestSubstringWithDistinctChars(input, lettersAllowed);

            assertThat(result).isEqualTo(2);
        }

        @Test
        void longestSubstringWithKDistinctCharactersTest3() {
            final String input = "cbbebi";
            final int lettersAllowed = 3;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.longestSubstringWithDistinctChars(input, lettersAllowed);

            assertThat(result).isEqualTo(5);
        }
    }
}
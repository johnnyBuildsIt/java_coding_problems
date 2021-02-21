package com.johnnybuildsit.java_coding_problems.slidingWindows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SlidingWindowsTest {

    @Nested
    class MaxSumSubArray {
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
    class SmallestSubArray {
        @Nested
        class BruteForce {
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
        }

        @Nested
        class Optimized{
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
    }

    @Nested
    class LongestSubstringWithKDistinctCharacters {
        @Nested
        class BruteForce {
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

        @Nested
        class Optimized {
            @Test
            void longestSubstringWithKDistinctCharactersTest() {
                final String input = "araaci";
                final int lettersAllowed = 2;
                final SlidingWindows slidingWindows = new SlidingWindows();

                final int result = slidingWindows.longestSubstringWithDistinctCharsOptimized(input, lettersAllowed);

                assertThat(result).isEqualTo(4);
            }

            @Test
            void longestSubstringWithKDistinctCharactersTest2() {
                final String input = "araaci";
                final int lettersAllowed = 1;
                final SlidingWindows slidingWindows = new SlidingWindows();

                final int result = slidingWindows.longestSubstringWithDistinctCharsOptimized(input, lettersAllowed);

                assertThat(result).isEqualTo(2);
            }

            @Test
            void longestSubstringWithKDistinctCharactersTest3() {
                final String input = "cbbebi";
                final int lettersAllowed = 3;
                final SlidingWindows slidingWindows = new SlidingWindows();

                final int result = slidingWindows.longestSubstringWithDistinctCharsOptimized(input, lettersAllowed);

                assertThat(result).isEqualTo(5);
            }
        }

    }
    
    @Nested
    class LongestNoRepeatingSubstring {
        @Test
        void longestNoRepeatSubstringTest() {
            final String input = "aabccbb";
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.longestNoRepeatSubstring(input);

            assertThat(result).isEqualTo(3);
        }

        @Test
        void longestNoRepeatSubstringTest2() {
            final String input = "abccde";
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.longestNoRepeatSubstring(input);

            assertThat(result).isEqualTo(3);
        }

        @Test
        void longestNoRepeatSubstringTest3() {
            final String input = "abbbb";
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.longestNoRepeatSubstring(input);

            assertThat(result).isEqualTo(2);
        }
    }

    @Nested
    class LongestSubstringWithSameLettersAfterReplacement {
        @Test
        void longestSubstringWithSameLettersAfterReplacementTest() {
            final String input = "aabccbb";
            final int replacementsAllowed = 2;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.longestSubstringWithSameLettersAfterReplacement(input, replacementsAllowed);

            assertThat(result).isEqualTo(5);
        }

        @Test
        void longestSubstringWithSameLettersAfterReplacementTest1() {
            final String input = "abbcb";
            final int replacementsAllowed = 1;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.longestSubstringWithSameLettersAfterReplacement(input, replacementsAllowed);

            assertThat(result).isEqualTo(4);
        }

        @Test
        void longestSubstringWithSameLettersAfterReplacementTest2() {
            final String input = "abccde";
            final int replacementsAllowed = 1;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.longestSubstringWithSameLettersAfterReplacement(input, replacementsAllowed);

            assertThat(result).isEqualTo(3);
        }
    }

    @Nested
    class LongestSubarrayWithOnesAfterReplacement {
        @Test
        void longestSubarrayWithOnesAfterReplacementTest() {
            final int[] input = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
            final int replacementsAllowed = 2;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.longestSubarrayWithOnesAfterReplacement(input, replacementsAllowed);

            assertThat(result).isEqualTo(6);
        }

        @Test
        void longestSubarrayWithOnesAfterReplacementTest2() {
            final int[] input = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
            final int replacementsAllowed = 3;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.longestSubarrayWithOnesAfterReplacement(input, replacementsAllowed);

            assertThat(result).isEqualTo(9);
        }
    }
}
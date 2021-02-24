package com.johnnybuildsit.java_coding_problems.slidingWindows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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
            void smallestSubArrayWithGivenSumBruteForceTest1() {
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
            void smallestSubArrayWithGivenSumOptimizedTest1() {
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
            void longestSubstringWithKDistinctCharactersTest1() {
                final String input = "araaci";
                final int lettersAllowed = 1;
                final SlidingWindows slidingWindows = new SlidingWindows();

                final int result = slidingWindows.longestSubstringWithDistinctChars(input, lettersAllowed);

                assertThat(result).isEqualTo(2);
            }

            @Test
            void longestSubstringWithKDistinctCharactersTest2() {
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
            void longestSubstringWithKDistinctCharactersTest1() {
                final String input = "araaci";
                final int lettersAllowed = 1;
                final SlidingWindows slidingWindows = new SlidingWindows();

                final int result = slidingWindows.longestSubstringWithDistinctCharsOptimized(input, lettersAllowed);

                assertThat(result).isEqualTo(2);
            }

            @Test
            void longestSubstringWithKDistinctCharactersTest2() {
                final String input = "cbbebi";
                final int lettersAllowed = 3;
                final SlidingWindows slidingWindows = new SlidingWindows();

                final int result = slidingWindows.longestSubstringWithDistinctCharsOptimized(input, lettersAllowed);

                assertThat(result).isEqualTo(5);
            }

            @Test
            void longestSubstringWithKDistinctCharactersTest3() {
                final String input = "icaraa";
                final int lettersAllowed = 2;
                final SlidingWindows slidingWindows = new SlidingWindows();

                final int result = slidingWindows.longestSubstringWithDistinctCharsOptimized(input, lettersAllowed);

                assertThat(result).isEqualTo(4);
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
        void longestNoRepeatSubstringTest1() {
            final String input = "abccde";
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.longestNoRepeatSubstring(input);

            assertThat(result).isEqualTo(3);
        }

        @Test
        void longestNoRepeatSubstringTest2() {
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
        void longestSubarrayWithOnesAfterReplacementTest1() {
            final int[] input = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
            final int replacementsAllowed = 3;
            final SlidingWindows slidingWindows = new SlidingWindows();

            final int result = slidingWindows.longestSubarrayWithOnesAfterReplacement(input, replacementsAllowed);

            assertThat(result).isEqualTo(9);
        }
    }

    @Nested
    class PermutationInString {
        @Test
        void permutationInStringTest() {
            final String input = "oidbcaf";
            final String pattern = "abc";
            final SlidingWindows slidingWindows = new SlidingWindows();

            final boolean result = slidingWindows.permutationInString(input, pattern);

            assertThat(result).isTrue();
        }

        @Test
        void permutationInStringTest1() {
            final String input = "odicf";
            final String pattern = "dc";
            final SlidingWindows slidingWindows = new SlidingWindows();

            final boolean result = slidingWindows.permutationInString(input, pattern);

            assertThat(result).isFalse();
        }

        @Test
        void permutationInStringTest2() {
            final String input = "bcdxabcdy";
            final String pattern = "bcdyabcdx";
            final SlidingWindows slidingWindows = new SlidingWindows();

            final boolean result = slidingWindows.permutationInString(input, pattern);

            assertThat(result).isTrue();
        }

        @Test
        void permutationInStringTest3() {
            final String input = "aaacb";
            final String pattern = "abc";
            final SlidingWindows slidingWindows = new SlidingWindows();

            final boolean result = slidingWindows.permutationInString(input, pattern);

            assertThat(result).isTrue();
        }

        @Test
        void permutationPatternToMapTest() {
            final String pattern = "aaabbc";
            final SlidingWindows slidingWindows = new SlidingWindows();

            final HashMap<Character, Integer> permutationLetters = slidingWindows.permutationToMap(pattern);

            assertAll(
                    () -> assertThat(permutationLetters.get('a')).isEqualTo(3),
                    () -> assertThat(permutationLetters.get('b')).isEqualTo(2),
                    () -> assertThat(permutationLetters.get('c')).isEqualTo(1)
            );
        }
    }
    
    @Nested
    class StringAnagrams {
        @Test
        void StringAnagramsTest() {
            final String input = "ppqp";
            final String pattern = "pq";
            final SlidingWindows slidingWindows = new SlidingWindows();

            final List<Integer> result = slidingWindows.stringAnagrams(input, pattern);

            assertAll(
                    () -> assertThat(result.get(0)).isEqualTo(1),
                    () -> assertThat(result.get(1)).isEqualTo(2)
            );
        }

        @Test
        void StringAnagramsTest1() {
            final String input = "abbcabc";
            final String pattern = "abc";
            final SlidingWindows slidingWindows = new SlidingWindows();

            final List<Integer> result = slidingWindows.stringAnagrams(input, pattern);

            assertAll(
                    () -> assertThat(result.get(0)).isEqualTo(2),
                    () -> assertThat(result.get(1)).isEqualTo(3),
                    () -> assertThat(result.get(2)).isEqualTo(4)
            );
        }
    }
}
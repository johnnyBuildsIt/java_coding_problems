package com.johnnybuildsit.java_coding_problems.stringsNumbersMath;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CountingDuplicateCharactersTest {

    @Nested
    class Imperative {
        @Test
        void countThreeA() {
            final CountingDuplicateCharacters dupCounter = new CountingDuplicateCharacters();
            final String inString = "aaa";

            final Map<Character, Integer> dupCounts = dupCounter.countDuplicatesImperative(inString);

            assertThat(dupCounts.get('a')).isEqualTo(3);
        }

        @Test
        void countThreeAsAndThreeBs() {
            final CountingDuplicateCharacters dupCounter = new CountingDuplicateCharacters();
            final String inString = "ababab";

            final Map<Character, Integer> dupCounts = dupCounter.countDuplicatesImperative(inString);

            assertAll(
                    () -> assertThat(dupCounts.get('a')).isEqualTo(3),
                    () -> assertThat(dupCounts.get('b')).isEqualTo(3)
            );
        }
    }

    @Nested
    class Streams {
        @Test
        void countThreeA() {
            final CountingDuplicateCharacters dupCounter = new CountingDuplicateCharacters();
            final String inString = "aaa";

            final Map<Character, Long> dupCounts = dupCounter.countDuplicatesStream(inString);

            assertThat(dupCounts.get('a')).isEqualTo(3);
        }
    }
}
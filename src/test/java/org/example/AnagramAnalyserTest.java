package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.AnagramAnalyser.isValidUserInput;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This class only contains tests for validation of user inputs. As the actual feature involves a lot of console prints,
 * this would be an overhead and unwanted effort to test.
 */
class AnagramAnalyserTest {

    @Test
    @DisplayName("Validation fails for invalid input with numbers.")
    void validationFailsForInputWithNumbers() {
        //given
        String userInput = "cat,1,dog";

        //When
        boolean result = isValidUserInput(userInput);

        //then
        assertFalse(result);

    }

    @Test
    @DisplayName("Validation fails for invalid input with special character.")
    void validationFailsForInputWithSpecialCharacters() {
        //given
        String userInput = "cat*,act,dog";

        //When
        boolean result = isValidUserInput(userInput);

        //then
        assertFalse(result);

    }

    @Test
    @DisplayName("Validation fails for invalid input with just one word")
    void validationFailsForInputWithJustOneWord() {
        //given
        String userInput = "cat";

        //When
        boolean result = isValidUserInput(userInput);

        //then
        assertFalse(result);

    }

    @Test
    @DisplayName("Validation fails for invalid input with space in words")
    void validationFailsForInputWithSpaceInWords() {
        //given
        String userInput = "cat";

        //When
        boolean result = isValidUserInput(userInput);

        //then
        assertFalse(result);

    }

}
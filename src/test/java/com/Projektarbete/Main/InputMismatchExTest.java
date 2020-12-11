package com.Projektarbete.Main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class InputMismatchExTest {

    @Test
    @DisplayName("Test enterInteger() / InputMismatchExpectation")
    void verifyInputMismatchExceptionIsThrown() {

        InputMismatchEx keyEnter = new InputMismatchEx();
        String input = "Not a number";

        // Hämta "Not a number" som användarens inmatning.
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InputMismatchException.class, () -> {
            keyEnter.enterInteger();
        });
    }

    @AfterEach
    void afterEach() {
        System.out.println("-- This test has been executed. --");
    }

}
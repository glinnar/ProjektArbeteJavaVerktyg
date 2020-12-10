package com.Projektarbete.Main;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class InputMismatchExTest {

    @Test
    void verifyInputMismatchExceptionIsThrown() {

        InputMismatchEx keyEnter = new InputMismatchEx();
        String input = "Not a number";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(InputMismatchException.class, () -> {
            keyEnter.enterInteger();
        });

    }
}
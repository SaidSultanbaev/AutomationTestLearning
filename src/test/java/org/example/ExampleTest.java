package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExampleTest {

    @Test
    public void testExxample() {
        int expected = 10;
        int actual = 5 + 5;
        assertEquals(expected, actual, "Ошибка! значения не совпадают");

    }
}

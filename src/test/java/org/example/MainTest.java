package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void testMessage() {
        assertEquals("Hello Gradle!", "Hello Gradle!"); // Простой тест
    }

    @Test
    void testSum() {
        assertEquals(4, 2 + 2);
    }
}
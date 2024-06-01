package org.example.multipleinheritance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GminaWiejskaTest {

    private GminaWiejska gw;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        gw = new GminaWiejska("Bedoń");
        gw.utwórzSołectwo("Bedoń Przykościelny");

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void printsJednostkiPomocnicze() {
        gw.wyświetlJednostkiPomocnicze();
        assertEquals("GminaWiejska{sołectwa=[Bedoń Przykościelny]}",
                outputStreamCaptor.toString().trim());
    }

}
package org.example.multipleinheritance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GminaMiejskoWiejskaTest {

    private GminaMiejskoWiejska gmw;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        gmw = new GminaMiejskoWiejska("Wieś Duża");
        gmw.utwórzDzielnicę("Piotrków");
        gmw.utwórzOsiedle("Chojny");
        gmw.utwórzSołectwo("Pruszków");

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void printsJednostkiPomocnicze() {
        gmw.wyświetlJednostkiPomocnicze();
        assertEquals("GminaMiejskoWiejska{dzielnice=[Piotrków], osiedla=[Chojny], sołectwa=[Pruszków]}",
                outputStreamCaptor.toString().trim());
    }
}
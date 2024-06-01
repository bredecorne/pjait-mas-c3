package org.example.multipleinheritance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GminaMiejskaTest {
    
    private GminaMiejska gm;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        gm = new GminaMiejska("Poznań");
        gm.utwórzDzielnicę("Suwak");
        gm.utwórzOsiedle("Piorun");
        
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void printsJednostkiPomocnicze() {
        gm.wyświetlJednostkiPomocnicze();
        assertEquals("GminaMiejska{dzielnice=[Suwak], osiedla=[Piorun]}",
                outputStreamCaptor.toString().trim());
    }
}
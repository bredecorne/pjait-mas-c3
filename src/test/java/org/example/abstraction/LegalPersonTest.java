package org.example.abstraction;

import org.junit.jupiter.api.*;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class LegalPersonTest {

    private LegalPerson legalPerson;

    @BeforeEach
    void setUp() {
        legalPerson = new LegalPerson(
                "Koledzy i przyjaciele sp. j.", 
                BigDecimal.valueOf(100000), 
                BigDecimal.valueOf(50000), 
                BigDecimal.valueOf(10000), 
                false
        );
    }

    @Test
    void calculatesTax() {
        BigDecimal expectedIncome = BigDecimal.valueOf(32400);
        assertEquals(expectedIncome.compareTo(legalPerson.getIncome()), 0);
    }

    @Test
    void calculatesTaxWithReduction() {
        legalPerson.setReducedTax(true);
        BigDecimal expectedIncome = BigDecimal.valueOf(36400);
        assertEquals(expectedIncome.compareTo(legalPerson.getIncome()), 0);
    }
}
package org.example.abstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class NaturalPersonTest {

    private NaturalPerson naturalPerson;

    @BeforeEach
    void setUp() {
        naturalPerson = new NaturalPerson(
                "Adam Kompot",
                BigDecimal.valueOf(400000),
                BigDecimal.valueOf(50000),
                false
        );
    }

    @Test
    void calculatesTax() {
        BigDecimal expectedIncome = BigDecimal.valueOf(262000);
        assertEquals(expectedIncome.compareTo(naturalPerson.getIncome()), 0);
    }

    @Test
    void calculatesTaxWithUniformRate() {
        naturalPerson.setUniformTax(true);
        BigDecimal expectedIncome = BigDecimal.valueOf(283500);
        assertEquals(expectedIncome.compareTo(naturalPerson.getIncome()), 0);
    }

}
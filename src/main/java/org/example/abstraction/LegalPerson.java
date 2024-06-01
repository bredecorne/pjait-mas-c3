package org.example.abstraction;

import java.math.BigDecimal;

public class LegalPerson extends Taxpayer {
    private final static double CORPORATE_INCOME_TAX = 4;

    public LegalPerson(String name, BigDecimal revenue, BigDecimal expenses) {
        super(name, revenue, expenses);
    }

    @Override
    BigDecimal getIncome() {
        return null;
    }
}

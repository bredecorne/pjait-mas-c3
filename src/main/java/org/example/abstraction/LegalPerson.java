package org.example.abstraction;

import java.math.BigDecimal;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class LegalPerson extends Taxpayer {
    private final static NavigableMap<BigDecimal, BigDecimal> CORPORATE_INCOME_TAX = new TreeMap<>(Map.of(
            BigDecimal.ZERO, new BigDecimal("0.12"),
            new BigDecimal("120000"), new BigDecimal("0.32")
    ));
    private BigDecimal vatDeduction;

    public LegalPerson(String name, BigDecimal revenue, BigDecimal expenses, BigDecimal vatDeduction) {
        super(name, revenue, expenses);
        this.vatDeduction = vatDeduction;
    }

    @Override
    public BigDecimal getIncome() {
        var untaxedIncome = getRevenue().subtract(getExpenses()).subtract(vatDeduction);
        
        return super.calculateProgressiveTax(untaxedIncome, CORPORATE_INCOME_TAX);
    }

    public BigDecimal getVatDeduction() {
        return vatDeduction;
    }

    public void setVatDeduction(BigDecimal vatDeduction) {
        this.vatDeduction = vatDeduction;
    }
}

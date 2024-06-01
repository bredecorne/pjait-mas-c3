package org.example.abstraction;

import java.math.BigDecimal;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class LegalPerson extends Taxpayer {
    private final static NavigableMap<BigDecimal, BigDecimal> CORPORATE_TAX = new TreeMap<>(Map.of(
            BigDecimal.ZERO, new BigDecimal("0.19")
    ));
    private final static BigDecimal REDUCED_TAX = new BigDecimal("0.09");
    private BigDecimal vatDeduction;
    private boolean reducedTax;

    public LegalPerson(String name, BigDecimal revenue, BigDecimal expenses, BigDecimal vatDeduction, boolean reducedTax) {
        super(name, revenue, expenses);
        this.vatDeduction = vatDeduction;
        this.reducedTax = reducedTax;
    }

    @Override
    public BigDecimal getIncome() {
        var untaxedIncome = getRevenue().subtract(getExpenses()).subtract(vatDeduction);
        
        if (reducedTax) {
            return untaxedIncome.multiply(BigDecimal.ONE.subtract(REDUCED_TAX));
        }
        
        return super.calculateProgressiveTax(untaxedIncome, CORPORATE_TAX);
    }

    public BigDecimal getVatDeduction() {
        return vatDeduction;
    }

    public void setVatDeduction(BigDecimal vatDeduction) {
        this.vatDeduction = vatDeduction;
    }

    public boolean isReducedTax() {
        return reducedTax;
    }

    public void setReducedTax(boolean reducedTax) {
        this.reducedTax = reducedTax;
    }
}

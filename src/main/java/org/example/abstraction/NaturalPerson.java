package org.example.abstraction;

import java.math.BigDecimal;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NaturalPerson extends Taxpayer {
    private final static NavigableMap<BigDecimal, BigDecimal> PERSONAL_TAX = new TreeMap<>(Map.of(
            BigDecimal.ZERO, new BigDecimal("0.12"),
            new BigDecimal("120000"), new BigDecimal("0.32")
    ));
    private final static BigDecimal UNIFORM_TAX = new BigDecimal("0.19");
    private boolean uniformTax;

    public NaturalPerson(String name, BigDecimal revenue, BigDecimal expenses, boolean uniformTax) {
        super(name, revenue, expenses);
        this.uniformTax = uniformTax;
    }

    @Override
    public BigDecimal getIncome() {
        var untaxedIncome = getRevenue().subtract(getExpenses());
        
        if (uniformTax) {
            return untaxedIncome.multiply(BigDecimal.ONE.subtract(UNIFORM_TAX));
        }
        
        return super.calculateProgressiveTax(untaxedIncome, PERSONAL_TAX);
    }

    public boolean isUniformTax() {
        return uniformTax;
    }

    public void setUniformTax(boolean uniformTax) {
        this.uniformTax = uniformTax;
    }
}

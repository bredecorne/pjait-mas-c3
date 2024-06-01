package org.example.abstraction;

import java.math.BigDecimal;
import java.util.Map;
import java.util.NavigableMap;

public abstract class Taxpayer {
    private String name;
    private BigDecimal revenue;
    private BigDecimal expenses;

    public Taxpayer(String name, BigDecimal revenue, BigDecimal expenses) {
        this.name = name;
        this.revenue = revenue;
        this.expenses = expenses;
    }
    
    abstract BigDecimal getIncome();
    
    public BigDecimal calculateProgressiveTax(BigDecimal untaxedIncome, NavigableMap<BigDecimal, BigDecimal> scale) {
        var remainingIncome = untaxedIncome;
        var incomeAfterTax = BigDecimal.ZERO;
        
        for (Map.Entry<BigDecimal, BigDecimal> entry : scale.descendingMap().entrySet()) {
            var threshold = entry.getKey();
            var rate = BigDecimal.ONE.subtract(entry.getValue());

            if (remainingIncome.compareTo(threshold) >= 0) {
                incomeAfterTax = incomeAfterTax.add(
                        remainingIncome.subtract(threshold).multiply(rate)
                );
                remainingIncome = threshold;
            } else {
                incomeAfterTax = incomeAfterTax.add(
                        remainingIncome.subtract(threshold).multiply(rate)
                );
                break;
            }
        }

        return incomeAfterTax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getExpenses() {
        return expenses;
    }

    public void setExpenses(BigDecimal expenses) {
        this.expenses = expenses;
    }
}

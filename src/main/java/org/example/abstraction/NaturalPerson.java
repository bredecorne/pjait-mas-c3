package org.example.abstraction;

import java.math.BigDecimal;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NaturalPerson extends Taxpayer {
    private final static NavigableMap<BigDecimal, BigDecimal> PERSONAL_INCOME_TAX = new TreeMap<>(Map.of(
            new BigDecimal("0"), new BigDecimal("0.12"),
            new BigDecimal("120000"), new BigDecimal("0.32")
    ));
    private final static BigDecimal UNIFORM_PERSONAL_INCOME_TAX = new BigDecimal("0.19");
    private boolean uniformTax;

    public NaturalPerson(String name, BigDecimal revenue, BigDecimal expenses, boolean uniformTax) {
        super(name, revenue, expenses);
        this.uniformTax = uniformTax;
    }

    public BigDecimal getIncome() {
        var remainingIncome = getRevenue().subtract(getExpenses());
        var incomeAfterTax = BigDecimal.ZERO;
        
        if (uniformTax) {
            incomeAfterTax = remainingIncome.multiply(multiplier(UNIFORM_PERSONAL_INCOME_TAX));
            return incomeAfterTax;
        }
        
        for (Map.Entry<BigDecimal, BigDecimal> entry : PERSONAL_INCOME_TAX.entrySet()) {
            var threshold = entry.getKey();
            var rate = entry.getValue();
            
            if (remainingIncome.compareTo(threshold) > 0) {
                // Sprawdza, czy pozostały dochód przekracza dany próg podatkowy. Jeżeli przekracza, to zwraca 
                // maksymalną kwotę, jaka może być obciążona w danym progu.
                var taxableAmount = remainingIncome.min(threshold.subtract(incomeAfterTax));
                remainingIncome = remainingIncome.subtract(taxableAmount);
            }
        }
        
        return incomeAfterTax;
    }
    
    private BigDecimal multiplier(BigDecimal bigDecimal) {
        return BigDecimal.ONE.subtract(bigDecimal);
    }

    public boolean isUniformTax() {
        return uniformTax;
    }

    public void setUniformTax(boolean uniformTax) {
        this.uniformTax = uniformTax;
    }
}

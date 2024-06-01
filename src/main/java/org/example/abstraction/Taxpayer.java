package org.example.abstraction;

import java.math.BigDecimal;

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

    public String getName() {
        return name;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public BigDecimal getExpenses() {
        return expenses;
    }
}

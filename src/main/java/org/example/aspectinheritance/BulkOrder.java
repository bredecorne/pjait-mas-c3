package org.example.aspectinheritance;

import java.time.LocalDate;

public class BulkOrder extends Order {
    private double bulkDiscountRate;

    public BulkOrder(DeliveryType delivery, LocalDate date, String status, double bulkDiscountRate) {
        super(delivery, date, status);
        this.bulkDiscountRate = bulkDiscountRate;
    }

    public double getBulkDiscountRate() {
        return bulkDiscountRate;
    }

    public void setBulkDiscountRate(double bulkDiscountRate) {
        this.bulkDiscountRate = bulkDiscountRate;
    }
}

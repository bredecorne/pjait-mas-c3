package org.example.aspectinheritance;

import java.time.LocalDate;

public class IndividualOrder extends Order {
    private double loyaltyPointsUsed;

    public IndividualOrder(DeliveryType delivery, LocalDate date, String status, double loyaltyPointsUsed) {
        super(delivery, date, status);
        this.loyaltyPointsUsed = loyaltyPointsUsed;
    }

    public double getLoyaltyPointsUsed() {
        return loyaltyPointsUsed;
    }

    public void setLoyaltyPointsUsed(double loyaltyPointsUsed) {
        this.loyaltyPointsUsed = loyaltyPointsUsed;
    }
}

package org.example.aspectinheritance;

import java.time.LocalDate;

public class SubscriptionOrder extends Order {
    private int renewalFrequency;

    public SubscriptionOrder(DeliveryType delivery, LocalDate date, String status, int renewalFrequency) {
        super(delivery, date, status);
        this.renewalFrequency = renewalFrequency;
    }

    public int getRenewalFrequency() {
        return renewalFrequency;
    }

    public void setRenewalFrequency(int renewalFrequency) {
        this.renewalFrequency = renewalFrequency;
    }
}

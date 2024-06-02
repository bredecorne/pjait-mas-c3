package org.example.aspectinheritance;

import java.time.LocalDate;

public abstract class Order {
    private DeliveryType delivery;
    private LocalDate date;
    private String status;
    private String trackingNumber;
    private String pickupLocation;

    public Order(DeliveryType delivery, LocalDate date, String status) {
        this.delivery = delivery;
        this.date = date;
        this.status = status;
    }

    public String getTrackingNumber() throws Exception {
        if (!delivery.equals(DeliveryType.ONLINE)) {
            throw new Exception();
        }
        
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) throws Exception {
        if (!delivery.equals(DeliveryType.ONLINE)) {
            throw new Exception();
        }
        
        this.trackingNumber = trackingNumber;
    }

    public String getPickupLocation() throws Exception {
        if (!delivery.equals(DeliveryType.IN_STORE_PICKUP)) {
            throw new Exception();
        }
        
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) throws Exception {
        if (!delivery.equals(DeliveryType.IN_STORE_PICKUP)) {
            throw new Exception();
        }
        
        this.pickupLocation = pickupLocation;
    }

    public DeliveryType getDelivery() {
        return delivery;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}

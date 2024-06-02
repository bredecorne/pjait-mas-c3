package org.example.aspectinheritance;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private Order order;

    @Test
    void setsAndRetrievesAttributesCorrectlyForIndividualOnlineOrder() {
        order = new IndividualOrder(
                DeliveryType.ONLINE,
                LocalDate.of(2024, 6, 1),
                "shipped",
                150.0
        );
        try {
            order.setTrackingNumber("TN12345");
        } catch (Exception e) {
            fail("Exception should not be thrown for online order setting tracking number");
        }

        assertAll(
                () -> assertEquals(DeliveryType.ONLINE, order.getDelivery()),
                () -> assertEquals(LocalDate.of(2024, 6, 1), order.getDate()),
                () -> assertEquals("shipped", order.getStatus()),
                () -> assertEquals(150.0, ((IndividualOrder) order).getLoyaltyPointsUsed()),
                () -> assertEquals("TN12345", order.getTrackingNumber())
        );
    }

    @Test
    void setsAndRetrievesAttributesCorrectlyForBulkStorePickupOrder() {
        order = new BulkOrder(
                DeliveryType.IN_STORE_PICKUP,
                LocalDate.of(2024, 5, 28),
                "ready for pickup",
                20.0
        );
        try {
            order.setPickupLocation("Store #123");
        } catch (Exception e) {
            fail("Exception should not be thrown for store pickup setting pickup location");
        }

        assertAll(
                () -> assertEquals(DeliveryType.IN_STORE_PICKUP, order.getDelivery()),
                () -> assertEquals(LocalDate.of(2024, 5, 28), order.getDate()),
                () -> assertEquals("ready for pickup", order.getStatus()),
                () -> assertEquals(20.0, ((BulkOrder) order).getBulkDiscountRate()),
                () -> assertEquals("Store #123", order.getPickupLocation())
        );
    }

    @Test
    void setsAndRetrievesAttributesCorrectlyForSubscriptionOrder() {
        order = new SubscriptionOrder(
                DeliveryType.ONLINE,
                LocalDate.of(2024, 5, 15),
                "active",
                12
        );

        assertAll(
                () -> assertEquals(DeliveryType.ONLINE, order.getDelivery()),
                () -> assertEquals(LocalDate.of(2024, 5, 15), order.getDate()),
                () -> assertEquals("active", order.getStatus()),
                () -> assertEquals(12, ((SubscriptionOrder) order).getRenewalFrequency())
        );
    }

    @Test
    void throwsExceptionForInvalidAttributeAccess() {
        order = new IndividualOrder(
                DeliveryType.ONLINE,
                LocalDate.of(2024, 6, 1),
                "shipped",
                150.0
        );

        assertThrows(Exception.class, () -> order.setPickupLocation("Invalid Location"));
    }
}
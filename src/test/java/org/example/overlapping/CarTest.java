package org.example.overlapping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    
    private Car car;

    @Test
    void setsAndRetrievesAttributesCorrectlyForHydrogenCar() {
        car = Car.createCar("Toyota Corolla", CarType.HYDROGEN);
        try {
            car.setTankCapacity(5.6);
            car.setCellEfficiency(60.0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        assertAll(
                () -> assertEquals("Toyota Corolla", car.getName()),
                () -> assertEquals(CarType.HYDROGEN, car.getType().getFirst()),
                () -> assertEquals(5.6, car.getTankCapacity()),
                () -> assertEquals(60.0, car.getCellEfficiency())
        );
    }

    @Test
    void setsAndRetrievesAttributesCorrectlyForHydrogenAndElectricCar() {
        car = Car.createCar("Toyota Corolla", CarType.HYDROGEN, CarType.ELECTRIC);
        try {
            car.setTankCapacity(5.6);
            car.setCellEfficiency(60.0);
            car.setBatteryCapacity(60000.0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertAll(
                () -> assertEquals("Toyota Corolla", car.getName()),
                () -> assertEquals(CarType.HYDROGEN, car.getType().getFirst()),
                () -> assertEquals(5.6, car.getTankCapacity()),
                () -> assertEquals(60.0, car.getCellEfficiency()),
                () -> assertEquals(60000.0, car.getBatteryCapacity())
        );
    }

    @Test
    void throwsExceptionForInvalidAttributeAccess() {
        car = Car.createCar("Tesla Model 3", CarType.ELECTRIC);

        assertThrows(Exception.class, () -> car.setTankCapacity(40));
    }
}
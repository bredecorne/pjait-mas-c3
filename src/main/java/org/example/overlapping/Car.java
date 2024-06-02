package org.example.overlapping;

import java.util.*;

public class Car {
    private final EnumSet<CarType> type = EnumSet.noneOf(CarType.class);
    private String name;
    private double tankCapacity;
    private double cellEfficiency;
    private double batteryCapacity;

    private Car(String name) {
        this.name = name;
    }
    
    public static Car createCar(String name, CarType ... types) {
        if (Arrays.stream(types).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Car type cannot be null.");
        }
        
        var c = new Car(name);
        c.type.addAll(Arrays.asList(types));
        
        return c;
    }

    public double getTankCapacity() throws Exception {
        if (!(type.contains(CarType.FUEL) || type.contains(CarType.HYDROGEN))) {
            throw new Exception();
        }
        
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) throws Exception {
        if (!(type.contains(CarType.FUEL) || type.contains(CarType.HYDROGEN))) {
            throw new Exception();
        }
        
        this.tankCapacity = tankCapacity;
    }

    public double getCellEfficiency() throws Exception {
        if (!type.contains(CarType.HYDROGEN)) {
            throw new Exception();
        }
        
        return cellEfficiency;
    }

    public void setCellEfficiency(double cellEfficiency) throws Exception {
        if (!type.contains(CarType.HYDROGEN)) {
            throw new Exception();
        }
        
        this.cellEfficiency = cellEfficiency;
    }

    public double getBatteryCapacity() throws Exception {
        if (!type.contains(CarType.ELECTRIC)) {
            throw new Exception();
        }
        
        return batteryCapacity;
    }
    
    public void setBatteryCapacity(double batteryCapacity) throws Exception {
        if (!type.contains(CarType.ELECTRIC)) {
            throw new Exception();
        }
        
        this.batteryCapacity = batteryCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CarType> getType() {
        return new LinkedList<>(type);
    }
}

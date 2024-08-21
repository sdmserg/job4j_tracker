package ru.job4j.polymorphism;

public class Bus implements Transport {
    private int currentPassengers;

    @Override
    public void move() {
        System.out.println("The transport is moving.");
    }

    @Override
    public void passengers(int count) {
        currentPassengers = count;
    }

    @Override
    public int refuel(int fuel) {
        int priceFuel = 60;
        return priceFuel * fuel;
    }
}

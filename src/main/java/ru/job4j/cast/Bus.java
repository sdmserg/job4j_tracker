package ru.job4j.cast;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("The bus is driving along the road.");
    }

    @Override
    public void stop() {
        System.out.println("The bus is stopped.");
    }
}

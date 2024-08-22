package ru.job4j.cast;

public class Airplane implements Vehicle {

    @Override
    public void move() {
        System.out.println("The airplane is flying.");
    }

    @Override
    public void stop() {
        System.out.println("The airplane is landed.");
    }
}

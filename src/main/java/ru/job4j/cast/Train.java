package ru.job4j.cast;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println("The train is moving along the rails.");
    }

    @Override
    public void stop() {
        System.out.println("The train is stopped.");
    }
}

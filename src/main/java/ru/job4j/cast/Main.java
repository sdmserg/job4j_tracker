package ru.job4j.cast;

public class Main {
    public static void main(String[] args) {
        Vehicle boeing = new Airplane();
        Vehicle airbus = new Airplane();
        Vehicle sapsan = new Train();
        Vehicle allegro = new Train();
        Vehicle mercedes = new Bus();
        Vehicle gazel = new Bus();
        Vehicle[] vehicles = new Vehicle[] {boeing, gazel, sapsan, airbus, allegro, mercedes};
        for (Vehicle object : vehicles) {
            object.move();
            object.stop();
        }
    }
}

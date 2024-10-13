package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String lastCustomer = null;
        for (int index = 0; index < count; index++) {
            lastCustomer = queue.poll().name();
        }
        return lastCustomer;
    }

    public String getFirstUpsetCustomer() {
        for (int index = 0; index < count; index++) {
            queue.poll().name();
        }
        return queue.poll().name();
    }
}

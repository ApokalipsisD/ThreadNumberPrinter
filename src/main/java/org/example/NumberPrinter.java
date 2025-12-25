package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberPrinter {
    private static final Logger log = LoggerFactory.getLogger(NumberPrinter.class);

    private int current = 0;
    private final int max;

    public NumberPrinter(int max) {
        this.max = max;
    }

    public synchronized void printEven() {
        while (current <= max) {

            while (current % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            if (current > max) {
                return;
            }

            log.info("{}: even = {}", Thread.currentThread().getName(), current);
            current++;

            notifyAll();
        }
    }

    public synchronized void printOdd() {
        while (current <= max) {

            while (current % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            if (current > max) {
                return;
            }

            log.info("{}: odd = {}", Thread.currentThread().getName(), current);
            current++;

            notifyAll();
        }
    }
}

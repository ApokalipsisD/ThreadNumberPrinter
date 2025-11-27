package org.example;

public class NumberPrinter {
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

            System.out.println(Thread.currentThread().getName() + ": even = " + current);
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

            System.out.println(Thread.currentThread().getName() + ": odd = " + current);
            current++;

            notifyAll();
        }
    }
}

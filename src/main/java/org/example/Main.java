package org.example;


public class Main {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter(20);

        Thread evenThread = new Thread(printer::printEven);
        Thread oddThread = new Thread(printer::printOdd);

        evenThread.start();
        oddThread.start();
    }
}
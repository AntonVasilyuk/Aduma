package ru.job4j;

/**
 * Created by ANTON on 11.08.2017.
 */
public class Work implements Runnable{

    private int index;

    public Work(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.printf("Start work thread number %d%n", this.index);
    }
}

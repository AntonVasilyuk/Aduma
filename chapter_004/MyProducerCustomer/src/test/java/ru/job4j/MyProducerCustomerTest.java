package ru.job4j;

import org.junit.Test;

/**
 * Created by ANTON on 07.08.2017.
 */
public class MyProducerCustomerTest {

    /**.
     * Method for starting my model ProducerConsumer
     * @throws InterruptedException is may be exception
     */
    @Test
    public void whenNeedCheckingToTheArray() throws InterruptedException {
        String[] names = {"Andrey", "Egor", "Bingo", "Durango"};
        MyProducerCustomer link = new MyProducerCustomer(names);
        Thread producer = link.producer();
        Thread consumer = link.consumer();
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
package Thread.ProducerAndConsumer;

import java.util.ArrayList;
import java.util.List;

public class Buffer implements ProducePublish, ConsumePublish {
    private List<Observer> producerList;
    private List<Observer> consumerList;


    private volatile int number;
    private static int MAX;
    private static int MIN;

    private Buffer() {
        number = 0;
        MAX = 10;
        MIN = 0;

        producerList = new ArrayList<>();
        consumerList = new ArrayList<>();
    }

    private static class BufferHolder {
        private static Buffer instance = new Buffer();
    }

    @Override
    public void addProducer(Observer o) {
        producerList.add(o);
    }

    @Override
    public void removeProducer(Observer o) {

    }

    @Override
    public void addConsumer(Observer o) {
        consumerList.add(o);
    }

    @Override
    public void removeConsumer(Observer o) {

    }

    public static Buffer getInstance() {
        return BufferHolder.instance;
    }

    public boolean produce(int producerId) throws InterruptedException {
        synchronized (this) {
            if (number >= MAX) {
                return false;
            }

            number++;
            notifyProducerPrint(producerId);
            printNumber();
            notify();

            return true;
        }
    }

    public boolean consume(int consumerId) throws InterruptedException {
        synchronized (this) {
            if (number <= MIN) {
                wait();
                return false;
            }

            number--;
            notifyConsumerPrint(consumerId);
            printNumber();
            notify();

            return true;
        }
    }

    private void notifyConsumerPrint(int consumerId) {
        for (int i = 0; i < consumerList.size(); i++) {
            consumerList.get(i).update(this, consumerId);
        }
    }

    private void notifyProducerPrint(int producerId) {
        for (int i = 0; i < producerList.size(); i++) {
            producerList.get(i).update(this, producerId);
        }
    }

    private void printNumber() {
        System.out.println("Current number is " + number);
    }

}

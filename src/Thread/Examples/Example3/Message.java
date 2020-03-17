package Thread.Examples.Example3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Message {
    final private Lock lock = new ReentrantLock();
    final private Condition produceMsg = lock.newCondition();
    final private Condition consumeMsg = lock.newCondition();

    private String message;
    private boolean messageState;
    private boolean endIt;

    public void viewMessage() {
        lock.lock();
        try {
            while (!messageState) {
                produceMsg.await();
            }

            System.out.println("Here is the latest message : " + message);
            messageState = false;

            consumeMsg.signal();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupt - viewMessage");
        } finally {
            lock.unlock();
        }
    }

    public void publishMessage(String message) {
        lock.lock();
        try {
            while (messageState) {
                consumeMsg.await();
            }

            System.out.println("adding latest message");
            this.message = message;
            messageState = true;

            produceMsg.signal();

        } catch (InterruptedException e) {
            System.out.println("Thread interrupt - publishMessage");
        } finally {
            lock.unlock();
        }
    }

    public boolean isEndIt() {
        return endIt;
    }

    public void setEndIt(boolean endIt) {
        this.endIt = endIt;
    }
}

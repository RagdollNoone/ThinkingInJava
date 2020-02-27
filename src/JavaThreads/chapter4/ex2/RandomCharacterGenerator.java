package JavaThreads.chapter4.ex2;

import JavaThreads.CharacterEventHandler;
import JavaThreads.CharacterListener;
import JavaThreads.CharacterSource;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RandomCharacterGenerator extends Thread implements CharacterSource {
    static char[] chars;
    static String charArray = "abcdefghijklmnopqrstuvwxyz0123456789";
    static {
        chars = charArray.toCharArray();
    }

    Random random;
    CharacterEventHandler handler;

    private boolean done = true;
    private Lock lock = new ReentrantLock();
    private Condition cv = lock.newCondition();

    public RandomCharacterGenerator() {
        random = new Random();
        handler = new CharacterEventHandler();
    }

    public int getPauseTime() {
//        return (int) (Math.max(1000, 5000 * random.nextDouble()));
        return 5000;
    }

    public void addCharacterListener(CharacterListener cl) {
        handler.addCharacterListener(cl);
    }

    public void removeCharacterListener(CharacterListener cl) {
        handler.removeCharacterListener(cl);
    }

    public void nextCharacter() {
        handler.fireNewCharacter(this,
                                (int) chars[random.nextInt(chars.length)]);
    }

    @Override
    public void run() {
        try {
            lock.lock();
            while (true) {
                if (done) {
                    cv.await();
                } else {
                    nextCharacter();
                    cv.await(getPauseTime(), TimeUnit.MILLISECONDS);
                }
            }
        } catch (InterruptedException ie) {
            return;
        } finally {
            lock.unlock();
        }


    }

    public void setDone(boolean b) {
        try {
            lock.lock();
            done = b;

            if (!done) {
                cv.signal();
            }

        } finally {
            lock.unlock();
        }
    }
}

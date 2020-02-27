package JavaThreads.chapter4.ex1;

import JavaThreads.CharacterEventHandler;
import JavaThreads.CharacterListener;
import JavaThreads.CharacterSource;

import java.util.Random;

public class RandomCharacterGenerator extends Thread implements CharacterSource {
    static char[] chars;
    static String charArray = "abcdefghijklmnopqrstuvwxyz0123456789";
    static {
        chars = charArray.toCharArray();
    }

    Random random;
    CharacterEventHandler handler;

    private boolean done = true;

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
    public synchronized void run() {
        while (true) {
            try {
                if (done) {
                    wait();
                } else {
                    nextCharacter();
                    wait(getPauseTime());
                }
            } catch (InterruptedException ie) {
                return;
            }
        }
    }

    public synchronized void setDone(boolean b) {
        done = b;

        if (!done) {
            notify();
        }
    }
}

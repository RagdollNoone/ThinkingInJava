package JavaThreads.chapter3.ex;

import java.util.*;
import JavaThreads.CharacterEventHandler;
import JavaThreads.CharacterListener;
import JavaThreads.CharacterSource;

public class RandomCharacterGenerator extends Thread implements CharacterSource {
    static char[] chars;
    static String charArray = "abcdefghijklmnopqrstuvwxyz0123456789";
    static {
        chars = charArray.toCharArray();
    }

    Random random;
    CharacterEventHandler handler;

    private volatile boolean done = false;

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

    public void run() {
        while (!done) {
            nextCharacter();
            try {
                Thread.sleep(getPauseTime());
            } catch (InterruptedException ie) {
                return;
            }
        }
    }

    public void setDone() {
        done = true;
    }
}

package JavaThreads.chapter2.ex1;

import JavaThreads.CharacterEventHandler;
import JavaThreads.CharacterListener;
import JavaThreads.CharacterSource;

import java.util.Random;

public class RandomCharacterGenerator extends Thread
implements CharacterSource {
    private static char[] chars;
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
        return (int) (Math.max(1000, 5000 * random.nextDouble()));
    }


    @Override
    public void addCharacterListener(CharacterListener cl) {
        handler.addCharacterListener(cl);
    }

    @Override
    public void removeCharacterListener(CharacterListener cl) {
        handler.removeCharacterListener(cl);
    }

    @Override
    public void nextCharacter() {
        handler.fireNewCharacter(this, (int)chars[random.nextInt(chars.length)]);
    }

    public void run() {
//        run1();
        run2();
    }

    private void run1() {
        while (!done) {
            nextCharacter();
            try {
                Thread.sleep(getPauseTime());
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void run2() {
        while(!isInterrupted()) {
            nextCharacter();
            try {
                Thread.sleep(getPauseTime());
            } catch (InterruptedException e) {
                System.out.println("InterruptedException from file RandomCharacterGenerator, function run2");
                return;
            }
        }
    }


    public void setDone() {
        done = true;
    }
}

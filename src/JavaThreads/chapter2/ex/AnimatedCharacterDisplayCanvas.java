package JavaThreads.chapter2.ex;

import JavaThreads.chapter2.CharacterDisplayCanvas;
import JavaThreads.chapter2.CharacterEvent;
import JavaThreads.chapter2.CharacterListener;
import JavaThreads.chapter2.CharacterSource;

import java.awt.*;

public class AnimatedCharacterDisplayCanvas extends CharacterDisplayCanvas
implements Runnable {
    private volatile boolean done = false;
    private int curX = 0;


    public AnimatedCharacterDisplayCanvas() {
        super();
    }

    public AnimatedCharacterDisplayCanvas(CharacterSource ce) {
        super(ce);
    }

    @Override
    public synchronized void newCharacter(CharacterEvent ce) {
        curX = 0;
        tempChar[0] = (char)ce.character;
        repaint();
    }

    @Override
    protected synchronized void paintComponent(Graphics gc) {
        Dimension d = getSize();
        gc.clearRect(0, 0, d.width, d.height);

        if (tempChar[0] == 0) {
            return;
        }

        int charWidth = fm.charWidth(tempChar[0]);
        gc.drawChars(tempChar, 0, 1, curX++, fontHeight);
    }

    public void setDone(boolean b) {
        done = b;
    }

    @Override
    public void run() {
        while (!done) {
            repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

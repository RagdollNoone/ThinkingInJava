package JavaThreads.chapter4.ex1;

import JavaThreads.CharacterEvent;
import JavaThreads.CharacterListener;
import JavaThreads.CharacterSource;
import JavaThreads.chapter4.CharacterDisplayCanvas;

import java.awt.*;

public class AnimatedCharacterDisplayCanvas extends CharacterDisplayCanvas implements CharacterListener, Runnable {

    private boolean done = true;
    private int curX = 0;

    public AnimatedCharacterDisplayCanvas() {
    }

    public AnimatedCharacterDisplayCanvas(CharacterSource cs) {
        super(cs);
    }

    public synchronized void newCharacter(CharacterEvent ce) {
        curX = 0;
        tmpChar[0] = (char) ce.character;
        repaint();
    }

    protected synchronized void paintComponent(Graphics gc) {
        Dimension d = getSize();
        gc.clearRect(0, 0, d.width, d.height);
        if (tmpChar[0] == 0)
            return;
        int charWidth = fm.charWidth(tmpChar[0]);
        gc.drawChars(tmpChar, 0, 1,
                     curX++, fontHeight);
    }

    public synchronized void run() {
        while (true) {
            try {
                if (done) {
                    wait();
                } else {
                    repaint();
                    wait(100);
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

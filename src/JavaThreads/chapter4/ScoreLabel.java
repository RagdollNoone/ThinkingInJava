package JavaThreads.chapter4;

import JavaThreads.CharacterEvent;
import JavaThreads.CharacterListener;
import JavaThreads.CharacterSource;

import javax.swing.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ScoreLabel extends JLabel
implements CharacterListener {

    private volatile  int score = 0; // TODO: 为什么要声明为volatile
    private int char2type = -1;
    private CharacterSource generator = null, typist = null;
    private Lock scoreLock = new ReentrantLock();

    public ScoreLabel(CharacterSource generator, CharacterSource typist) {
        this.generator = generator;
        this.typist = typist;

        if (null != this.generator) {
            this.generator.addCharacterListener(this);
        }

        if (null != this.typist) {
            this.typist.addCharacterListener(this);
        }
    }

    public ScoreLabel() {
        this(null, null);
    }

    public void resetGenerator(CharacterSource newGenerator) {
        try {
            scoreLock.lock();

            if (null != this.generator) {
                this.generator.removeCharacterListener(this);
            }

            this.generator = newGenerator;

            if (null != this.generator) {
                this.generator.addCharacterListener(this);
            }
        } finally {
            scoreLock.unlock();
        }
    }

    public void resetTypist(CharacterSource newTypist) {
        try {
            scoreLock.lock();

            if (null != this.typist) {
                this.typist.removeCharacterListener(this);
            }

            this.typist = newTypist;

            if (null != this.typist) {
                this.typist.addCharacterListener(this);
            }
        } finally {
            scoreLock.unlock();
        }
    }

    public synchronized void resetScore() {
        try {
            scoreLock.lock();

            score = 0;
            char2type = -1;
            setScore();
        } finally {
            scoreLock.unlock();
        }
    }

    private void setScore() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setText(Integer.toString(score));
            }
        });
    }


    @Override
    public void newCharacter(CharacterEvent ce) {
        if (ce.source == this.generator) {
            newGeneratorCharacter(ce.character);
        } else {
            newTypistCharacter(ce.character);
        }
    }

    private synchronized void newGeneratorCharacter(int c) {
        if (char2type != -1) {
            score--;
            setScore();
        }

        char2type = c;
    }

    private synchronized void newTypistCharacter(int c) {
        if (char2type != c) {
            score--;
        } else {
            score++;
            char2type = -1;
        }

        setScore();
    }
}

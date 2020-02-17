package JavaThreads.chapter3.ex;

import JavaThreads.chapter3.*;
import javax.swing.*;

public class ScoreLabel extends JLabel
implements CharacterListener {
    // TODO: static synchronized 会获得class对象的lock, 多个这样的函数的race condition
    // TODO: synchronized function调用一个static synchronized

    private volatile  int score = 0; // TODO: 为什么要声明为volatile
    private int char2type = -1;
    private CharacterSource generator = null, typist = null;

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

    public synchronized void resetGenerator(CharacterSource newGenerator) {
        if (null != this.generator) {
            this.generator.removeCharacterListener(this);
        }

        this.generator = newGenerator;

        if (null != this.generator) {
            this.generator.addCharacterListener(this);
        }
    }

    public synchronized void resetTypist(CharacterSource newTypist) {
        if (null != this.typist) {
            this.typist.removeCharacterListener(this);
        }

        this.typist = newTypist;

        if (null != this.typist) {
            this.typist.addCharacterListener(this);
        }
    }

    public synchronized void resetScore() {
        score = 0;
        char2type = -1;
        setScore();
    }

    // TODO: 如果有一个类似的函数 但是却不是同步的 在多线程的情况下会怎么样
    private synchronized void setScore() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setText(Integer.toString(score));
            }
        });
    }


    @Override
    public synchronized void newCharacter(CharacterEvent ce) {
        if (ce.source == this.generator) {
            if (char2type != -1) {
                score--;
                setScore();
            }

            char2type = ce.character;
        } else {
            if (char2type != ce.character) {
                score--;
            } else {
                score++;
                char2type = -1;
            }

            setScore();
        }
    }
}

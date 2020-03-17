package JavaThreads.chapter5.ex1;

import JavaThreads.CharacterEvent;
import JavaThreads.CharacterListener;
import JavaThreads.CharacterSource;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ScoreLabel extends JLabel
implements CharacterListener {
    private AtomicInteger score = new AtomicInteger(0);
    private AtomicInteger char2type = new AtomicInteger(-1);
    private AtomicReference<CharacterSource> generator = null;
    private AtomicReference<CharacterSource> typist = null;

    public ScoreLabel(CharacterSource generator, CharacterSource typist) {
        this.generator = new AtomicReference(generator);
        this.typist = new AtomicReference(typist);

        if (null != generator) {
            generator.addCharacterListener(this);
        }

        if (null != typist) {
            typist.addCharacterListener(this);
        }
    }

    public ScoreLabel() {
        this(null, null);
    }

    public void resetGenerator(CharacterSource newGenerator) {
        CharacterSource oldGenerator;

        if (null != newGenerator) {
            newGenerator.addCharacterListener(this);
        }

        oldGenerator = generator.getAndSet(newGenerator);

        if (null != oldGenerator) {
            oldGenerator.removeCharacterListener(this);
        }
    }

    public void resetTypist(CharacterSource newTypist) {
        CharacterSource oldTypist;

        if (null != newTypist) {
            newTypist.addCharacterListener(this);
        }

        oldTypist = typist.getAndSet(newTypist);

        if (null != oldTypist) {
            oldTypist.removeCharacterListener(this);
        }
    }

    public void resetScore() {
        score.set(0);
        char2type.set(-1);
        setScore();
    }

    private void setScore() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setText(Integer.toString(score.get()));
            }
        });
    }

    @Override
    public void newCharacter(CharacterEvent ce) {
        int oldChar2type;

        if (ce.source == generator.get()) {
            oldChar2type = char2type.getAndSet(ce.character);

            if (oldChar2type != -1) {
                score.decrementAndGet();
                setScore();
            }
        } else if (ce.source == typist.get()) {
            while (true) {
                oldChar2type = char2type.get();

                if (oldChar2type != ce.character) {
                    score.decrementAndGet();
                    break;
                } else if (char2type.compareAndSet(oldChar2type, -1)) {
                    score.incrementAndGet();
                    break;
                }
            }

            setScore();
        }
    }
}

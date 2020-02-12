package JavaThreads.chapter2.ex2;

import JavaThreads.chapter2.CharacterDisplayCanvas;
import JavaThreads.chapter2.CharacterEventHandler;
import JavaThreads.chapter2.CharacterListener;
import JavaThreads.chapter2.CharacterSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SwingTypeTester extends JFrame
implements CharacterSource {
    protected RandomCharacterGenerator producer;
    private CharacterDisplayCanvas displayCanvas;
    private CharacterDisplayCanvas feedbackCanvas;

    private JButton quitButton;
    private JButton startButton;

    private CharacterEventHandler handler;

    public SwingTypeTester() {
        initComponents();
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
        throw new IllegalStateException("We don't produce on demand");
    }

    public void newCharacter(int c) {
        handler.fireNewCharacter(this, c);
    }

    private void initComponents() {
        handler = new CharacterEventHandler();

        initCanvas();
        initButton();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                quit();
            }
        });
        pack();
    }

    private void initCanvas() {
        displayCanvas = new CharacterDisplayCanvas();
        feedbackCanvas = new CharacterDisplayCanvas(this);

        add(displayCanvas, BorderLayout.NORTH);
        add(feedbackCanvas, BorderLayout.CENTER);

        feedbackCanvas.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
            char c = ke.getKeyChar();

            if (c != KeyEvent.CHAR_UNDEFINED) {
                newCharacter((int)c);
            }
            }
        });
    }

    private void initButton() {
        JPanel p = new JPanel();
        add(p, BorderLayout.SOUTH);

        quitButton = new JButton();
        startButton = new JButton();
        startButton.setText("Start");
        quitButton.setText("Quit");
        p.add(startButton);
        p.add(quitButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                producer = new RandomCharacterGenerator();
                displayCanvas.setCharacterSource(producer);

                producer.start();

                startButton.setEnabled(false);
                feedbackCanvas.setEnabled(true);
                feedbackCanvas.requestFocus();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                quit();
            }
        });
    }

    private void quit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        new SwingTypeTester().setVisible(true);
    }
}

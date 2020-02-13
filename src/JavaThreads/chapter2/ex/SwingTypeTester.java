package JavaThreads.chapter2.ex;

import JavaThreads.chapter2.CharacterDisplayCanvas;
import JavaThreads.chapter2.CharacterEventHandler;
import JavaThreads.chapter2.CharacterListener;
import JavaThreads.chapter2.CharacterSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingTypeTester extends JFrame
implements CharacterSource {
    protected RandomCharacterGenerator producer;
    private AnimatedCharacterDisplayCanvas displayCanvas;
    private CharacterDisplayCanvas feedbackCanvas;

    private JButton quitButton;
    private JButton startButton;
    private JButton stopButton;

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
        displayCanvas = new AnimatedCharacterDisplayCanvas();
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
        stopButton = new JButton();
        startButton.setText("Start");
        quitButton.setText("Quit");
        stopButton.setText("Stop");
        p.add(startButton);
        p.add(quitButton);
        p.add(stopButton);

        stopButton.setEnabled(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                producer = new RandomCharacterGenerator();
                displayCanvas.setCharacterSource(producer);

                Thread t = new Thread(displayCanvas);
                t.start();

                producer.start();

                startButton.setEnabled(false);
                stopButton.setEnabled(true);

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

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startButton.setEnabled(true);
                stopButton.setEnabled(false);

//                producer.setDone();
                producer.interrupt();

                displayCanvas.setDone(true);

                feedbackCanvas.setEnabled(false);
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

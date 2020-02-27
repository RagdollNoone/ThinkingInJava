package JavaThreads.chapter4.ex1;

import JavaThreads.CharacterEventHandler;
import JavaThreads.CharacterListener;
import JavaThreads.CharacterSource;
import JavaThreads.chapter4.CharacterDisplayCanvas;
import JavaThreads.chapter4.ScoreLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 可以把wait-notify机制换成volatile状态位的方案
public class SwingTypeTester extends JFrame implements CharacterSource {

    protected RandomCharacterGenerator producer;
    private AnimatedCharacterDisplayCanvas displayCanvas;
    private CharacterDisplayCanvas feedbackCanvas;
    private JButton quitButton;
    private JButton startButton;
    private JButton stopButton;
    private CharacterEventHandler handler;
    private ScoreLabel score;
    
    public SwingTypeTester() {
        initComponents();
    }
    
    private void initComponents() {
        handler = new CharacterEventHandler();
        displayCanvas = new AnimatedCharacterDisplayCanvas();
        feedbackCanvas = new CharacterDisplayCanvas(this);
        quitButton = new JButton();
        startButton = new JButton();
        stopButton = new JButton();
        score = new ScoreLabel(null, this);

        Container pane = getContentPane();
        pane.add(displayCanvas, BorderLayout.NORTH);
        pane.add(feedbackCanvas, BorderLayout.CENTER);

        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        score.setText("     ");
        score.setFont(new Font("MONOSPACED", Font.BOLD, 30));
        p1.add(score, BorderLayout.CENTER);

        JPanel p2 = new JPanel();
        startButton.setText("Start");
        stopButton.setText("Stop");
        stopButton.setEnabled(false);
        quitButton.setText("Quit");
        p2.add(startButton);
        p2.add(stopButton);
        p2.add(quitButton);
	    p1.add(p2, BorderLayout.EAST);
	    pane.add(p1, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                quit();
            }
        });

        feedbackCanvas.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (c != KeyEvent.CHAR_UNDEFINED)
                    newCharacter((int) c);
            }
        });

        producer = new RandomCharacterGenerator();
        displayCanvas.setCharacterSource(producer);
        score.resetGenerator(producer);
        producer.start();
        Thread t = new Thread(displayCanvas);
        t.start();

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                producer.setDone(false);
                displayCanvas.setDone(false);

                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                feedbackCanvas.setEnabled(true);
                feedbackCanvas.requestFocus();
                score.resetScore();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                producer.setDone(true);
                displayCanvas.setDone(true);

                startButton.setEnabled(true);
                stopButton.setEnabled(false);
                displayCanvas.setDone(true);
                feedbackCanvas.setEnabled(false);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                quit();
            }
        });

        pack();
    }

    private void quit() {
        System.exit(0);
    }

    public void addCharacterListener(CharacterListener cl) {
        handler.addCharacterListener(cl);
    }

    public void removeCharacterListener(CharacterListener cl) {
        handler.removeCharacterListener(cl);
    }

    public void newCharacter(int c) {
        handler.fireNewCharacter(this, c);
    }

    public void nextCharacter() {
        throw new IllegalStateException("We don't produce on demand");
    }
    
    public static void main(String args[]) {
        new SwingTypeTester().setVisible(true);
    }
}

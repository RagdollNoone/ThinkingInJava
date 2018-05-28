package Chapter22;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Button2 extends JFrame{
    private JButton b1 = new JButton("Button 1");
    private JButton b2 = new JButton("Button 2");
    private JButton b3 = new JButton("Button 3");

    private JTextField txt = new JTextField(10);

//    class ButtonListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String name = ((JButton)e.getSource()).getText();
//            txt.setText(name);
//        }
//    }
//
//    private ButtonListener bl = new ButtonListener();

    ActionListener bl = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton)e.getSource()).getText();
            txt.setText(name);
        }
    };

    public Button2(){
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        b3.addActionListener(bl);

        setLayout(new FlowLayout());

        add(b1);
        add(b2);
        add(b3);

        add(txt);
    }

    public static void main(String[] args){
        SwingConsole.run(new Button2(), 300, 150);
    }
}

package Chapter22;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import thirdparty.net.mindview.util.*;

public class TextArea extends JFrame{
    private JButton b = new JButton("Add Data");
    private JButton c = new JButton("Clear Data");

    private JTextArea t = new JTextArea(20, 40);
    private HashMap<String, String> m = new HashMap<String, String>();

    public TextArea(){
        m.putAll(Countries.capitals());
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Map.Entry me : m.entrySet())
                    t.append(me.getKey() + ": " + me.getValue() + "\n");
            }
        });

        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.setText("");
            }
        });

        setLayout(new FlowLayout());

        add(new JScrollPane(t));
        add(b);
        add(c);
    }

    public static void main(String[] args){
        SwingConsole.run(new TextArea(), 475, 425);
    }

}
package DesignPattern.ProxyPattern.VirtualProxy;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

public class VirtualProxy {
    private ImageComponent imageComponent;
    private JFrame frame = new JFrame("CD Cover Viewer");
    private JMenuBar menuBar;
    private JMenu menu;
    private Hashtable<String, String> cds = new Hashtable<>();

    public VirtualProxy() throws Exception {
        initCDs();

        URL initURL = new URL((String) cds.get("Selected Ambient Works, Vol. 2"));
        menuBar = new JMenuBar();
        menu = new JMenu("Favorite CDs");

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        addMenuItem();

        Icon icon = new ImageProxy(initURL);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    private void initCDs() {
        cds.put("Buddha Bar","http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg");
        cds.put("Ima","http://images.amazon.com/images/P/B000005IRM.01.LZZZZZZZ.jpg");
        cds.put("Karma","http://images.amazon.com/images/P/B000005DCB.01.LZZZZZZZ.gif");
        cds.put("MCMXC A.D.","http://images.amazon.com/images/P/B000002URV.01.LZZZZZZZ.jpg");
        cds.put("Northern Exposure","http://images.amazon.com/images/P/B000003SFN.01.LZZZZZZZ.jpg");
        cds.put("Selected Ambient Works, Vol. 2","http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");
    }

    private void addMenuItem() {
        for (Enumeration<String> e = cds.keys(); e.hasMoreElements();) {
            String name = e.nextElement();
            JMenuItem menuItem = new JMenuItem(name);

            menu.add(menuItem);

            menuItem.addActionListener(actionEvent -> {
                imageComponent.setIcon(new ImageProxy(getCDUrl(actionEvent.getActionCommand())));
                frame.repaint();
            });
        }
    }

    private URL getCDUrl(String name) {
        try {
            return new URL((String) cds.get(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }


}

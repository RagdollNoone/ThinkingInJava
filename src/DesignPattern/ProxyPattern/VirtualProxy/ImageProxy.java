package DesignPattern.ProxyPattern.VirtualProxy;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageProxy implements Icon {
    private volatile ImageIcon imageIcon;
    private final URL imageURL;
    private Thread retrievalThread;
    private boolean retrieving = false;

    public ImageProxy(URL url) {
        this.imageURL = url;
    }

    @Override
    public int getIconHeight() {
        if (null != imageIcon) {
            return imageIcon.getIconHeight();
        } else {
            return 600;
        }

    }

    @Override
    public int getIconWidth() {
        if (null != imageIcon) {
            return imageIcon.getIconWidth();
        } else {
            return 800;
        }
    }

    synchronized void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int i, int i1) {
        if (null != imageIcon) {
            imageIcon.paintIcon(component, graphics, i, i1);
        } else {
            graphics.drawString("Loading CD cover, please wait...", i + 300, i1 + 190);
            if (!retrieving) {
                retrieving = true;

                retrievalThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            setImageIcon(new ImageIcon(imageURL, "CD Cover"));
                            component.repaint();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                retrievalThread.start();
            }
        }
    }
}

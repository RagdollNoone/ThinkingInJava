package Chapter22;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MouseDragTest extends JFrame
{
    private Panel panel;
    static  MouseDragTest mdt;

    public MouseDragTest()
    {
        super("Frame Name Here");

        panel = new Panel();
        panel.addMouseListener((MouseListener)panel);
        panel.addMouseMotionListener((MouseMotionListener)panel);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
    }


    public static void main(String[] args) throws Exception
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                mdt = new MouseDragTest();
            }
        });
    }

    public class Panel extends javax.swing.JPanel implements MouseListener, MouseMotionListener
    {
        private ShapeEditor shapeEditor;

        public Panel()
        {
            shapeEditor = new ShapeEditor(this);
        }

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Panel mouseDragged");
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
    }

    public class ShapeEditor
    {
        private JPanel parent;
        private MouseListener mouseListener;
        private MouseMotionListener mouseMotionListener;

        public ShapeEditor(JPanel aPanel)
        {
            this.parent = aPanel;
            this.mouseListener = new ShapeMouseListener();
            this.mouseMotionListener = new ShapeMouseMotionListener();

            this.parent.addMouseListener(this.mouseListener);
            this.parent.addMouseMotionListener(this.mouseMotionListener);
        }

        private class ShapeMouseListener extends MouseAdapter
        {

        }

        private class ShapeMouseMotionListener extends MouseMotionAdapter
        {
            public void mouseDragged(MouseEvent e)
            {
                System.out.println("ShapeEditor mouseDragged");
            }
        }
    }
}
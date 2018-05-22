package Chapter22;
import javax.swing.*;
import java.util.concurrent.*;

public class SwingFoundation extends JFrame
{
	JLabel label1;
	JLabel label2;
	public SwingFoundation()
	{
		super("Frame Name Here");
		label1 = new JLabel("Label Content 1");
		add(label1);
		
		label2 = new JLabel("Label Content 2"); // 只显示后添加进去的对象 ex2
		add(label2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 这句话似乎没有用了 ex1
		setSize(300, 300);
		setVisible(true);
	}
	
	static SwingFoundation sf;
	
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() 
			{
				sf = new SwingFoundation();
			}
		});
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() 
			{
				sf.label1.setText("Hey! This is label1 Different!");
				sf.label2.setText("Hey! This is label2 Different!");
			}
		});
	}
}

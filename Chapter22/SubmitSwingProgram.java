package Chapter22;
import javax.swing.*;
import java.util.concurrent.*;

public class SubmitSwingProgram extends JFrame
{
	JLabel label1;

	public SubmitSwingProgram()
	{
		super("Frame Name Here");
		label1 = new JLabel("Label Content 1");
		add(label1);
	}
	
	static SubmitSwingProgram sf;
	
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() 
			{
				sf = new SubmitSwingProgram();
				SwingConsole.run(sf, 300, 300);
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
			}
		});
	}
}

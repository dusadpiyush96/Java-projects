import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddingIcon extends JApplet{
	public void init(){
		try{
			SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				makeGUI();
			}
		});
		}
		catch(Exception e){}
	}
	public void makeGUI(){
		setLayout(new FlowLayout());
		ImageIcon n=new ImageIcon("11.png");
		JLabel jlab=new JLabel("Water",n,JLabel.CENTER);
		add(jlab);
	}
}

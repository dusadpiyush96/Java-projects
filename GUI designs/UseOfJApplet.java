import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class UseOfJApplet extends JApplet{
	JButton alpha;
	JButton beta;
	JLabel jlab;
	public void init(){
		try{
			SwingUtilities.invokeAndWait(new Runnable(){
			
				public void run(){
				makeGUI();
			
		
			}});
		}
		catch(Exception e){}
		
			
	}
	public void makeGUI(){
		setLayout(new FlowLayout());
		alpha=new JButton("ALPHA");
		beta=new JButton("BETA");
		alpha.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				jlab.setText("Alpha has been pressed");
			}
		});
		beta.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				jlab.setText("Beta has been pressed");
			}
		});
		ImageIcon ii=new ImageIcon("11.png");
		jlab=new JLabel("Press any button.");
		//JLabel j2=new JLabel("Piyush",ii,JLabel.CENTER);
		//add(j2);
		add(alpha);
		add(beta);
		add(jlab);
	}

}

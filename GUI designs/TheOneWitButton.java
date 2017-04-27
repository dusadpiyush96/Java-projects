import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Buttons{
	JLabel jlab;
	Buttons(){
		JFrame jfrm=new JFrame("Hello World!");
		jfrm.setVisible(true);
		jfrm.setSize(200, 100);
		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton jbtnalpa=new JButton("Alpha");
		JButton jbtnbeta=new JButton("Beta");
		jbtnalpa.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				jlab.setText("Alpha was Pressed");
			}
		});
		jbtnbeta.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				jlab.setText("Beta was Pressed");
			}
		});
		jfrm.add(jbtnbeta);
		jfrm.add(jbtnalpa);
		jlab=new JLabel("Press any button");
		jfrm.add(jlab);
	}
}

public class TheOneWitButton {
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Buttons();
			}
		});
	}
}

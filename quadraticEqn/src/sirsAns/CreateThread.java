package sirsAns;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class CreateThread extends Thread
{
private JTextField 		T1;
private JTextField 		T2;
private JTextField 		T3;
private QuadraticEquationQueue	queue;
private boolean			suspendFlag = false;
private JLabel			label;
private JLabel			queueFull;
CreateThread(JTextField T1,JTextField T2,JTextField T3,QuadraticEquationQueue	queue,JLabel label, JLabel queuefullLabel)
{
this.T1 	= T1;
this.T2 	= T2;
this.T3 	= T3;
this.queue 	= queue;
this.label	= label;
this.queueFull	= queuefullLabel;
}
public void run()
{
	try 
	{
		while(true)
		{
			synchronized(this)
					{
						while(suspendFlag ) 
						wait();
					}
			try
			{
			int a = Integer.parseInt(T1.getText());
			int b = Integer.parseInt(T2.getText());
			int c = Integer.parseInt(T3.getText());
			if( a == 0 ) continue;
			QuadraticEquation quad = new QuadraticEquation(a,b,c);
			queue.add(quad);
			String text = "Total No of Equations Created:"+quad.getNoofObjects();
			System.out.println(text);
			System.out.println();
			label.setText(text);
			if(queue.isFull())
				queueFull.setForeground(Color.green);
			else
				queueFull.setForeground(Color.black);
			}
			catch(NumberFormatException ne) {}
			Thread.sleep(150);
			
		}
	}
	catch(InterruptedException  e){System.out.println(e);}
}// End of Run Method

public void mysuspend()
{
suspendFlag = true;
}
public synchronized void myresume()
{
suspendFlag = false;
notify();
}
}// End of CreateThread class
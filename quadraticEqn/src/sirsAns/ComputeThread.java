package sirsAns;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class ComputeThread extends Thread
{
private QuadraticEquationQueue	queue;
private JLabel[] 	displayLabels = new JLabel[10];
private JLabel		totalCountLabel;
private JLabel		countLabel1;
private JLabel		countLabel2;
private JLabel		countLabel3;

private	static  int	totalCount=0;
private static  int	count1=0;
private static  int	count2=0;
private static  int	count3=0;

private	int	threadNo;
private	boolean	suspendFlag;

private JLabel	queueEmpty;

ComputeThread(QuadraticEquationQueue	queue,JLabel[] labels,JLabel totalcountLabel, JLabel L1, JLabel L2,JLabel L3,JLabel queueEmpty,int no)
{
this.queue		= queue;
displayLabels 		= labels;
this.totalCountLabel 	= totalcountLabel;	
countLabel1		= L1;
countLabel2		= L2;
countLabel3		= L3;
threadNo		= no;
this.queueEmpty		= queueEmpty;
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
			synchronized(this)
			{
				QuadraticEquation quad = queue.remove();
				if(queue.isEmpty())
				queueEmpty.setForeground(Color.green);
				else
				queueEmpty.setForeground(Color.black);
				System.out.println("You are Code is Here-->1");
				boolean flag = quad.getisSolved();
				if(flag) continue;
				System.out.println("You are Code is Here-->2");
				int a	= totalCount % 10;
				quad.computeRoots();
				displayLabels[a].setText(quad.toString());
				totalCount++;
				totalCountLabel.setText("Total No of Equations Solved :"+totalCount);
				if (threadNo == 1)
				{
					count1++;
					countLabel1.setText("By Thread1:"+count1);
				}
				if (threadNo == 2)
				{
					count2++;
					countLabel2.setText("By Thread2:"+count2);
				}
				if (threadNo == 3)
				{
					count3++;
					countLabel3.setText("By Thread3:"+count3);
				}
				Thread.sleep(150);
		 	}
		}
	}
	catch(InterruptedException e){System.out.println(e);}
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

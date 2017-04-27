package sirsAns;

import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class OnlineMain
{
static Random 	r1 = new Random(20);

static boolean 	createThreadStarted	= false;
static boolean 	createThreadStopped	= false;
static boolean 	createThreadResumed	= false;

static boolean 	computeThreadStarted	= false;
static boolean 	computeThreadStopped	= false;
static boolean 	computeThreadResumed	= false;




public static void main(String args[])
{
JFrame frame = new JFrame("QuadraticFrame");
Container c1 = frame.getContentPane();
c1.setLayout(new BoxLayout(c1,BoxLayout.X_AXIS));

JPanel leftPanel = new JPanel();
leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));

JLabel label1	= new JLabel("QUEUE FULL");
leftPanel.add(label1);

JButton b1 = new JButton("START");
JButton b2 = new JButton("STOP");

JLabel L1	= new JLabel("A =");
JLabel L2	= new JLabel("B =");
JLabel L3	= new JLabel("C =");
JLabel L4	= new JLabel("Total No of Equations Created:"+0);

JPanel btnPanel = new JPanel();
btnPanel.add(b1);
btnPanel.add(b2);

final JTextField T1 	= new JTextField(6); 
final JTextField T2 	= new JTextField(6); 
final JTextField T3 	= new JTextField(6); 

T1.setText("0");
T2.setText("0");
T3.setText("0");

JPanel P1 = new JPanel();
P1.add(L1);
P1.add(T1);

JPanel P2 = new JPanel();
P2.add(L2);
P2.add(T2);

JPanel P3 = new JPanel();
P3.add(L3);
P3.add(T3);

JPanel P4 = new JPanel();
P4.add(L4);

leftPanel.add(btnPanel);
leftPanel.add(P1);
leftPanel.add(P2);
leftPanel.add(P3);
leftPanel.add(P4);



JPanel rightPanel = new JPanel();
rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));

JLabel L20 = new JLabel("QUEUE EMPTY");
rightPanel.add(L20);

JPanel P21 = new JPanel();
JButton b3 = new JButton("START");
JButton b4 = new JButton("STOP");
P21.add(b3);
P21.add(b4);


JLabel[] resultLabels = new JLabel[10];
for(int i=0;i<10;i++)
resultLabels[i] = new JLabel();

JPanel P22 = new JPanel();
P22.setLayout(new BoxLayout(P22,BoxLayout.Y_AXIS));
for(int i=0;i<10;i++)
P22.add(resultLabels[i]);

JLabel L21 = new JLabel("Total No Of Equations Solved:"+0);
P22.add(L21);

JLabel L22 = new JLabel("By Thread 1:"+0);
P22.add(L22);

JLabel L23 = new JLabel("By Thread 2:"+0);
P22.add(L23);

JLabel L24 = new JLabel("By Thread 3:"+0);
P22.add(L24);

rightPanel.add(P21);
rightPanel.add(P22);

c1.add(leftPanel);
c1.add(rightPanel);
frame.setSize(400,600);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);




ActionListener listener = new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
				Integer  a = r1.nextInt(20);
				Integer  b = r1.nextInt(20);
				Integer  c = r1.nextInt(20);
				T1.setText(a.toString());
				T2.setText(b.toString());
				T3.setText(c.toString()); 
				return;
			        }
			};
final Timer timer = new Timer(100,listener);
final QuadraticEquationQueue queue = new QuadraticEquationQueue();
final CreateThread createThread1 = new CreateThread(T1,T2,T3,queue,L4,label1);

final ComputeThread computeT1 = new ComputeThread(queue,resultLabels,L21,L22,L23,L24,L20,1);
final ComputeThread computeT2 = new ComputeThread(queue,resultLabels,L21,L22,L23,L24,L20,2);
final ComputeThread computeT3 = new ComputeThread(queue,resultLabels,L21,L22,L23,L24,L20,3);



b1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
		if(!createThreadStarted) 
			{
			createThread1.start();
			createThreadStarted = true;
			timer.start();
			return;
			}	
		if(createThreadStopped)
			{
			createThread1.myresume();
			createThreadResumed = true;
			createThreadStopped = false;
        		timer.restart();
			}
		}
	});

b2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(createThreadResumed || createThreadStarted)
			{
			createThread1.mysuspend();
			createThreadStopped = true;
			createThreadResumed = false;
			timer.stop();
			}
		}
	});

b3.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
		if(!computeThreadStarted) 
			{
			computeT1.start();
			computeT2.start();
			computeT3.start();
			computeThreadStarted = true;
			return;
			}	
		if(computeThreadStopped)
			{
			computeT1.myresume();
			computeT2.myresume();
			computeT3.myresume();
			computeThreadResumed = true;
			computeThreadStopped = false;
        		}
		}
	});

b4.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(computeThreadStarted || computeThreadResumed) 
			{
			computeT1.mysuspend();
			computeT2.mysuspend();
			computeT3.mysuspend();
			computeThreadStopped = true;
			computeThreadResumed = false;
			}	
		}
	});



}
}
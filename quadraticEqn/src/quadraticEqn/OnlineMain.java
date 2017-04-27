package quadraticEqn;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class OnlineMain
{
static Random 	r1 = new Random(20);			// Random instance to craete random integer
static boolean 	createThreadStarted	= false;	// indicates whether CreateThread has been started or not
static boolean 	createThreadStopped	= false;	// indicates whether CreateThread has been stopped or not
static boolean 	createThreadResumed	= false;	// indicates whether CreateThread has been resumed or not
static boolean 	computeThreadStarted	= false;	// indicates whether ComputeThread has been started or not
static boolean 	computeThreadStopped	= false;	// indicates whether ComputeThread has been stopped or not
static boolean 	computeThreadResumed	= false;	// indicates whether ComputeThread has been resumed or not

public static void main(String args[])
{
JFrame frame = new JFrame("QuadraticFrame");			// Main JFrame
Container c1 = frame.getContentPane();				// Container for Main Frame 
c1.setLayout(new BoxLayout(c1,BoxLayout.X_AXIS));		// Setting Layout for Container c1

// **************************************** CREATION OF LEFTSIDE PANEL ***************************
// Creating First of the LeftSidePanel
//JPanel firstRow	= new JPanel();
JLabel label1	= new JLabel("QUEUE FULL");
//firstRow.add(label1);

// Creating START and STOP Buttons for the LeftSidePanel
JButton b1 = new JButton("START");
JButton b2 = new JButton("STOP");

// Creating Labels for the LeftSidePanel
JLabel L1	= new JLabel("A =");
JLabel L2	= new JLabel("B =");
JLabel L3	= new JLabel("C =");
JLabel L4	= new JLabel("No of QuadraticEquations Created:"+0);

// Creating Button Panel for START and STOP Buttons and adding Buttons to this Panel
JPanel btnPanel = new JPanel();
btnPanel.add(b1);
btnPanel.add(b2);

// Creating Three JTextFields for the LeftSidePanel
final JTextField T1 	= new JTextField(6); 
final JTextField T2 	= new JTextField(6); 
final JTextField T3 	= new JTextField(6); 

T1.setText("0");
T2.setText("0");
T3.setText("0");

// Creating Panel for Label "A=" and its corresponding JTextField and adding JLabel and JTextField to it
JPanel P1 = new JPanel();
P1.add(L1);
P1.add(T1);

// Creating Panel for Label "B=" and its corresponding JTextField and adding JLabel and JTextField to it
JPanel P2 = new JPanel();
P2.add(L2);
P2.add(T2);

// Creating Panel for Label "C=" and its corresponding JTextField and adding JLabel and JTextField to it
JPanel P3 = new JPanel();
P3.add(L3);
P3.add(T3);

// A Separate Panel for Last Label of the left sidePanel
JPanel P4 = new JPanel();
P4.add(L4);

// Creating a Final Panel and adding all the above panels to this
JPanel leftPanel = new JPanel();
leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
leftPanel.add(label1);
leftPanel.add(btnPanel);
leftPanel.add(P1);
leftPanel.add(P2);
leftPanel.add(P3);
leftPanel.add(P4);

// **************************************** CREATION OF RIGHTSIDE PANEL *************************** 

// Creating rightPanel and adding label "QUEUE EMPTY" to it
JPanel rightPanel = new JPanel();
rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
JLabel L20 = new JLabel("QUEUE EMPTY");		// L20 Label is QUEUE EMPTY
rightPanel.add(L20);

// Creating and Adding Buttons for right side 
JPanel P21 = new JPanel();			// P21 is Button Panel for right side
JButton b3 = new JButton("START");
JButton b4 = new JButton("STOP");
P21.add(b3);
P21.add(b4);

rightPanel.add(P21);

// Creating 10 JLabel references for Result Display Area for RightSide Panel
JLabel[] resultLabels = new JLabel[10];
for(int i=0;i<10;i++)
resultLabels[i] = new JLabel();

// Adding Labels of Result Display Area to rightPanel one by one 
for(int i=0;i<10;i++)
rightPanel.add(resultLabels[i]);

// Creating Label "NO OF EQUATIONS SOLVED" and adding it into right Panel
JLabel L21 = new JLabel("NO OF EQUATIONS SOLVED:"+0);
rightPanel.add(L21);

// Creating Three Counter Labels for compute Threads and adding it into right Panel
JLabel L22 = new JLabel("By Thread 1:");
rightPanel.add(L22);

JLabel L23 = new JLabel("By Thread 2:");
rightPanel.add(L23);

JLabel L24 = new JLabel("By Thread 3:");
rightPanel.add(L24);

// Finally Adding leftPanel and rightPanel to conatiner for Main Frame
c1.add(leftPanel);
c1.add(rightPanel);

frame.setSize(400,600); 				// setting size of JFrame
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// setting Default Close Operation
frame.setVisible(true); 				// Showing Jframe


// ***************** In main() method WRITE YOUR CODE FROM HERE *************************

QuadraticEquationQueue queue = new QuadraticEquationQueue();
CreateThread create = new CreateThread(r1,T1,T2,T3,L4,queue,label1,L20);
ComputeThread compute1 = new ComputeThread(queue,L20,resultLabels,L21,L22,label1);
ComputeThread compute2 = new ComputeThread(queue,L20,resultLabels,L21,L23,label1);
ComputeThread compute3 = new ComputeThread(queue,L20,resultLabels,L21,L24,label1);
b1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
		if(!createThreadStarted){
			create.start();
			createThreadStarted=true;
			createThreadResumed=true;
			create.resumeThread();
		}
		if(!createThreadResumed){
			createThreadResumed=true;
			create.resumeThread();
		}
	}
});

b2.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
		if(createThreadResumed){
			createThreadResumed=false;
			create.suspendThread();
		}
		if(computeThreadStarted){
			computeThreadResumed=false;
			compute1.suspendThread();
			compute2.suspendThread();
			compute3.suspendThread();
		}
	}
});

b3.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
		if(!computeThreadStarted){
			compute1.start();
			compute2.start();
			compute3.start();
			computeThreadStarted=true;
			computeThreadResumed=true;
			compute1.resumeThread();
			compute2.resumeThread();
			compute3.resumeThread();
		}
		if(!computeThreadResumed){
			computeThreadResumed=true;
			compute1.resumeThread();
			compute2.resumeThread();
			compute3.resumeThread();
		}
	}
});

b4.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent ae){
		computeThreadResumed=false;
		compute1.suspendThread();
		compute2.suspendThread();
		compute3.suspendThread();
	}
});
} // End of main() method
} // End of class OnlineMain




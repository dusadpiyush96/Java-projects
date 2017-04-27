package quadraticEqn;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class CreateThread extends Thread
{
	private Random r;
	private JTextField l1;
	private JTextField l2;
	private JTextField l3;
	private JLabel l4;
	private JLabel l20;
	private QuadraticEquationQueue q;
	private JLabel upper;
	private boolean suspendFlag=true;
	private int noOfEqnCreated=0;
	public CreateThread(Random r,JTextField l1,JTextField l2, JTextField l3, JLabel l4, QuadraticEquationQueue q, JLabel upper, JLabel L20 ){
		this.r=r;
		this.l1=l1;
		this.l2=l2;
		this.l3=l3;
		this.l4=l4;
		this.q=q;
		this.upper=upper;
		this.l20=L20;
	}
	public void suspendThread(){
		suspendFlag=true;
	}
	public synchronized void resumeThread(){
		suspendFlag=false;
		notify();
	}
// Write the code for this class
	public void run(){
		try{
			while(true){
				synchronized(this){
					while(suspendFlag) wait();
					Integer a= r.nextInt(20);
					l1.setText(a.toString());
					Integer b= r.nextInt(20);
					l2.setText(b.toString());
					Integer c= r.nextInt(20);
					l3.setText(c.toString());
					Thread.sleep(150);
					if(!q.isFull()){
						QuadraticEquation eqn = new QuadraticEquation(a,b,c);
						q.add(eqn);
						noOfEqnCreated++;
						l4.setText("No of QuadraticEquations Created:"+eqn.getNoofObjects());
					}
					if(!q.isFull()){
						upper.setForeground(Color.black);
					}
					else{
						upper.setForeground(Color.GREEN);
					}
					//if(q.isEmpty()) l20.setForeground(Color.green);
					//else l20.setForeground(Color.black);
				}
			}
		}
		catch(Exception e){}
	}
}// End of CreateThread class


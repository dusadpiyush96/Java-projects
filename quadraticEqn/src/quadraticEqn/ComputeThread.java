package quadraticEqn;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class ComputeThread extends Thread
{
	private QuadraticEquationQueue q;
	private JLabel L20;
	private JLabel[] result;
	private JLabel L21;
	private JLabel L;
	private boolean suspendFlag=true;
	private JLabel upperL;
	private static int noOfEqnSolved=0;
	private int noOfEqnSolvedT=0;
	public ComputeThread(QuadraticEquationQueue q, JLabel L20, JLabel[] result, JLabel L21, JLabel L, JLabel upperL){
		this.q=q;
		this.L20=L20;
		this.result=result;
		this.L21=L21;
		this.L=L;
		this.upperL=upperL;
	}
	
	public void suspendThread(){
		suspendFlag=true;
	}
	public synchronized void resumeThread(){
		suspendFlag=false;
		notify();
	} 
	
	//public 
	
	public void run(){
		try{
			int i=0;
			String s = L.getText();
			while(true){
				synchronized(this){
					while(suspendFlag) wait();
						QuadraticEquation eqn = q.remove();
						eqn.computeRoots();
						result[i].setText(eqn.toString());
						//if(i<10) i++;
						i++;
						if(i==10){
							i=0;
						}
						Thread.sleep(150);
						noOfEqnSolved++;
						noOfEqnSolvedT++;
						L21.setText("NO OF EQUATIONS SOLVED:"+eqn.getNoofObjects());
						L.setText(s+noOfEqnSolvedT);
						Integer x = noOfEqnSolvedT;
						if(q.isEmpty()){
							L20.setForeground(Color.green);
						}
						else L20.setForeground(Color.black);
				}
			}
		}
		catch(Exception e){}
	}
}

package fff;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MasterController	extends	Thread
{
	private	ArrayList<Player>	playerList;		//	Player List
	private	AnswerBoard		answerBoard;		//	sharable answer baord

	private	JTextField		timerTextField;		//	timerTextField to initialize the timer thread
	private	JTextArea		resultTextArea;		//	result display area

	private	JTextField		oT1;			//	option choice 1
	private	JTextField		oT2;			//	option choice 2
	private	JTextField		oT3;			//	option choice 3
	private	JTextField		oT4;			//	option choice 4

	private	JTextField		cT1;			//	option Coorect Choice 1
	private	JTextField		cT2;			//	option Coorect Choice 2
	private	JTextField		cT3;			//	option Coorect Choice 3
	private	JTextField		cT4;			//	option Coorect Choice 4
	
	private	JTextField		winnerPlayer;		//	TextField for displaying the id of winner
	private JTextField		timeTaken;		//	TextField for displaying the time taken by the winner	

	private	TimerThread		timer;			//	timer thread
	private	Question		currentQuestion;	//	current Question
	private JButton			resetB;			//	reset button (for enabling)
	private	boolean			suspendFlag;		//	suspend flag
	
	public	void			mysuspend()	{	suspendFlag = true;	}
	public	synchronized	void	myresume()	
	{	
		//System.out.println("Master Resuming");
		suspendFlag = false;
		notify();	
	}
	
	// Constructor
	MasterController(ArrayList<Player> playerList,AnswerBoard answerBoard,JTextField timerTextField,JTextArea resultTextArea,JTextField oT1,JTextField oT2,JTextField oT3,JTextField oT4, JTextField ct1, JTextField ct2, JTextField ct3, JTextField ct4,JTextField t5,JTextField t6,JButton b)
	{
	this.playerList		=	playerList;
	this.answerBoard	=	answerBoard;
	this.timerTextField	=	timerTextField;
	this.resultTextArea	=	resultTextArea;
	this.oT1		=	oT1;
	this.oT2		=	oT2;
	this.oT3		=	oT3;
	this.oT4		=	oT4;
	resetB			=	b;
	cT1			=	ct1;
	cT2			=	ct2;
	cT3			=	ct3;
	cT4			=	ct4;

	winnerPlayer		=	t5;
	timeTaken		=	t6;
	suspendFlag		=	true;
	timer			=	new	TimerThread(timerTextField);
	timer.start();
	}	
	
	// Add any other method that you think is required as per specification
	public	void	run()
	{
		// Complete the implementation for this method
	}
}

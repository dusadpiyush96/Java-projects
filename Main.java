package fff;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class	Main
{

/*******************Frames Panels and Labels used in File**************************/
private	static	JFrame		frame			=	new	JFrame("Fastest Finger First");
private	static	JPanel		playerPanel		=	new	JPanel();
private	static	JPanel		mainPlayerPanel 	=	new	JPanel();
private	static	JPanel		p1			=	new	JPanel(new FlowLayout());
private	static	JPanel		p2			=	new	JPanel();
private	static	JLabel		timerLabel		=	new	JLabel("Timer");
private	static	JPanel		p3			=	new	JPanel(new FlowLayout());
private	static	JLabel		questionLabel		=	new	JLabel("Question ");
private	static	JPanel		p4			=	new	JPanel(new	FlowLayout());
private	static	JLabel		optionLabel		=	new	JLabel("Options");
private	static	JPanel		p5			=	new	JPanel(new	FlowLayout());
private	static	JLabel		L1			=	new	JLabel("1. ");
private	static	JLabel		L2			=	new	JLabel("2. ");
private	static	JPanel		p6			=	new	JPanel(new	FlowLayout());
private	static	JLabel		L3			=	new	JLabel("3. ");
private	static	JLabel		L4			=	new	JLabel("4. ");
private	static	JPanel		p7			=	new	JPanel(new	FlowLayout());
private	static	JLabel		correctSequence		=	new	JLabel("Correct Sequence");
private	static	JPanel		p8			=	new	JPanel(new FlowLayout());
private	static	JLabel		resultLabel		=	new	JLabel("Results");	
private	static	JPanel		p9			=	new	JPanel(new FlowLayout());
private	static	JPanel		p10			=	new	JPanel(new FlowLayout());
private	static	JLabel		winner			=	new	JLabel(" Winner	Details ");
private	static	JLabel		winnerPlayer		=	new	JLabel("Player ");
private	static	JLabel		timeTaken		=	new	JLabel("Time Taken ");
private	static	JPanel		gamePanel		=	new	JPanel(new FlowLayout());
private	static	JLabel		gameLabel		=	new	JLabel("Game Number");
private	static	JPanel		centralPanel		=	new	JPanel();


/*******************Buttons used in File**************************/

private	static	JButton		playerbtn1		=	new	JButton("P1");		
private	static	JButton		playerbtn2		=	new	JButton("P2");
private	static	JButton		playerbtn3		=	new	JButton("P3");
private	static	JButton		playerbtn4		=	new	JButton("P4");
private	static	JButton		playerbtn5		=	new	JButton("P5");
private	static	JButton		playerbtn6		=	new	JButton("P6");
private	static	JButton		playerbtn7		=	new	JButton("P7");
private	static	JButton		playerbtn8		=	new	JButton("P8");
private	static	JButton		playerbtn9		=	new	JButton("P9");
private	static	JButton		playerbtn10		=	new	JButton("P10");

private	static	JButton		displayQ		=	new	JButton("Display Question");
private	static	JButton		startB			=	new	JButton("     Start      ");
private	static	JButton		resetB			=	new	JButton("     Reset      ");

/*******************TextFields and TextAreas in File**************************/

private	static	JTextArea	questionArea		=	new	JTextArea(4,80);		
private	static	JTextField	timerTextField		=	new	JTextField(10);

//	Question Choice Text Fields
private	static	JTextField	T1			=	new	JTextField(25);
private	static	JTextField	T2			=	new	JTextField(25);	
private	static	JTextField	T3			=	new	JTextField(25);
private	static	JTextField	T4			=	new	JTextField(25);

//	Correct Choice Text Fields
private	static	JTextField	CT1			=	new	JTextField(2);
private	static	JTextField	CT2			=	new	JTextField(2);
private	static	JTextField	CT3			=	new	JTextField(2);
private	static	JTextField	CT4			=	new	JTextField(2);

private	static	JTextArea	resultDisplayArea	=	new	JTextArea(15,80);
private	static	JTextField	winnerText		=	new	JTextField(10);
private	static	JTextField	timetakenText		=	new	JTextField(10);
private	static	JTextField	gamenoText		=	new	JTextField(5);


/*******************Shared Fields **************************/


private	static	AnswerBoard		answerBoard	=	new	AnswerBoard();			//	
private	static	int			gameKount	=	0;

//	Player Threads

private static	Player		fffP1;		
private static	Player		fffP2;		
private static	Player		fffP3;		
private static	Player		fffP4;		
private static	Player		fffP5;		
private static	Player		fffP6;		
private static	Player		fffP7;		
private static	Player		fffP8;		
private static	Player		fffP9;		
private static	Player		fffP10;	

//	Master Control Thread
private static	MasterController	master;	

	public	static	void	populateQuestionList(ArrayList<Question> questionList)
	{
	
		String		Q1 	=	"Arrange The Following Parts of Body from Top to Bottom";
		String[]	chQ1	=	{"Stomach","Eyes","Foot","Head"};
		int[]		crSeq1	=	{4,2,1,3};
	
		String		Q2 	=	"Arrange The Following Events from Their Date of Early occurence to Late occurence";
		String[]	chQ2	=	{"Indian Freedom","Kargil War","World War - II","French Revolution"};
		int[]		crSeq2	=	{4,3,1,2};

		String		Q3 	=	"Arrange The Following Indian Cities From NORTH TO SOUTH";
		String[]	chQ3	=	{"Bangalore","Agra","Delhi","Kochin"};
		int[]		crSeq3	=	{3,2,1,4};

		String		Q4 	=	"Arrange The Following Indian Cities From SOUTH TO NORTH";
		String[]	chQ4	=	{"Bangalore","Agra","Delhi","Kochin"};
		int[]		crSeq4	=	{4,1,2,3};

		String		Q5 	=	"Arrange The Following Marriage Functions from early Happenning to Late Happening";
		String[]	chQ5	=	{"Ghud Chadi","Sagai","Mehndi","Barat"};
		int[]		crSeq5	=	{2,3,1,4};

		String		Q6 	=	"Arrange The Following Contries from WEST to EAST";
		String[]	chQ6	=	{"India","Pakistan","Iran","Israel"};
		int[]		crSeq6	=	{4,3,2,1};
	
		String		Q7 	=	"Arrange The Following Contries from EAST to WEST";
		String[]	chQ7	=	{"India","Iran","Pakistan","Israel"};
		int[]		crSeq7	=	{1,3,2,4};
	
		String		Q8 	=	"Arrange The Following Parts of Body from Bottom to Top";
		String[]	chQ8	=	{"Stomach","Eyes","Foot","Head"};
		int[]		crSeq8	=	{3,1,2,4};	
	
		String		Q9 	=	"Arrange The Following Distance Measurement Dimensions in Increasing Order of their value";
		String[]	chQ9	=	{"Centimeter","Kilometer","MilliMetet","Meter"};
		int[]		crSeq9	=	{3,1,4,2};
		
		String		Q10 	=	"Arrange The Following Distance Measurement Dimensions in Decreasing Order of their value";
		String[]	chQ10	=	{"Centimeter","Kilometer","MilliMetet","Meter"};
		int[]		crSeq10	=	{2,4,1,3};
	
		questionList.add(new	Question(Q1,chQ1,crSeq1));	questionList.add(new	Question(Q2,chQ2,crSeq2));	questionList.add(new	Question(Q3,chQ3,crSeq3));
		questionList.add(new	Question(Q4,chQ4,crSeq4));	questionList.add(new	Question(Q5,chQ5,crSeq5));	questionList.add(new	Question(Q6,chQ6,crSeq6));
		questionList.add(new	Question(Q7,chQ7,crSeq7));	questionList.add(new	Question(Q8,chQ8,crSeq8));	questionList.add(new	Question(Q9,chQ9,crSeq9));
		questionList.add(new	Question(Q10,chQ10,crSeq10));
	
	}
	public	static	void	displayFrame()
	{
		startB.setEnabled(false);
		resetB.setEnabled(false);
		frame.setSize(1000,1000);
		frame.setLayout(new BorderLayout());
		playerPanel.setLayout(new	GridLayout(10,0));
		JLabel	label1		=	new	JLabel("Players");
		playerPanel.add(playerbtn1);playerPanel.add(playerbtn2);playerPanel.add(playerbtn3);playerPanel.add(playerbtn4);playerPanel.add(playerbtn5);
		playerPanel.add(playerbtn6);playerPanel.add(playerbtn7);playerPanel.add(playerbtn8);playerPanel.add(playerbtn9);playerPanel.add(playerbtn10);
		mainPlayerPanel.setLayout(new BoxLayout(mainPlayerPanel, BoxLayout.Y_AXIS));
		mainPlayerPanel.add(label1);
		mainPlayerPanel.add(playerPanel);
		p1.add(displayQ);
		p1.add(startB);
		p1.add(resetB);
		p2.setLayout(new FlowLayout());
		p2.add(timerLabel); p2.add(timerTextField);
		p3.add(questionLabel);p3.add(questionArea);
		p4.add(optionLabel);//,BorderLayout.CENTER);
		p5.add(L1);p5.add(T1);p5.add(L2);p5.add(T2);
		p6.add(L3);p6.add(T3);p6.add(L4);p6.add(T4);
		p7.add(correctSequence); p7.add(CT1);p7.add(CT2);p7.add(CT3);p7.add(CT4);
		p8.add(resultLabel);
		p9.add(resultDisplayArea);
		p10.add(winner);p10.add(winnerPlayer);p10.add(winnerText);p10.add(timeTaken);p10.add(timetakenText);
		gamePanel.add(gameLabel); gamePanel.add(gamenoText);
		centralPanel.setLayout(new BoxLayout(centralPanel,BoxLayout.Y_AXIS));
		centralPanel.add(p1);centralPanel.add(p2);centralPanel.add(p3);centralPanel.add(p4);centralPanel.add(p5);centralPanel.add(p6);centralPanel.add(p7);
		centralPanel.add(p8);centralPanel.add(p9);centralPanel.add(p10);centralPanel.add(gamePanel);
		frame.add(mainPlayerPanel,BorderLayout.WEST);
		frame.add(centralPanel,BorderLayout.CENTER);
		frame.setVisible(true);
	
	}
	
	public	static	void	createThreads()
	{
		// Modify the following decalarations with correct values
		fffP1	=	null;
		fffP2	=	null;
		fffP3	=	null;
		fffP4	=	null;
		fffP5	=	null;
		fffP6	=	null;
		fffP7	=	null;
		fffP8	=	null;
		fffP9	=	null;
		fffP10	=	null;
		ArrayList<Player>	playerList	=	new 	ArrayList<Player>();
		playerList.add(fffP1);playerList.add(fffP2);playerList.add(fffP3);playerList.add(fffP4);playerList.add(fffP5);playerList.add(fffP6);
		playerList.add(fffP7);playerList.add(fffP8);playerList.add(fffP9);playerList.add(fffP10);
		master	=	new	MasterController(playerList,answerBoard,timerTextField,resultDisplayArea,T1,T2,T3,T4,CT1,CT2,CT3,CT4,winnerText,timetakenText,resetB);
	}
	public	static	void	startThreads()
	{
		fffP1.start();fffP2.start();fffP3.start();fffP4.start();fffP5.start();fffP6.start();fffP7.start();fffP8.start();fffP9.start();fffP10.start();
		master.start();	
	}
	public	static	void 	main(String args[])
	{
		ArrayList<Question>	questionList	=	new	ArrayList<Question>();		//	Question List
		displayFrame();
		populateQuestionList(questionList);
		createThreads();
		startThreads();
	
		//	Write your code from here . You have to write action listeners for Display Question , Start and Reset Buttons
		displayQ.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				displayQ.setEnabled(false);
				startB.setEnabled(true);
			}
		});
	}
}
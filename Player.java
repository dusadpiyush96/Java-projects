package fff;

import java.awt.Color;

import javax.swing.JButton;

class Player	extends		Thread
{
	private		int		playerId;		// 	Player id
	private		boolean		suspendFlag;		//	suspend flag
	private static int noOfPlayers=0;
	private JButton button;
	//	Add any other instance field that you think is required
	
	public Player(JButton jb){
		suspendFlag=false;
		playerId=Player.noOfPlayers;
		Player.noOfPlayers++;
		button=jb;
	}
	
	//
	public	void			mysuspend()	{	suspendFlag = true;	}
	public	synchronized	void	myresume()	
	{	
		suspendFlag = false;
		notify();
	}
	//	Add suitable constructor
	
	//	Add any other method that you think is required as per specification
	public	void	run()
	{
		// Complete the implementation for this method
		while(!suspendFlag){
			button.setBackground(Color.GRAY);
			
		}
	}
}

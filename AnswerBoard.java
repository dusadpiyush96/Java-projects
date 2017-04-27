package fff;

import java.util.ArrayList;

class AnswerBoard
{
	private		ArrayList<Answer>	answerList		=	new	ArrayList<Answer>();		// answerList
	private		Question		currentQuestion;							// current question of the game
	private		long			initialTime;								// initial time when any game iteration started 	
	private		boolean			isLocked;
	AnswerBoard()
	{
		answerList.add(null);answerList.add(null);answerList.add(null);answerList.add(null);answerList.add(null);
		answerList.add(null);answerList.add(null);answerList.add(null);answerList.add(null);answerList.add(null);
		isLocked	=	true;
	}
	//	Write your code from here
	//	You can add any other method, instance field of your choice 

	
}

package fff;

class Answer	implements	Comparable<Answer>
{
	private	int	answerSequence[]	=	new	int[4];		//	Answer Sequence
	private	int	playerid;						//	Player id	
	private	long	timetaken;						//	time Taken by the player to answer
	
	//	Accessor Methods
	public	int[]	getAnswerSequence()	{	return 	answerSequence;		}
	public	int	getPlayerid()		{	return	playerid;		}
	public	long	getTimetaken()		{	return	timetaken;		}
	
	// 	Mutator Methods
	public	void	setAnswerSequence(int[]	answerSequence)		{	this.answerSequence	=	answerSequence;		}
	public	void	setPlayerid(int		id)			{	this.playerid		=	id;			}
	public	void	setTimetaken(long	timeTaken)		{	this.timetaken		=	timeTaken;		}
	
	//	compareTo() Method for comparing any two answers by their timetaken value
	public	int	compareTo(Answer other)	
	{	
			if (this.timetaken	>	other.timetaken)	return 	1;
			if (this.timetaken	<	other.timetaken)	return 	-1;
			return 0;	

	}
	//	toString() Method
	public	String	toString()		
	{
		String s1 = "Player Id: "+playerid+"\t";
		String s2 = "Answered Sequence : [ "+ answerSequence[0]+"  "+answerSequence[1]+"  "+answerSequence[2]+"  "+answerSequence[3]+" ] "+"\t";
		String s3 = "Time Taken: "+timetaken;
		return s1+s2+s3;
	}
}// End of class Answer

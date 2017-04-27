package fff;

class Question
{
	private	String		question;						// 	Actual Question
	private	String[]	optionSequence		=	new	String[4];	//	Option Sequence
	private	int		correctSequence[]	=	new	int[4];		//	Correct Sequence
	Question(String question,String[]	optionSequence,	int[]	sequence)	
	{
		this.question		=	question;
		this.optionSequence	=	optionSequence;
		this.correctSequence	=	sequence;
	}
	// Accessor Methods
	public	String		getQuestion()		{	return	question;		}
	public	int[]		getCorrectSequence()	{	return	correctSequence;	}
	public	String[]	getOptionSequence()	{	return  optionSequence;		}
}// End of class Question

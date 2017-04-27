package fff;

import javax.swing.JTextField;

class TimerThread	extends		Thread
{
		private		JTextField		textF;		//	text field whose value is to be updated
		private		boolean			suspendFlag;	//	suspend flag
		public		void			mysuspend()	{	suspendFlag = true;			}
		public		synchronized	void	myresume()	{	suspendFlag = false;	notify();	}
		//	Constructor Method
		TimerThread(JTextField	txt)
		{
			textF		=	txt;
			suspendFlag	=	true;
		}
		
		// //	Add any other method that you think is required as per specification
		
		public void run()
		{
			// Complete the implementation for this method
		}
					
}

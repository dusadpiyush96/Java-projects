package quadraticEqn;

class QuadraticEquation
{
private		int	quadNo;			// Quadratic Equation NO
private 	int 	a;			// A Field
private 	int 	b;			// B Field	
private 	int 	c;			// C Field
private 	boolean isSolved;		// Represents whether Roots have been computed or not
private		boolean	isRootsPossible;	// Represents whether Roots are possible or not
private	static	int	noofobjectsCreated = 0;	// Keeps up the count of the no of instances of this class created so far
private		double	root1;			// First 	Root
private		double	root2;			// Second 	Root

	QuadraticEquation(int a, int b, int c)
	{
		this.a	=	a;
		this.b	=	b;
		this.c	=	c;
		isSolved=	false;
		noofobjectsCreated++;
		quadNo	=	noofobjectsCreated;
	}

	public synchronized void computeRoots()
	{
		if( b*b - 4*a*c < 0) 
		{
			isRootsPossible = false;
			root1 = root2 = Double.NEGATIVE_INFINITY; 
			isSolved = true;
			return;
		}
		double disc	=	Math.sqrt(b*b - 4*a*c);
		root1 		= 	(-b+disc)/(2*a);
		root2 		= 	(-b-disc)/(2*a);
		isRootsPossible = 	true;
		isSolved 	= 	true;
		return;
	}
	public synchronized String toString()
	{
		return "Quadratic Equation No:="+quadNo+"A:= "+a+"B:= "+b+"C:= "+c+"Root 1:="+root1+"Root 2:="+root2;
	}
	public synchronized boolean getisSolved()
	{
		return isSolved;
	}
	public synchronized	int getNoofObjects()
	{
		return noofobjectsCreated;
	}
}// End of class QuadraticEquation
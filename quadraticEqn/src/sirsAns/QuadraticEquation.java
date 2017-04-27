package sirsAns;

class QuadraticEquation
{
private		int	quadNo;
private 	int 	a;
private 	int 	b;
private 	int 	c;
private 	boolean isSolved;
private		boolean	isRootsPossible;
private	static	int	noofobjectsCreated = 0;
private		double	root1;
private		double	root2;

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
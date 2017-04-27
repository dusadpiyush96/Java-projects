package quadraticEqn;

class QuadraticEquationQueue
{
private QuadraticEquation[]	quadQueue	=	new QuadraticEquation[10]; // queue with capacity 10
private	int	tail;	// tail value
private	int	head;	// head value
private	int	size;	// size field
	QuadraticEquationQueue()
	{
		head = tail = size =0;
	}
	public synchronized QuadraticEquation remove() throws InterruptedException
	{
		while(size == 0) wait();
		QuadraticEquation quad = quadQueue[head];
		head++;
		size--;
		if(head == quadQueue.length)
			head =0;
		notifyAll();
	return quad;
	}
	public synchronized void add(QuadraticEquation quad) throws InterruptedException
	{
		while(size == quadQueue.length) wait();
		quadQueue[tail] = quad;
		tail++;
		size++;
		if(tail == quadQueue.length)
		tail = 0;
		notifyAll();
	}
	public synchronized boolean isFull()
	{
	return size == quadQueue.length;
	}
	public synchronized boolean isEmpty()
	{
	return size == 0;
	}
}// End of class QuadraticEquationQueue


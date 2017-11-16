public class Fibonacci extends Thread {
	
	int n;
	int prev = 0;
	int newFib = 1;
	CustomQueue fibBuffer = new CustomQueue();
	
	public Fibonacci(int tempn) {
		n = tempn;
	}
	
	synchronized public void run() {
		while(newFib <= n) {
			waitCheck();
			fibBuffer.enQueue(newFib + prev);
			int temp = newFib;
			newFib = newFib + prev;
			prev = temp;
		}
		waitCheck();
		fibBuffer.enQueue(n + 1);
	}
	
	public void waitCheck() {
		while(fibBuffer.getSize() == 10) 
		{
			try {
				wait();
			}
			catch(Exception e) {
			}
		}		
	}
}
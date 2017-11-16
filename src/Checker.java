import java.util.ArrayList;

public class Checker extends Thread {
	
	int n;
	int numFound = 0;
	int currentPrime = 2;
	int currentFib = 0;
	ArrayList<Integer> primeAndFibList = new ArrayList<Integer>();
	Prime prime;
	Fibonacci fibonacci;
	
	public Checker(int tempn) {
		n = tempn;
		prime = new Prime(n);
		fibonacci = new Fibonacci(n);
	}	

	synchronized public void run() {
		prime.start();
		fibonacci.start();
		while((currentPrime <= n) || (currentFib <= n)) {
			//if the two numbers are the same, add them to the arrayList and search for the next values
			if(currentPrime == currentFib) {
				primeAndFibList.add(currentPrime);
				numFound++;
				getNewPrime();
				getNewFib();
			}
			else if(currentFib > currentPrime) {
				getNewPrime();
			}
			else if(currentPrime > currentFib) {
				getNewFib();
			}
		}
		printResults();
	}
	
	synchronized public void getNewPrime() {		
		//makes Checker wait until there is a value to take from Prime's queue
		while(prime.primeBuffer.getSize() == 0) {
			;
		}
		currentPrime = prime.primeBuffer.peek();
		prime.primeBuffer.deQueue();
		synchronized (prime) {
			prime.notify();
		}
	}
	
	synchronized public void getNewFib() {
		//makes Checker wait until there is a value to take from Fibonacci's queue
		while(fibonacci.fibBuffer.getSize() == 0) {
			;
		}
		currentFib = fibonacci.fibBuffer.peek();
		fibonacci.fibBuffer.deQueue();
		synchronized (fibonacci) {
			fibonacci.notify();
		}
	}
	
	// print out the arrayList of matched values, and the number that occured.
	public void printResults() {
		System.out.println();
		if(primeAndFibList.size() == 0)
		{
			System.out.println("[None]");
		}
		else {
			for(int i = 0; i < primeAndFibList.size() - 1; i++) {
				System.out.print(primeAndFibList.get(i) + ", ");
			}
			System.out.println(primeAndFibList.get(primeAndFibList.size() - 1));
		}
		System.out.println("\nNumber of prime and fibonacci number matches: " + numFound);
	}

}

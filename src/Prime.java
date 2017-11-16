public class Prime extends Thread {
	
	int n;
	CustomQueue primeBuffer = new CustomQueue();
	
	public Prime(int tempn) {
		n = tempn;
	}
	
	synchronized public void run() {
		for(int newPrime = 2; newPrime <= n; newPrime++) {
			waitCheck();
			if (newPrime <= 3) {
				primeBuffer.enQueue(newPrime);
			}
			else {
				boolean prime = true;
				for(int i = 2; i < newPrime/2; i++) {
					if (newPrime%i == 0) {
						prime = false;
						break;
					}
				}
				if(prime) {
					primeBuffer.enQueue(newPrime);
				}
			}
		}
		waitCheck();
		primeBuffer.enQueue(n + 1);
	}
	
	public void waitCheck() {
		while(primeBuffer.getSize() == 10) 
		{
			try {
				wait();
			}
			catch(Exception e) {
			}
		}		
	}
}

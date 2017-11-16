import java.util.Scanner;
public class FibAndPrimeDriver {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter upper bound integer to find numbers that are"
							+ " both fibonacci numbers and prime:");
		int n = scan.nextInt();
		scan.close();
		
		Checker checker = new Checker(n);
		checker.start();		
	}
}
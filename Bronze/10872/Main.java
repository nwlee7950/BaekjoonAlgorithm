import java.util.Scanner;

public class Main {
	static int sum = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println(factorial(n));
	}

	private static int factorial(int n) {
		if(n == 1)
			return sum;
		else if(n == 0)
			return 1;
		
		sum *= n;
		return factorial(--n);
	}
}
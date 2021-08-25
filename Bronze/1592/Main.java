import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int count = 0;
		int[] num = new int[N];
		int current = 0;
		// 0 1 2 3 4
		while(true) {
			count++;
			num[current]++;
			if(num[current] == M) {
				System.out.println(count-1);
				break;
			}
			if(num[current] % 2 == 1) 
				current += L;
			else if(num[current] % 2 == 0)
				current -= L;
			
			if(current >= N)
				current -= N;
			else if(current < 0)
				current += N;
		}
	}
}
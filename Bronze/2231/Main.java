import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		boolean findYN = false;
		
		for(int i = 1; i <= num; i++) {
			int n = i;
			int sum = 0;
			
			while(n != 0) {
				sum += (n % 10);
				n /= 10;
				
			}
			int result = sum + i;
			
			if(result == num) {
				System.out.println(i);
				findYN = true;
				break;
			}
		}
		if(!findYN)
			System.out.println("0");
	}
}
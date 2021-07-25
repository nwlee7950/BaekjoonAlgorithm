import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int[] num = new int[a];
		int sum = 0;
		
		for(int i = 0; i < a; i++) {
			int count = 0;
			num[i] = sc.nextInt();
			if(num[i] <= 1)
				continue;
			else {
				for(int j = 2; j <= num[i]; j++) {
					if(num[i] % j == 0)
						count++;
					if(count > 1)
						break;
				}
				if(count == 1)
					sum++;
			}
			
		}
		System.out.println(sum);
	}
}
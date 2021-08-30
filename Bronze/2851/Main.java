import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int result = 0;
		
		for(int i=0; i<10; i++)
			arr[i] = sc.nextInt();
		
		for(int i=0; i<10; i++) {
			int sum = 0;
			for(int j=0; j<=i; j++)
				sum += arr[j];
			
			if(Math.abs(100 - result) == Math.abs(100 - sum)) {
				if(result > sum)
					result = result;
				else
					result = sum;
			}
			else if(Math.abs(100 - result) > Math.abs(100 - sum))
				result = sum;
		}
		System.out.println(result);
	}
}
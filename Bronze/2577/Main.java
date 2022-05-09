import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int[] arr = new int[10];
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int n;
		
		int num = a * b * c;

		while(true) {
			if(num == 0) {
				break;
			}
			n = num % 10;
			arr[n]++;
			num /= 10;
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
	}
}
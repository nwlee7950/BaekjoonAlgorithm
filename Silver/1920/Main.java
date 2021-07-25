import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		int m = sc.nextInt();
		int[] b = new int[m];
		for(int j = 0; j < m; j++) {
			b[j] = sc.nextInt();
		}
		
		for(int j = 0; j < m; j++) {
			int count = 0;
			for(int i = 0; i < n; i++) {
				if(b[j] == a[i]) {
					System.out.println("1");
					count++;
					break;
				}
			}
			if(count == 0)
				System.out.println("0");
		}
	}
}
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i = 1; i <= t; i++) {
			
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[][] num = new int [k+2][n];
			
			for(int j = 0; j <= k; j++) {
				int sum = 0;
				for(int a = 0; a < n; a++) {
					if(j == 0) {
						num[j][a] = a + 1;
						sum += num[j][a];
						num[j+1][a] = sum;
					}

					else{
						sum += num[j][a];
						num[j+1][a] = sum;
					}
				}
			}
			
			
			System.out.println(num[k][n-1]);
		}
		
			
	}
}
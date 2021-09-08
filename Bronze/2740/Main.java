import java.util.Scanner;


public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		M = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr2 = new int[M][K];
				
		for(int i=0; i<M; i++) {
			for(int j=0; j<K; j++) {
				arr2[i][j] = sc.nextInt();
			}
		}
		
		int[][] ans = new int[N][K];
		for(int i=0; i<N; i++) {
			for(int j=0; j<K; j++) {
				for(int n=0; n<M; n++) {
					ans[i][j] += arr[i][n] * arr2[n][j];
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<K; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}
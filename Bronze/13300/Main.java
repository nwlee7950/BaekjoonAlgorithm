import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int[] femaleCount = new int[6];
		int[] maleCount = new int[6];
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] stu = new int[N][6];
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			stu[gender][grade-1]++;
		}
		for(int i=0; i<=1; i++) {
			for(int j=0; j<6; j++) {
				if(stu[i][j] != 0) {
					while(true) {
						if(stu[i][j] <= 0)
							break;
						stu[i][j] -= K;
						sum++;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
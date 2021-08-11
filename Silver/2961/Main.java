import java.io.*;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] sour;
	static int[] bitter;
	static long gap;
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			sour[i] = Integer.parseInt(str[0]);
			bitter[i] = Integer.parseInt(str[1]);
		}
		gap = Long.MAX_VALUE;
		solve(0, 1, 0);
		sb.append(gap);
		System.out.print(sb);
	}
	static void solve(int index, int sourSum, int bitterSum) {
		if(N == 1) {
			sourSum *= sour[0];
			bitterSum += bitter[0];
			gap = Math.abs(sourSum - bitterSum);
			return;
		}
		if(index == N) {
			if(Math.abs(sourSum - bitterSum) < gap && bitterSum != 0)
				gap = Math.abs(sourSum - bitterSum);
			
			return;
		}
		solve(index+1, sourSum * sour[index], bitterSum + bitter[index]);
		solve(index+1, sourSum, bitterSum);
	}
}
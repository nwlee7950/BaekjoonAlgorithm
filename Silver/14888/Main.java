import java.io.*;

public class Main {
	static int MAX, MIN, N;
	static int[] arr, opNum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		opNum = new int[4];
		MAX = Integer.MIN_VALUE;
		MIN = Integer.MAX_VALUE;
		
		String[] str = br.readLine().split(" ");
		for(int i=0; i<str.length; i++)
			arr[i] = Integer.parseInt(str[i]);
		
		str = br.readLine().split(" ");
		for(int j=0; j<4; j++)
			opNum[j] = Integer.parseInt(str[j]);

		solve(0, arr[0]);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	private static void solve(int idx, int sum) {
		if(idx == N-1) {
			MAX = Math.max(MAX, sum);
			MIN = Math.min(MIN, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(opNum[i] == 0)
				continue;
			
			opNum[i]--;
			if(i == 0)
				solve(idx+1, sum + arr[idx+1]);
			else if(i == 1)
				solve(idx+1, sum - arr[idx+1]);
			else if(i == 2)
				solve(idx+1, sum * arr[idx+1]);
			else if(i == 3)
				solve(idx+1, sum / arr[idx+1]);
			
			opNum[i]++;
		}
	}
}
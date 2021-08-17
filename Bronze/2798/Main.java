import java.io.*;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	static int[] arr;
	static int[] ans;
	static int[] temp;
	static boolean[] sel;
	static int max;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] str = br.readLine().split(" ");
	    N = Integer.parseInt(str[0]);
	    M = Integer.parseInt(str[1]);
	    arr = new int[N];
	    ans = new int[N];
	    temp = new int[N];
	    sel = new boolean[N];
	    str = br.readLine().split(" ");
	    max = Integer.MIN_VALUE;
	    for(int i=0; i<N; i++)
	    	arr[i] = Integer.parseInt(str[i]);
	    solve(0, 0);
		System.out.println(max);
	}

	private static void solve(int idx, int sum) {
		if(sum > M)
			return;
		if(idx == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(sel[i])
				continue;
			temp[i] = arr[i];
			sel[i] = true;
			solve(idx+1, sum+temp[i]);
			sel[i] = false;
		}
	}
}
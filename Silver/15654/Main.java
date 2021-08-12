import java.io.*;
import java.util.Arrays;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int[] ans;
	static boolean[] sel;
	public static StringBuilder sb = new StringBuilder();
	
	private static void solve(int idx) {
		if(idx == M) {
			for(int i=0; i<M; i++)
					sb.append(ans[i]).append(" ");
			sb.append("\n");	
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(sel[i])
				continue;
			sel[i] = true;
			ans[idx] = arr[i];
			solve(idx + 1);
			sel[i] = false;
		}
	}
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N];
        ans = new int[M];
        sel = new boolean[N];
        String[] str2 = br.readLine().split(" ");
        for(int i=0; i<N; i++)
        	arr[i] = Integer.parseInt(str2[i]);
        Arrays.sort(arr);
        solve(0);
        System.out.println(sb);
    }
}


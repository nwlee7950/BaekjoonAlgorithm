import java.io.*;
import java.util.Arrays;

public class Main{
	static int N, M;
	static int[] arr;
	static int[] ans;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
        arr = new int[N];
        ans = new int[M];
        str = br.readLine().split(" ");
        for(int i=0; i<N; i++)
        	arr[i] = Integer.parseInt(str[i]);
        Arrays.sort(arr);
        solve(0, 0);
        System.out.println(sb);
	}

	private static void solve(int idx, int start) {
		if(idx == M) {
			for(int i=0; i<M; i++)
				sb.append(ans[i]).append(" ");
			sb.append("\n");
			
			return;
		}
		
		for(int j=start; j<N; j++) {
			ans[idx] = arr[j];
			solve(idx+1, j);
			}
		}
	}

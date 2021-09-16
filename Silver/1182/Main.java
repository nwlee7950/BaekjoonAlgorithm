import java.io.*;
import java.util.StringTokenizer;

public class Main {
		static int[] arr;
		static int N;
		static int S;
		static int count;
	public static void main(String[] args) throws IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        count = 0;
        st = new StringTokenizer(br.readLine(), " ");
        
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0);
        
        if(S == 0)
        	count--;
        System.out.println(count);
	}
	private static void solve(int idx, int sum) {
		if(idx == N) {
			if(sum == S)
				count++;
			
			return;
		}
		
		solve(idx + 1, sum + arr[idx]);
		solve(idx + 1, sum);
	}
}
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	private static void solve(int idx, int start) {
		if(idx == M) {
			for(int i=0; i<M; i++) 
					sb.append(arr[i]).append(" ");
			sb.append("\n");	
			return;
		}
		for(int i=start; i<=N; i++) {
			arr[idx] = i;
			solve(idx + 1, i);
		}
	}
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[M];

        solve(0, 1);
        System.out.println(sb);
    }
}


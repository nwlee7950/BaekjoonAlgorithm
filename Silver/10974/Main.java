import java.io.*;
import java.util.Arrays;

public class Main{
	static int N;
	static int[] arr;
	static boolean sel[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sel = new boolean[N];
        solve(0);
	}

	private static void solve(int idx) {
		if(idx == N) {
			for(int i=0; i<N; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			
			return;
		}
		
		for(int j=0; j<N; j++) {
			if(sel[j]) continue;
			arr[idx] = j+1;
			sel[j] = true;
			solve(idx+1);
			sel[j] = false;
			}
		}
	}

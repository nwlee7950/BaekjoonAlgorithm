import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Main{
	static int N, M;
	static int[] arr;	
	static int[] ans;	
	static LinkedHashSet<String> set;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
        arr = new int[N];
        ans = new int[N];
        set = new LinkedHashSet<>();
        str = br.readLine().split(" ");
        for(int i=0; i<N; i++)
        	arr[i] = Integer.parseInt(str[i]);
        Arrays.sort(arr);
        solve(0, 0);
        set.forEach(System.out::println);
	}

	private static void solve(int idx, int start) {
		if(idx == M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++)
				sb.append(ans[i]).append(" ");
			set.add(sb.toString());
			
			return;
		}
		
		for(int j=start; j<N; j++) {
			ans[idx] = arr[j];
			solve(idx+1, j);
			}
		}
	}

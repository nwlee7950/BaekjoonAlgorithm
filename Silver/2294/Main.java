import java.io.*;
import java.util.Arrays;

public class Main {
	static int N;
	static int K;
	static int[] coin;
	static int[] dp;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] str = br.readLine().split(" ");
    	N = Integer.parseInt(str[0]);
    	K = Integer.parseInt(str[1]);
    	coin = new int[N];
    	dp = new int[K+1];
    	for(int i=0; i<N; i++) {
    		coin[i] = Integer.parseInt(br.readLine());
    	}
    	Arrays.fill(dp, 100001);
    	dp[0] = 0;
    	
    	for(int i=0; i<N; i++) {
    		for(int j=coin[i]; j<=K; j++) {
    			dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
    		}
    	}
    	if(dp[K] == 100001)
    		System.out.println(-1);
    	else
    		System.out.println(dp[K]);
    }
}
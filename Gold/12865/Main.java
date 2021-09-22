import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] str = br.readLine().split(" ");
       int N = Integer.parseInt(str[0]);
       int K = Integer.parseInt(str[1]);
       int[] weight = new int[N+1];
       int[] value = new int[N+1];
       
       for(int i=1; i<=N; i++) {
    	   str = br.readLine().split(" ");
    	   weight[i] = Integer.parseInt(str[0]);
    	   value[i] = Integer.parseInt(str[1]);
       }
       int[] dp = new int[K+1];
       
       for(int i=1; i<=N; i++) {
    	   for(int j=K; j>=weight[i]; j--) {
    		   dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
    	   }
       }
       System.out.println(dp[K]);
    }
}
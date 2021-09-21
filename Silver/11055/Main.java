import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       int[] arr = new int[N+1];
       int[] dp = new int[N+1];

       String[] str = br.readLine().split(" ");
       for(int i=1; i<=N; i++) {
    	   arr[i] = Integer.parseInt(str[i-1]);
       }
       
       dp[1] = arr[1];
       int ans = dp[1];
       
       for(int i=2; i<=N; i++) {
    	   dp[i] = arr[i];
    	   for(int j=1; j<i; j++) {
    		   if(arr[i] > arr[j]) {
    			   dp[i] = Math.max(dp[i], dp[j] + arr[i]);
    		   }
    	   }
    	   ans = Math.max(ans, dp[i]);
       }
       System.out.println(ans);
    }
}
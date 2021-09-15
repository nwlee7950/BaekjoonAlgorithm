import java.io.*;
import java.util.*;

public class Main{
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      StringBuilder sb = new StringBuilder();
      
      int N = Integer.parseInt(br.readLine());
      int[][] dp = new int[N][3];
      
      for(int i=0; i<N; i++) {
    	  st = new StringTokenizer(br.readLine(), " ");
    	  
    	  dp[i][0] = Integer.parseInt(st.nextToken());
    	  dp[i][1] = Integer.parseInt(st.nextToken());
    	  dp[i][2] = Integer.parseInt(st.nextToken());
      }
      
      for(int i=1; i<N; i++) {
    	  dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
    	  dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]);
    	  dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]);
      }
      System.out.println( Math.min( Math.min(dp[N-1][0], dp[N-1][1]) , dp[N-1][2] ) );
   }
}
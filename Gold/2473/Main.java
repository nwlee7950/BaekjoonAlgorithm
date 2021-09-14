import java.io.*;
import java.util.*;

public class Main{
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      
      int N = Integer.parseInt(br.readLine());
      int[] arr = new int[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<N; i++) {
    	  arr[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(arr);

      int[] ans = new int[3];
      long min = Long.MAX_VALUE;
      
      for(int i=0; i<N; i++) {
          int start = i+1;
          int end = N-1;
          
    	  while(start < end) {
        	  long sum = (long)arr[i] + (long)arr[start] + (long)arr[end];
        	  
        	  if(Math.abs(sum) < min) {
        		  min = Math.abs(sum);
        		  ans[0] = arr[i];
        		  ans[1] = arr[start];
        		  ans[2] = arr[end];
        	  }
        	  
        	  if(sum < 0) {
        		  start++;
        	  } else {
        		  end--;
        	  }
          }
      }
      
      System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
   }
}
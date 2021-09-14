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
      
      int start = 0;
      int end = N-1;
      int[] ans = new int[2];
      int min = Integer.MAX_VALUE;
      
      while(start < end) {
    	  int left_num = arr[start];
    	  int right_num = arr[end];
    	  if(Math.abs(left_num + right_num) < min) {
    		  min = Math.abs(left_num + right_num);
    		  ans[0] = arr[start];
    		  ans[1] = arr[end];
    	  }
    	  
    	  if(left_num + right_num < 0) {
    		  start++;
    	  } else {
    		  end--;
    	  }
      }
      System.out.println(ans[0] + " " + ans[1]);
   }
}
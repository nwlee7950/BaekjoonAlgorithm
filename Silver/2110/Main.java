import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st;
	      st = new StringTokenizer(br.readLine());
	      int N = Integer.parseInt(st.nextToken());
	      int C = Integer.parseInt(st.nextToken());
	      int[] arr = new int[N];
	      int ans = 0;
	      
	      for(int i = 0; i < N; i++) {
	    	  arr[i] = Integer.parseInt(br.readLine());
	      }
	      Arrays.sort(arr);
	      int left = 1;
	      int right = arr[N-1] - arr[0];
	      
	      while(left <= right) {
	    	  int mid = (left + right) / 2;
	    	  int prev = arr[0];
	    	  int count = 1;
	    	  
	    	  for(int i = 1; i < N; i++) {
	    		  if(arr[i] - prev >= mid) {
	    			  count++;
	    			  prev = arr[i];
	    		  }
	    	  }
	    	  
	    	  if(count >= C) {
	    		  ans = mid;
	    		  left = mid + 1;
	    	  } else {
	    		  right = mid - 1;
	    	  }
	      }
	      System.out.println(ans);
	}
}
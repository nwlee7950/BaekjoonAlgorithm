import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st;
	      st = new StringTokenizer(br.readLine());
	      int N = Integer.parseInt(st.nextToken());
	      int M = Integer.parseInt(st.nextToken());
	      int[] arr = new int[N];
	      
	      st = new StringTokenizer(br.readLine());
	      int left = 0;
	      int right = 0;
	      for(int i = 0; i < N; i++) {
	    	  arr[i] = Integer.parseInt(st.nextToken());
	    	  right += arr[i];
	    	  left = left < arr[i] ? arr[i] : left;
	      }
	      Arrays.sort(arr);
	      left = arr[N-1];
	      
	      while(left <= right) {
	    	  int count = 0;
	    	  int sum = 0;
	    	  int mid = (left + right) / 2;
	    	  
	    	  for(int i = 0; i < N; i++) {
	    		  if(sum + arr[i] > mid) {
	    			  sum = 0;
	    			  count++;
	    		  }
	    		  sum += arr[i];
	    	  }
	    		  if(sum != 0)
	    			  count++;
	    		  
	    		  if(count <= M)
	    			  right = mid - 1;
	    		  else
	    			  left = mid + 1;
	    	  
	      }
	      System.out.println(left);
	}
}
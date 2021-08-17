import java.io.*;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    int min = 0;
	    int n = Integer.parseInt(br.readLine());
	    
	    while(true) {
	    	if(n%5 == 0) {
	    		min += n/5;
	    		System.out.println(min);
	    		break;
	    	}
	    	else {
	    		n -= 3;
	    		min++;
	    	}
	    	if(n<0) {
	    		System.out.println(-1);
	    		break;
	    	}
	    }
}
}
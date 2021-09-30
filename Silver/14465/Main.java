import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        
        for(int i = 1; i <= B; i++) {
        	int pos = Integer.parseInt(br.readLine());
        	arr[pos] = 1;
        }
    	
        int count = 0;
        int MIN = Integer.MAX_VALUE;
        int start = 1;
        for(int end = 1; end <= N; end++) {
        	if(arr[end] == 1)
        		count++;
        	if(end - start == K-1) {
        		MIN = Math.min(MIN, count);
        		if(arr[start] == 1)
        			count--;
        		start++;
        	}
        }
        System.out.println(MIN);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[1000001];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int ice = Integer.parseInt(st.nextToken());
        	int pos = Integer.parseInt(st.nextToken());
        	arr[pos] = ice;
        }
    	
        int sum = 0;
        int range = K*2 + 1;
        int MAX = Integer.MIN_VALUE;
        
        for(int i = 0; i < 1000001; i++) {
        	if(i >= range) {
        		sum -= arr[i - range];
        	}
        	sum += arr[i];
        	MAX = Math.max(MAX, sum);
        }
        System.out.println(MAX);
    }
}
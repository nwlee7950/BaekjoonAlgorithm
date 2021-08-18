import java.io.*;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] arr;
	static int[] temp;
	static boolean[] sel;
	static int max;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	N = Integer.parseInt(br.readLine());
    	max = Integer.MIN_VALUE;
    	sel = new boolean[N];
    	arr = new int[N];
    	temp = new int[N];
    	String[] str = br.readLine().split(" ");
    	for(int i=0; i<str.length; i++)
    		arr[i] = Integer.parseInt(str[i]);
    	solve(0);
    	System.out.println(max);
    }
    static void solve(int idx) {
    	if(idx == N) {
    		int sum = 0;
    		for(int i=0; i<N-1; i++)
    			sum += Math.abs(temp[i] - temp[i+1]);
    		max = Math.max(max, sum);
    	}
    	
    	for(int i=0; i<N; i++) {
    		if(sel[i])
    			continue;
    		temp[idx] = arr[i];
    		sel[i] = true;
    		solve(idx+1);
    		sel[i] = false;
    	}
        }
    }
import java.io.*;
import java.util.PriorityQueue;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int sum = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        OUT : for(int i=n; i<=m; i++) {
        	int count = 0;
        	for(int j=1; j<=i; j++) {
        		if(i%j == 0)
        			count++;
        	}
        	if(count == 2) {
        		q.add(i);
            	sum += i;
        	}
        	
        }
        if(q.isEmpty())
        	System.out.println(-1);
        else {
        	sb.append(sum).append("\n");
        	sb.append(q.peek());
        	System.out.println(sb);
        }
	}
}

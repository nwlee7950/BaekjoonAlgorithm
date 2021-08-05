import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(pq.isEmpty())
					bw.write(0 + "\n");
				else
					bw.write(pq.poll() + "\n");
			}
			else
				pq.offer(num);
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
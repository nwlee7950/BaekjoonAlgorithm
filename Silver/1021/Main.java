import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<Integer>();
		int count = 0;
		
		String[] str = br.readLine().split(" ");
		for(int i=1; i<=Integer.parseInt(str[0]); i++) {
			dq.addLast(i);
		}
		
		String[] num = br.readLine().split(" ");

		for(int j=0; j<Integer.parseInt(str[1]); j++) {
			while(true) {
				int index = 0;
				Iterator<Integer> it = dq.iterator();
				while(it.hasNext()) {
					if(it.next() == Integer.parseInt(num[j]))
						break;
					index++;
				}
				if(dq.peekFirst() == Integer.parseInt(num[j])) {
					dq.pollFirst();
					break;
				}
				else if(index > dq.size()/2) {
					dq.addFirst(dq.pollLast());
					count++;
					
				}
				else {
					dq.addLast(dq.pollFirst());
					count++;
				}
			}
		}
		sb.append(count);
		br.close();
		System.out.println(sb);
	}
}
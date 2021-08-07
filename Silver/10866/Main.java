import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<Integer>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			
			if(str[0].equals("push_front")) {
				dq.addFirst(Integer.parseInt(str[1]));
			}
			else if(str[0].equals("push_back")) {
				dq.addLast(Integer.parseInt(str[1]));
			}
			else if(str[0].equals("pop_front")) {
				if(dq.isEmpty())
					sb.append(-1).append("\n");
				else 
					sb.append(dq.pollFirst()).append("\n");
					
			}
			else if(str[0].equals("pop_back")) {
				if(dq.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(dq.pollLast()).append("\n");
			}
			else if(str[0].equals("size"))
				sb.append(dq.size()).append("\n");
			else if(str[0].equals("empty")) {
				if(dq.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			}
			else if(str[0].equals("front")) {
				if(dq.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(dq.getFirst()).append("\n");
			}
			else if(str[0].equals("back")) {
				if(dq.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(dq.getLast()).append("\n");
			}
		}
		br.close();
		System.out.println(sb);
		
	}
}
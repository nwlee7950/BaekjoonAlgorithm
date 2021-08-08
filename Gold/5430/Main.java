import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<Integer>();
		int tc = Integer.parseInt(br.readLine());
		
		TC : for(int i=0; i<tc; i++) {
			String[] command = br.readLine().split("");
			int arr_size = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			for(int j=0; j<arr_size; j++) 
				dq.add(Integer.parseInt(st.nextToken()));
				
			boolean isReverse = false;
			for(int k=0; k<command.length; k++) {
				if(command[k].equals("R")) {
					isReverse = !isReverse;
					continue;
				}
				else if(command[k].equals("D")) {
					if(dq.isEmpty()) {
						sb.append("error").append("\n");
						continue TC;
					}
					else {
						if(isReverse) 
							dq.pollLast();				
						else 
							dq.pollFirst();	
					}
				}
			}
			sb.append("[");
			while (!dq.isEmpty()) {
				if(isReverse) {
					if(dq.size() == 1) {
						sb.append(dq.removeLast());
						break;
					}
					sb.append(dq.removeLast()).append(",");
				} 
				else {
					if(dq.size() == 1) {
						sb.append(dq.removeLast());
						break;
					}
					sb.append(dq.removeFirst()).append(",");
				}
			}	
			sb.append("]").append("\n");
		}
		br.close();
		System.out.print(sb);
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) 
			queue.add(Integer.parseInt(br.readLine()));
		
		int num = 0;
		int count = 0;
		while(count != n) {
			stack.push(++num);
			sb.append("+").append("\n");
			while(!stack.isEmpty() && stack.peek().intValue() == queue.peek().intValue()) {
				stack.pop();
				queue.poll();
				sb.append("-").append("\n");
				count++;
			}
			if(!stack.isEmpty() && stack.peek().intValue() > queue.peek().intValue())
				break;
		}
		
		if (!stack.isEmpty()) {
			System.out.println("NO");
			return;
		}
		System.out.println(sb);
	}
}
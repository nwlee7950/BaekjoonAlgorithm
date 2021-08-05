import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Deque<Integer> dq = new ArrayDeque<Integer>();
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) 
			dq.offer(i);
		
		
		while(true) {
			if(dq.size() == 1)
				break;
			dq.pollFirst();
			dq.offerLast(dq.peek());
			dq.pollFirst();
		}
		System.out.println(dq.peek());
	}
}
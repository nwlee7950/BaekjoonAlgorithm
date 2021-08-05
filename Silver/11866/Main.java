import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {		
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int gap = sc.nextInt();
		int j = 0;
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}

		while(true) {
			if(queue.isEmpty() == true)
				break;
			j++;
			if(j % gap == 0) {
				queue2.offer(queue.peek());
				queue.remove();
			}
			else {
				queue.add(queue.poll());
			}
		}
		System.out.print("<");
		for(int k=0; k<n; k++) {
			if(k == n-1)
				System.out.print(queue2.poll());
			else
				System.out.print(queue2.poll() +", ");
		}
		System.out.println(">");
	}
}
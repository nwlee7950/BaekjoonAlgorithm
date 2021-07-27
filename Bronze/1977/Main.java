import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int sum = 0;
		List<Integer> li = new ArrayList<Integer>();
		
		for(int i = 0; i <= 100; i++) {
			if(i * i >= m && i * i <= n) {
				sum += i * i;
				li.add(i * i);
			}
			
			if(i * i > n) {
				break;
			}
		}
		
		if(li.size() == 0)
			System.out.println(-1);
		else {
			Collections.sort(li);
			System.out.println(sum);
			System.out.println(li.get(0));
		}
	}
}
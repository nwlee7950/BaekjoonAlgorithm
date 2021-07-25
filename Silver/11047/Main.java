import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int money = sc.nextInt();
		int count = 0;
		int[] coin = new int[n];
		int sum = 0;
		int temp = n-1;
		
		for(int i = 0; i < n; i++) {
			coin[i] = sc.nextInt();
		}
		while(true) {
			if(money == 0)
				break;
			else {
				if(coin[temp] <= money) {
					money -= coin[temp];
					count++;
				}
				else
					temp--;
			}
		}
		System.out.println(count);
	}
}
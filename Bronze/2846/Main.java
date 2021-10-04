import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int MAX = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		int sum = 0;
		for(int i = 1; i < N; i++) {
			if(arr[i] > arr[i-1]) {
				sum += arr[i] - arr[i-1];
			} else {
				sum = 0;
			}
			MAX = Math.max(MAX, sum);
		}
		System.out.println(MAX);
	}
}
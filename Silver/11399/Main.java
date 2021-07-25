import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		int temp = 0;
		
		for(int i = 0; i < n; i++) 
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		for(int j = 0; j < n; j++) {
			temp += arr[j];
			sum += temp;
		}
		System.out.println(sum);
	}
}
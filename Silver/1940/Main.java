import java.io.*;
import java.util.Arrays;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(str[i]);
		
		Arrays.sort(arr);
		int count = 0;
		int start = 0;
		int end = n-1;
		
		while(start < end) {
			int sum = arr[start] + arr[end];
			
			if(sum == m) {
				count++;
				start++;
				end--;
			} else if(sum < m) {
				start++;
			} else {
				end--;
			}
		}
		System.out.println(count);
	}

}
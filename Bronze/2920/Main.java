import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int[] arr = new int[8];
		for(int i = 0; i<str.length;i++)
			arr[i] = Integer.parseInt(str[i]);
		int count = 0;
		if(arr[0] == 1) {
			for(int i=0; i<arr.length; i++) {
				if(arr[i] == i+1)
					count++;
			}
			if(count == 8)
				System.out.println("ascending");
			else
				System.out.println("mixed");
		}
		else if(arr[0] == 8) {
			for(int i=0; i<arr.length; i++) {
				if(arr[i] == 8-i)
					count++;
			}
			if(count == 8)
				System.out.println("descending");
			else
				System.out.println("mixed");
		}
		else
			System.out.println("mixed");
	}
}
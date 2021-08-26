import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int sum = 0;
			int count = 0;
			String str = br.readLine();
			
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == 'O') {
					count++;
				}
				else {
					count = 0;
				}
				sum += count;
			}
			System.out.println(sum);
		}
	}
}
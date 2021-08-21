import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = 666;
		while(true) {
			String str = Integer.toString(num);
			if(str.contains("666")) 
				N--;
			if(N == 0) {
				System.out.println(num);
				break;
			}
			num++;
		}
	}
}